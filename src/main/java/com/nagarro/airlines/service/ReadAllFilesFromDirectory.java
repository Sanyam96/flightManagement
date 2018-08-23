package com.nagarro.airlines.service;

import com.nagarro.airlines.entity.FlightInfo;
import com.nagarro.airlines.entity.OutputData;
import com.nagarro.airlines.entity.UserInputParams;
import com.nagarro.airlines.utilities.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Sanyam Goel created on 23/8/18
 */
public class ReadAllFilesFromDirectory {

    public void readFiles(HashMap<String, ArrayList<FlightInfo>> flightResults, UserInputParams userInputParams) {

        File flightFolder = new File(Constants.filesPath);
        ArrayList<File> listOfFiles = new ArrayList<>(Arrays.asList(flightFolder.listFiles()));

        listOfFiles.parallelStream().forEach(csvFile -> {
            FlightFilesReader flightFilesReader = new FlightFilesReader();
            ArrayList<FlightInfo> flights = flightFilesReader.readCSVFiles(csvFile, userInputParams);
            OutputData outputData = new OutputData(flights);
            System.out.println(outputData);
        });

    }
}
