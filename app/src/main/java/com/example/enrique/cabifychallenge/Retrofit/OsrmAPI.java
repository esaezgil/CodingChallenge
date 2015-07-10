package com.example.enrique.cabifychallenge.Retrofit;

import com.example.enrique.cabifychallenge.Utils.Coords;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.EncodedQuery;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/*query = URL + startLocation[0] + "," + startLocation[1] + "&loc="+ endLocation[0] +
                "," + endLocation[1];*/
public interface OsrmAPI {
    @GET("/viaroute")
    ApiResponse getRouteInfo(@EncodedQuery("loc") Coords startCoords,@EncodedQuery("loc") Coords endCoords);

    @GET("/viaroute")
    void getRouteInfoAsync(@EncodedQuery("loc") Coords startCoords,@EncodedQuery("loc") Coords endCoords,Callback<ApiResponse> cb);
}
