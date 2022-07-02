package com.ashik.checkout;

public class Worker {
    private  String wType;
    String nworker;
    String ndays;
    String location;

    public Worker( String nworker, String ndays, String location) {
        this.nworker = nworker;
        this.ndays = ndays;
        this.location = location;
    }

    public String getNworker() {
        return nworker;
    }

    public String getNdays() {
        return ndays;
    }

    public String getLocation() {
        return location;
    }

    public Worker(){

    }

    public String getwType() {
        return wType;
    }

    public void setwType(String wType) {
        this.wType = wType;
    }
}
