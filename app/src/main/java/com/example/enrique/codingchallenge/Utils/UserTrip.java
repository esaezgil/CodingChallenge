package com.example.enrique.codingchallenge.Utils;

public class UserTrip {

    private int user;
    private String region;
    private int numTrips;

    public UserTrip(int user, String region, int numTrips) {
        this.user = user;
        this.region = region;
        this.numTrips = numTrips;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getNumTrips() {
        return numTrips;
    }

    public void setNumTrips(int numTrips) {
        this.numTrips = numTrips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTrip userTrip = (UserTrip) o;

        if (getUser() != userTrip.getUser()) return false;
        return getRegion().equals(userTrip.getRegion());

    }

    @Override
    public int hashCode() {
        int result = getUser();
        result = 31 * result + getRegion().hashCode();
        return result;
    }
}
