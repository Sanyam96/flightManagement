package com.nagarro.airlines.entity;

import java.util.ArrayList;

/**
 * @author Sanyam Goel created on 22/8/18
 */
public class OutputData {
    ArrayList<FlightInfo> flights;

    public OutputData(ArrayList<FlightInfo> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "flights=" + flights +
                '}' + '\n';
    }

    public ArrayList<FlightInfo> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<FlightInfo> flights) {
        this.flights = flights;
    }
}
