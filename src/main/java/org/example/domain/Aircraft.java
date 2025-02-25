package org.example.domain;

import java.util.List;

public class Aircraft {
    private String airlineName;
    private String type;
    private int numOfPassengers;
    private long id;
    private List<Airport> airports;
    private List<Passenger> passengers;

    public Aircraft() {
    }

    public Aircraft(String type) {
        this.type = type;
    }

    public Aircraft(long id, String type, String airlineName, int numOfPassengers) {
        this.id = id;
        this.type = type;
        this.airlineName = airlineName;
        this.numOfPassengers = numOfPassengers;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }


    public String getType() {
        return type;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }


    public String getAirlineName() {
        return airlineName;
    }



}
