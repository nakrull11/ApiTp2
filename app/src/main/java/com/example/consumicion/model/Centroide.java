package com.example.consumicion.model;

public class Centroide {

    private double lat;
    private double lon;

    public Centroide(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Centroide() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Centroide{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
