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

    public String toString() {
        String temp = "";
        for (FlightInfo flight : flights) {
//            temp = "[ Flight Number : " + flight.getFlightNumber() + "\n" +
//                    "Flight Class : " + flight.getFlightClass() + "\n" +
//                    "Flight Fare : " + flight.getFareCharges() + "]\n";
            temp += flight.toString() + "\n";
        }
        return temp;
    }

    public ArrayList<FlightInfo> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<FlightInfo> flights) {
        this.flights = flights;
    }
}
