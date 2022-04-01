package com.saegis.appone.dao;

import com.saegis.appone.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusDao {

    public List<Bus> getBuses(){
        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus("001", "119", "NA-1234"));
        buses.add(new Bus("002", "002", "NC-8762"));
        buses.add(new Bus("003", "101", "NB-5544"));
        return buses;
    }
}
