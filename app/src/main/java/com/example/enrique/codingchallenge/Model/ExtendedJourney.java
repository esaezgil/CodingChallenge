package com.example.enrique.codingchallenge.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ExtendedJourney extends SimpleJourney implements Parcelable{

    private double distance;
    private double duration;
    private String currency;
    private double price;
    private double discount;
    private double totalprice;

    public ExtendedJourney(int id, String region, int userId, double[] startLocation,
                           double[] endLocation, String createdAt, double distance, double duration,
                           String currency, double price, double discount, double totalprice) {
        super(id, region, userId, startLocation, endLocation, createdAt);
        this.distance = distance;
        this.duration = duration;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.totalprice = totalprice;
    }

    public ExtendedJourney(InitialJourney initialJourney, double distance, double duration,
                           String currency, double price, double discount, double totalprice){

        super(initialJourney.getId(), initialJourney.getRegion(), initialJourney.getUserId(),
                initialJourney.getStartLocation(), initialJourney.getEndLocation(),
                initialJourney.getCreatedAt());
        this.distance = distance;
        this.duration = duration;
        this.currency = currency;
        this.price = price;
        this.discount = discount;
        this.totalprice = totalprice;
    }

    public ExtendedJourney() {
        super();
        this.distance = 0;
        this.duration = 0;
        this.currency = "";
        this.price = 0;
        this.discount = 0;
        this.totalprice = 0;
    }

    public double getDistance() {
        return distance;
    }

    public ExtendedJourney(Parcel in) {
        readFromParcel(in);
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.getId());
        dest.writeString(this.getRegion());
        dest.writeInt(this.getUserId());
        dest.writeDoubleArray(this.getStartLocation());
        dest.writeDoubleArray(this.getEndLocation());
        dest.writeString(this.getCreatedAt());

        dest.writeDouble(this.distance);
        dest.writeDouble(this.duration);
        dest.writeString(this.currency);
        dest.writeDouble(this.price);
        dest.writeDouble(this.discount);
        dest.writeDouble(this.totalprice);
    }

    public void readFromParcel(Parcel in){
        setId(in.readInt());
        setRegion(in.readString());
        setUserId(in.readInt());

        double [] location = new double[2];
        in.readDoubleArray(location);
        setStartLocation(location);

        in.readDoubleArray(location);
        setEndLocation(location);

        setCreatedAt(in.readString());

        this.distance = in.readDouble();
        this.duration = in.readDouble();
        this.currency = in.readString();
        this.price = in.readDouble();
        this.discount = in.readDouble();
        this.totalprice = in.readDouble();
    }

    public static final Parcelable.Creator<ExtendedJourney> CREATOR
            = new Parcelable.Creator<ExtendedJourney>() {

        @Override
        public ExtendedJourney createFromParcel(Parcel in) {
            return new ExtendedJourney(in);
        }

        @Override
        public ExtendedJourney[] newArray(int size) {
            return new ExtendedJourney[size];
        }
    };

    @Override
    public String toString() {
        return "ExtendedJourney{" + super.toString() +
                "distance=" + distance +
                ", duration=" + duration +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", totalprice=" + totalprice +
                '}';
    }
}
