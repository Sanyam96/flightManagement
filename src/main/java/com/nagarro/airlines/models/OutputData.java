package com.nagarro.airlines.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanyam Goel created on 22/8/18
 */
public class OutputData {
    ArrayList<FlightInfo> flights;


    public String toString() {
        String temp = "";
        for (FlightInfo flight : flights) {
            temp += flight.toString() + "\n";
        }
        return temp;
    }

    public List<FlightInfo> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<FlightInfo> flights) {
        this.flights = flights;
    }
}
