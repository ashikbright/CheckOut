package com.ashik.checkout;

public class Worker {
    String wtype;
    String nworker;
    String ndays;
    String location;

    public Worker(String wtype, String nworker, String ndays, String location) {
        this.wtype = wtype;
        this.nworker = nworker;
        this.ndays = ndays;
        this.location = location;
    }

    public String getWtype() {
        return wtype;
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
}
