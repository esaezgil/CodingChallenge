package com.example.enrique.cabifychallenge.Utils;

import android.view.View;
import android.widget.TextView;

import com.example.enrique.cabifychallenge.R;

public class ViewHolder {

    private TextView id;
    private TextView region;
    private TextView userId;
    private TextView startLong;
    private TextView startLat;
    private TextView endLong;
    private TextView endLat;
    private TextView createdAt;

    private TextView distance;
    private TextView duration;
    private TextView currency;
    private TextView price;
    private TextView discount;
    private TextView totalPrice;


    public void setDistanceView(View v){
        distance = (TextView) v.findViewById(R.id.distanceTextView);
    }
    public void setDurationView(View v){
        duration = (TextView) v.findViewById(R.id.durationTextView);
    }
    public void setCurrencyView(View v){
        currency = (TextView) v.findViewById(R.id.currencyTextView);
    }
    public void setPriceView(View v){
        price = (TextView) v.findViewById(R.id.priceTextView);
    }
    public void setDiscountView(View v){
        discount = (TextView) v.findViewById(R.id.discountTextView);
    }

    public void setIdView(View v) {
        id = (TextView) v.findViewById(R.id.idTextView);
    }
    public void setRegionView(View v){
        region = (TextView) v.findViewById(R.id.regionTextView);
    }
    public void setUserIdView(View v) {
        userId = (TextView) v.findViewById(R.id.userIdTextView);
    }
    public void setStartLongView(View v) {
        startLong = (TextView) v.findViewById(R.id.startLongTextView);
    }
    public void setStartLatView(View v){
        startLat = (TextView) v.findViewById(R.id.startLatTextView);
    }
    public void setEndLongView(View v) {
        endLong = (TextView) v.findViewById(R.id.endLongTextView);
    }
    public void setEndLatView(View v) {
        endLat = (TextView) v.findViewById(R.id.endLatTextView);
    }
    public void setCreatedAtView(View v) {
        createdAt = (TextView) v.findViewById(R.id.createdAtTextView);
    }
    public void setTotalPriceView(View v){
        totalPrice = (TextView) v.findViewById(R.id.totalPriceTextView);
    }

    public void setDistance(String value){
        distance.setText(value);
    }
    public void setDuration(String value) {
        duration.setText(value);
    }
    public void setCurrency(String value) {
        currency.setText(value);
    }
    public void setPrice(String value) {
        price.setText(value);
    }
    public void setDiscount(String value) {
        discount.setText(value);
    }
    public void setTotalPrice(String value) {
        totalPrice.setText(value);
    }

    public void setId(String value) {
        id.setText(value);
    }
    public void setRegion(String value) {
        region.setText(value);
    }
    public void setUserId(String value) {
        userId.setText(value);
    }
    public void setStartLong(String value) {
        startLong.setText(value);
    }
    public void setStartLat(String value) {
        startLat.setText(value);
    }
    public void setEndLong(String value) {
        endLong.setText(value);
    }
    public void setEndLat(String value) {
        endLat.setText(value);
    }

    public void setCreatedAt(String value) {
        createdAt.setText(value);
    }
}
