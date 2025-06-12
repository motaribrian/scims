package com.codewithmotari.scims.model;

public class City {
    private String cityName;
    private double latitude;
    private double longitude;
    private String countryName;
    private String countryIso2;
    private String countryIso3;

    public City() {
    }

    public City(String countryIso3, String countryIso2, String countryName, double longitude, double latitude, String cityName) {
        this.countryIso3 = countryIso3;
        this.countryIso2 = countryIso2;
        this.countryName = countryName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", countryName='" + countryName + '\'' +
                ", countryIso2='" + countryIso2 + '\'' +
                ", countryIso3='" + countryIso3 + '\'' +
                '}';
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getCountryIso3() {
        return countryIso3;
    }

    public void setCountryIso3(String countryIso3) {
        this.countryIso3 = countryIso3;
    }
}
