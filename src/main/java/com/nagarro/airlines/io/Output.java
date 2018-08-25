package com.nagarro.airlines.io;

import com.nagarro.airlines.models.FlightInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Sanyam Goel created on 25/8/18
 */
public class Output {

    public void displayFlightDetails(HashMap<String, ArrayList<FlightInfo>> flightDetails) {
        boolean emptyResults = true;
        Iterator<HashMap.Entry<String, ArrayList<FlightInfo>>> fIterator = flightDetails.entrySet().iterator();

        while (fIterator.hasNext()) {
            HashMap.Entry<String, ArrayList<FlightInfo>> flightEntry = fIterator.next();
            ArrayList<FlightInfo> resultsList = flightEntry.getValue();
            if (!resultsList.isEmpty()) {
                emptyResults = false;
                System.out.println("\n" + flightEntry.getKey());
                for (FlightInfo flight : resultsList) {
                    System.out.println(flight.toString());
                }
            }
        }
        if (emptyResults == true) {
            System.err.println("No flights found matching your search data.");
        }
    }
}
