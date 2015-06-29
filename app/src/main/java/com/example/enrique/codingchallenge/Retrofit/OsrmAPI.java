package com.example.enrique.codingchallenge.Retrofit;

import com.example.enrique.codingchallenge.Utils.Coords;

import retrofit.Callback;
import retrofit.http.EncodedQuery;
import retrofit.http.GET;

/*query = URL + startLocation[0] + "," + startLocation[1] + "&loc="+ endLocation[0] +
                "," + endLocation[1];*/
public interface OsrmAPI {
    @GET("/viaroute")
    ApiResponse getRouteInfo(@EncodedQuery("loc") Coords startCoords,@EncodedQuery("loc") Coords endCoords);

    @GET("/viaroute")
    void getRouteInfoAsync(@EncodedQuery("loc") Coords startCoords,@EncodedQuery("loc") Coords endCoords,Callback<ApiResponse> cb);
}
