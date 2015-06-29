package com.example.enrique.codingchallenge.Retrofit;

import retrofit.RestAdapter;

public class OsrmService {

    private static OsrmAPI instance = null;

    private final String URL = "http://router.project-osrm.org";

    public static OsrmAPI getInstance(){
        if(instance == null){
            new OsrmService();
        }
        return instance;
    }

    private OsrmService(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(URL)
                .build();
        instance = restAdapter.create(OsrmAPI.class);
    }
}
