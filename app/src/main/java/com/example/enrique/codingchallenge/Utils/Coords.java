package com.example.enrique.codingchallenge.Utils;

public class Coords {

    private double latitude;
    private double longitude;

    public Coords(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.valueOf(latitude) + (",") + String.valueOf(longitude);
    }

    public Coords(double[] doubles) {
        this(doubles[0], doubles[1]);
    }


}
