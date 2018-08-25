package com.nagarro.airlines;

import com.nagarro.airlines.io.Input;
import com.nagarro.airlines.models.FlightInfo;
import com.nagarro.airlines.models.OutputData;
import com.nagarro.airlines.models.UserInputParams;
import com.nagarro.airlines.enums.FlightClass;
import com.nagarro.airlines.enums.FlightOutputType;
import com.nagarro.airlines.service.ReadAllFilesFromDirectory;
import com.nagarro.airlines.utilities.Constants;
import com.nagarro.airlines.utilities.ScannerInstance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    private static HashMap<String, ArrayList<FlightInfo>> flightResults = new HashMap<>();

    public static void main(String[] args) {

        Input input = new Input();
        input.takeInput(flightResults);
    }

}
