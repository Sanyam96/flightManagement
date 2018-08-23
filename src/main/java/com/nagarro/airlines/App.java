package com.nagarro.airlines;

import com.nagarro.airlines.entity.FlightInfo;
import com.nagarro.airlines.entity.UserInputParams;
import com.nagarro.airlines.enums.FlightClass;
import com.nagarro.airlines.enums.FlightOutputType;
import com.nagarro.airlines.intefaces.FlightComparator;
import com.nagarro.airlines.service.FlightFilesReader;
import com.nagarro.airlines.utilities.Constants;
import com.nagarro.airlines.utilities.ScannerInstance;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class App {

    private static HashMap<String, ArrayList<FlightInfo>> flightResults;

    public static void main(String[] args) {
        takeInput();
    }

    private static void takeInput() {

        String departureLocation;
        String arrivalLocation;
        DateFormat flightDateFormat;
        FlightClass flightClass = null;
        FlightOutputType flightOutputType = null;
        Date flightDate = null;

        System.out.println("Enter Departure Location");
        departureLocation = ScannerInstance.getScannerInstance().nextLine().toUpperCase();

        System.out.println("Enter Arrival Location");
        arrivalLocation = ScannerInstance.getScannerInstance().nextLine().toUpperCase();

        System.out.println("Enter Flight Date in following format - DD-MM-YYYY");
        String flightDateInput = ScannerInstance.getScannerInstance().nextLine();
        try {
            flightDateFormat = new SimpleDateFormat(Constants.datePattern);
            flightDate = flightDateFormat.parse(flightDateInput);
        } catch (ParseException e) {
            System.err.println("Wrong Date Entered!!");
            e.printStackTrace();
        }

        System.out.println("Choose Flight Class:" + "\n" + "E : Economy" + "\n" + "B : Business");
        char flightClassCharacter = ScannerInstance.getScannerInstance().next().charAt(0);
        flightClassCharacter = Character.toUpperCase(flightClassCharacter);
        switch (flightClassCharacter) {
            case 'E':
                flightClass = FlightClass.E;
                break;
            case 'B':
                flightClass = FlightClass.B;
                break;
            default:
                flightClass = FlightClass.E;
        }

        System.out.println("Choose output preference:" + "\n" + "1 - By Fare only" + "\n" + "2 - By Fare and Flight Duration :");
        int flightPreference = ScannerInstance.getScannerInstance().nextInt();
        switch (flightPreference) {
            case 1:
                flightOutputType = FlightOutputType.BY_FARE;
                break;
            case 2:
                flightOutputType = FlightOutputType.BY_FARE_DURATION;
                break;
            default:
                flightOutputType = FlightOutputType.BY_FARE;
        }


        UserInputParams userInputParams = new UserInputParams(departureLocation, arrivalLocation, flightDate, flightClass, flightOutputType);
        System.out.println(userInputParams.toString());

        readFiles(flightResults, userInputParams);

    }

    private static void readFiles(HashMap<String, ArrayList<FlightInfo>> flightResults, UserInputParams userInputParams) {

        File flightFolder = new File(Constants.filesPath);
        ArrayList<File> listOfFiles = new ArrayList<>(Arrays.asList(flightFolder.listFiles()));

        listOfFiles.parallelStream().forEach(csvFile -> {
            FlightFilesReader flightFilesReader = new FlightFilesReader();
            ArrayList<FlightInfo> flights = flightFilesReader.readCSVFiles(csvFile, userInputParams);
//            System.out.println(flights);

        });

    }

}
