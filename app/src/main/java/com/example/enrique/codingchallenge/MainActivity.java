package com.example.enrique.codingchallenge;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.enrique.codingchallenge.Retrofit.ApiResponse;
import com.example.enrique.codingchallenge.Retrofit.OsrmAPI;
import com.example.enrique.codingchallenge.Retrofit.OsrmService;
import com.example.enrique.codingchallenge.Utils.ComputeTripPrice;
import com.example.enrique.codingchallenge.Utils.Coords;
import com.example.enrique.codingchallenge.Model.ExtendedJourney;
import com.example.enrique.codingchallenge.Model.InitialJourney;
import com.example.enrique.codingchallenge.Utils.UserTrip;
import com.example.enrique.codingchallenge.Utils.Utils;
import com.example.enrique.codingchallenge.Views.ResultsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity{

    private JSONArray initialData;
    private static OsrmAPI servicio;

    ArrayList<ExtendedJourney> extendedJourneyArrayList = new ArrayList<>();
    private Map<String, UserTrip> dateTripMap = new HashMap<String, UserTrip>();
    private static boolean clicked;

    @Override
    protected void onResume() {
        super.onResume();
        clicked = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        servicio = OsrmService.getInstance();
        clicked = false;
        getInitialData();
    }

   private void getInitialData(){
        // from http://yasiradnan.com/parse-local-json-file-in-android/
        BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources()
                .openRawResource(R.raw.initialjson)));
        StringBuilder jsonBuilder = new StringBuilder();
        try {
            for (String line = null; (line = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(line).append("\n");
            }
            //Parse Json
            JSONTokener tokener = new JSONTokener(jsonBuilder.toString());
            initialData = new JSONArray(tokener);
        } catch (IOException | JSONException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Inital data loaded successfully", Toast.LENGTH_SHORT).show();
   }

    public void generateReport(View view){
        if(clicked == false){
            getRemoteData();
            clicked = true;
        }
    }

    public void getRemoteData(){

        for (int index = 0; index < initialData.length(); index++) {
            JSONObject jsonObject;
             try {
                jsonObject = initialData.getJSONObject(index);
                double[] startLocationCoords = Utils.getLocationCoords(jsonObject, "start_loc");
                double[] endLocationCoords = Utils.getLocationCoords(jsonObject, "end_loc");

                 Coords [] coords = new Coords [] {new Coords(startLocationCoords),
                         new Coords(endLocationCoords)};
                 new getAPIReply().execute(coords); //ApliReply

            } catch (JSONException e) {
                Toast.makeText(this, "Problem fetching the remote data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private int checkTripNumber(int userId, String region, String tripDate) {
        // http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        // returns the number of trips for a user in a date+region
        //Map: Key = date+region, Value = ArrayList<Usertrip (User_id, numTripsDate)>

        UserTrip userTrip = new UserTrip(userId, region, 1);
        int tripNumber = 1;

        if (dateTripMap.containsKey(tripDate+region)){
            for (Map.Entry<String, UserTrip> entry: dateTripMap.entrySet()){
                if(entry.getValue().equals(userTrip)){ //if there is already a trip in the date and country for that user
                    entry.setValue(new UserTrip(entry.getValue().getUser(),entry.getValue().getRegion(),
                            entry.getValue().getNumTrips()+1));
                    tripNumber = entry.getValue().getNumTrips();
                    return tripNumber;
                }
            }
            dateTripMap.put(tripDate+region,userTrip); //there is a trip in the date+region but not same user
        }
        dateTripMap.put(tripDate+region, userTrip); // if there are no trips for that date+region
        return tripNumber;
    }

    private void consumeApiData(ApiResponse apiResponse) throws JSONException{

        double [] optimumParams = Utils.getOptimumParams(apiResponse);
        double optimumDistance = optimumParams[0];
        double optimumTime = optimumParams[1];

        JSONObject jsonObjectInitialData = initialData.getJSONObject(extendedJourneyArrayList.size());
        InitialJourney initialJourney = Utils.initialJourneyFromJson(jsonObjectInitialData);

        String tripDate = Utils.getDate(initialJourney);

        int userTripNumber = checkTripNumber(initialJourney.getUserId(), initialJourney.getRegion(),
                tripDate);
        ComputeTripPrice computeTripPrice = new ComputeTripPrice(Utils.getPriceKm(initialJourney.getRegion()),
                optimumDistance, userTripNumber);

        ExtendedJourney extendedJourney = new ExtendedJourney(initialJourney,
                optimumDistance, optimumTime, Utils.getCurrency(initialJourney.getRegion()),
                computeTripPrice.computeTotalPrice(), computeTripPrice.computeTotalDiscount(),
                computeTripPrice.computeFinalPrice());

        extendedJourneyArrayList.add(extendedJourney);

        if(extendedJourneyArrayList.size() == initialData.length()) {

            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putParcelableArrayListExtra("data", extendedJourneyArrayList);
            startActivity(intent);
            extendedJourneyArrayList.clear();
            dateTripMap.clear();
        }
    }

    private class getAPIReply extends AsyncTask<Coords, Void, ApiResponse>{
        @Override
        protected ApiResponse doInBackground(Coords[] coords) {
            return servicio.getRouteInfo(coords[0], coords[1]);
        }
        @Override
        protected void onPostExecute(ApiResponse apiResponse){
            try {
                consumeApiData(apiResponse);
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "Error getting the remote data",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}