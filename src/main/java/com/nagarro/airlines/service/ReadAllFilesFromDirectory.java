package com.nagarro.airlines.service;

import com.nagarro.airlines.models.FlightInfo;
import com.nagarro.airlines.models.OutputData;
import com.nagarro.airlines.models.UserInputParams;
import com.nagarro.airlines.utilities.Constants;

import java.io.File;
import java.util.*;

/**
 * @author Sanyam Goel created on 23/8/18
 */
public class ReadAllFilesFromDirectory {

    public void readFiles(HashMap<String, ArrayList<FlightInfo>> flightResults, UserInputParams userInputParams) {

        File flightFolder = new File(Constants.filesPath);
        ArrayList<File> listOfFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(flightFolder.listFiles())));
        OutputData outputData = new OutputData();

        listOfFiles.parallelStream().forEach(csvFile -> {
            FlightFilesReader flightFilesReader = new FlightFilesReader();
            final ArrayList<FlightInfo> flights = flightFilesReader.readCSVFiles(csvFile, userInputParams);
            switch (userInputParams.getOutputPreference()) {
                case BY_FARE:
                    Collections.sort(flights, Comparator.comparing(FlightInfo :: getFareCharges));
                    break;
                case BY_FARE_DURATION:
                    Collections.sort(flights, Comparator.comparing(FlightInfo :: getFareCharges).thenComparing(FlightInfo::getFlightDuration));
                    break;
                default:
                    break;
            }
            outputData.setFlights(flights);
            System.out.println(outputData);
        });

    }
}
