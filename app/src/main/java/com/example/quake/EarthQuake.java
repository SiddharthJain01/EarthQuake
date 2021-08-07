package com.example.quake;

public class EarthQuake {
    private double mag;
    String place;
    String time;
    public EarthQuake(double mag, String place, String time){
        this.mag=mag;
        this.place=place;
        this.time=time;
    }

    public double getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }


}
