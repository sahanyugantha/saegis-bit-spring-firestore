package com.saegis.appone.model;

public class Bus {
    private String id;
    private String routeNo;
    private String busRegNo;

    public Bus() {
    }

    public Bus(String id, String routeNo, String busRegNo) {
        this.id = id;
        this.routeNo = routeNo;
        this.busRegNo = busRegNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public String getBusRegNo() {
        return busRegNo;
    }

    public void setBusRegNo(String busRegNo) {
        this.busRegNo = busRegNo;
    }
}
