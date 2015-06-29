package com.example.enrique.codingchallenge.Utils;

public enum CountryValues {

    SPAIN("Spain", "ES", 1.5, "EUR"),
    MEXICO("Mexico", "MX", 14, "MXN"),
    PERU("Peru", "PE", 14/2.5, "PEN");

    private final String name;
    private final String abbr;
    private final double priceKm;
    private final String currency;

    private CountryValues(String name, String abbr, double priceKm, String currency){
        this.name = name;
        this.abbr = abbr;
        this.priceKm = priceKm;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public double getPriceKm() {
        return priceKm;
    }

    public String getCurrency() {
        return currency;
    }
}
