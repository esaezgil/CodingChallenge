package com.example.enrique.codingchallenge.Model;

import java.util.Arrays;

public abstract class SimpleJourney {

    private int id;
    private String region;
    private int userId;
    private double [] startLocation = new double[2];
    private double [] endLocation = new double[2];
    private String createdAt;

    public SimpleJourney(int id, String region, int userId, double[] startLocation, double[] endLocation, String createdAt) {
        this.id = id;
        this.region = region;
        this.userId = userId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.createdAt = createdAt;
    }

    public SimpleJourney(){
        this.id = 0;
        this.region = "";
        this.userId = 0;
        this.startLocation = new double[2];
        this.endLocation = new double[2];
        this.createdAt = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double[] getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(double[] startLocation) {
        this.startLocation = startLocation;
    }

    public double[] getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(double[] endLocation) {
        this.endLocation = endLocation;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SimpleJourney{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", userId=" + userId +
                ", startLocation=" + Arrays.toString(startLocation) +
                ", endLocation=" + Arrays.toString(endLocation) +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
