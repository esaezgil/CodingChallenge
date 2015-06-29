package com.example.enrique.cabifychallenge.Utils;

public class ComputeTripPrice {

    private double pricePerKm;
    private double numMeters;
    private int userTripNumber;
    private boolean tripNumberDiscount = false;

    public final double DISCOUNT = 0.15;

    public ComputeTripPrice(double pricePerKm, double numMeters, int userTripNumber) {
        this.pricePerKm = pricePerKm;
        this.numMeters = numMeters;
        this.userTripNumber = userTripNumber;
    }

    public double computeTotalPrice(){
        return Utils.getFormattedDouble(pricePerKm* numMeters /1000);
    }

    private double computeKmDiscount(){
        double totalKmDiscount = 0;
        if(numMeters /1000 >= 10){
            totalKmDiscount = (numMeters /1000-10)*(1-DISCOUNT);
        }
        return Utils.getFormattedDouble(totalKmDiscount);
    }

    private boolean computeTripNumberDiscount(){
        tripNumberDiscount =  (userTripNumber % 3 == 0);
        return tripNumberDiscount;
    }

    public double computeTotalDiscount(){
        double discount;
        if (computeTripNumberDiscount())
            discount = computeTotalPrice();
        else
            discount = computeKmDiscount();
        return  Utils.getFormattedDouble(discount);
    }

    public double computeFinalPrice(){
        return Utils.getFormattedDouble(computeTotalPrice() - computeTotalDiscount());
    }
}
