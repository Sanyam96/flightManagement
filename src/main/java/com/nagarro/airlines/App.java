package com.nagarro.airlines;

import com.nagarro.airlines.io.Input;
import com.nagarro.airlines.io.Output;
import com.nagarro.airlines.models.FlightInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class file
 */
public class App {

    private static HashMap<String, ArrayList<FlightInfo>> flightResults = new HashMap<>();

    /**
     * Main function to starter code
     *
     * @param args
     */
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();

        input.takeInput(flightResults);
        output.displayFlightDetails(flightResults);
    }

}
