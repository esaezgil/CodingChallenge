package com.example.enrique.cabifychallenge.Utils;

import com.example.enrique.cabifychallenge.Model.ExtendedJourney;
import com.example.enrique.cabifychallenge.Model.InitialJourney;
import com.example.enrique.cabifychallenge.Retrofit.AlternativeSummary;
import com.example.enrique.cabifychallenge.Retrofit.ApiResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String getCurrency(String region) {
        String currency ="";
        for (CountryValues countryValues: CountryValues.values()){
            if(countryValues.getAbbr().equals(region)){
                currency = countryValues.getCurrency();
            }
        }
        return currency;
    }

    public static double getPriceKm(String region) {
        double pricePerKm = -1;
        for (CountryValues countryValues : CountryValues.values()){
            if (countryValues.getAbbr().equals(region)){
                pricePerKm = countryValues.getPriceKm();
            }
        }
        return pricePerKm;
    }

    public static double[] getLocationCoords(JSONObject jsonObject, String jsonField) throws JSONException {
        JSONArray jsonArrayLocation = jsonObject.getJSONArray(jsonField);
        double [] startLocation = new double[2];
        for(int i=0;i<jsonArrayLocation.length();i++){
            startLocation[i] = jsonArrayLocation.getDouble(i);
        }
        return startLocation;
    }

    public static double[] getOptimumParams (ApiResponse apiResponse){

        double [] optimumParams = new double[2];

        double optimumDistance = apiResponse.getRouteSummary().getTotalDistance();
        double optimumTime = apiResponse.getRouteSummary().getTotalTime();

        //TODO: check optimum route
        if(apiResponse.getAlternativeSummaries()!=null ){

            List<AlternativeSummary> alternativeSummaries = apiResponse.getAlternativeSummaries();

            for(int i = 0; i < alternativeSummaries.size(); i++) {
                if (optimumDistance > alternativeSummaries.get(i).getTotalDistance()){
                    optimumDistance = alternativeSummaries.get(i).getTotalDistance();
                }
                if (optimumTime > alternativeSummaries.get(i).getTotalTime()){
                    optimumTime = alternativeSummaries.get(i).getTotalTime();
                }
            }
        }
        optimumParams[0] = optimumDistance;
        optimumParams[1] = optimumTime;
        return optimumParams;
    }

    public static InitialJourney initialJourneyFromJson(JSONObject jsonObject) throws JSONException {

        String region = jsonObject.getString("region");
        double[] startLocationCoords = getLocationCoords(jsonObject, "start_loc");
        double[] endLocationCoords = getLocationCoords(jsonObject, "end_loc");
        int id = jsonObject.getInt("id");
        int userId = jsonObject.getInt("user_id");
        String createdAt;
        if (jsonObject.optString("created_at").equals(""))
            createdAt = jsonObject.optString("time");
        else
            createdAt = jsonObject.optString("created_at");

        return new InitialJourney(id, region, userId, startLocationCoords,
                endLocationCoords, createdAt);
    }

    public static String getDate(InitialJourney initialJourney){
        return initialJourney.getCreatedAt().substring(0, initialJourney.getCreatedAt().indexOf("T"));
    }

    public static String[][] extendedJourneyListToArray(ArrayList<ExtendedJourney> extendedJourneyArrayList){
        String [][] result = new String[extendedJourneyArrayList.size()][14];
        for (int i = 0; i < extendedJourneyArrayList.size(); i++) {
            result[i][0] = String.valueOf(extendedJourneyArrayList.get(i).getId());
            result[i][1] = extendedJourneyArrayList.get(i).getRegion();
            result[i][2] = String.valueOf(extendedJourneyArrayList.get(i).getUserId());
            result[i][3] = String.valueOf(extendedJourneyArrayList.get(i).getStartLocation()[0]);
            result[i][4] = String.valueOf(extendedJourneyArrayList.get(i).getStartLocation()[1]);
            result[i][5] = String.valueOf(extendedJourneyArrayList.get(i).getEndLocation()[0]);
            result[i][6] = String.valueOf(extendedJourneyArrayList.get(i).getEndLocation()[1]);
            result[i][7] = extendedJourneyArrayList.get(i).getCreatedAt();
            result[i][8] = String.valueOf(extendedJourneyArrayList.get(i).getDistance());
            result[i][9] = String.valueOf(extendedJourneyArrayList.get(i).getDuration());
            result[i][10] = extendedJourneyArrayList.get(i).getCurrency();
            result[i][11] = String.valueOf(extendedJourneyArrayList.get(i).getPrice());
            result[i][12] = String.valueOf(extendedJourneyArrayList.get(i).getDiscount());
            result[i][13] = String.valueOf(extendedJourneyArrayList.get(i).getTotalprice());
        }
        return result;
    }

    public static double getFormattedDouble(double nonformatted){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Double.parseDouble(decimalFormat.format(nonformatted));
    }
}
