package com.nagarro.airlines.service;

import com.nagarro.airlines.models.FlightInfo;
import com.nagarro.airlines.models.UserInputParams;
import com.nagarro.airlines.utilities.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Sanyam Goel created on 23/8/18
 */
public class FlightFilesReader {

    ArrayList<FlightInfo> flightInfos = new ArrayList<>();

    /**
     * function to read all csv files
     *
     * @param csvFile
     * @param userInputParams
     * @return
     */
    public ArrayList<FlightInfo> readCSVFiles(File csvFile, UserInputParams userInputParams) {
        String flightDetails = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.datePattern);
        try (BufferedReader bReader = new BufferedReader(new FileReader(csvFile))) {
            bReader.readLine();

            while ((flightDetails = bReader.readLine()) != null) {
                String flightData[] = flightDetails.split(Constants.fileSplitParam);

                Date validTillDate = simpleDateFormat.parse(flightData[3]);

                if (flightData[1].equals(userInputParams.getDepartureLocation()) &&
                        flightData[2].equals(userInputParams.getArrivalLocation()) &&
                        (userInputParams.getFlightDate().before(validTillDate) || userInputParams.getFlightDate().equals(validTillDate)) &&
                        flightData[8].contains(userInputParams.getFlightClass().toString()) &&
                        flightData[7].equals("Y")) {

                    FlightInfo flight = new FlightInfo();
                    flight.setFlightNumber(flightData[0]);
                    flight.setDepartureLocation(flightData[1]);
                    flight.setArrivalLocation(flightData[2]);
                    flight.setValidTillDate(userInputParams.getFlightDate());
                    flight.setFlightTime(flightData[4]);
                    flight.setFlightDuration(Double.parseDouble(flightData[5]));
                    flight.setSeatAvailability(flightData[7].charAt(0));
                    flight.setFlightClass(userInputParams.getFlightClass().toString());
                    switch (userInputParams.getFlightClass()) {
                        case E:
                            flight.setFareCharges(Double.parseDouble(flightData[6]));
                            break;
                        case B:
                            double fare = Double.parseDouble(flightData[6]);
                            fare = fare + 0.4 * fare;
                            flight.setFareCharges(fare);
                            break;
                        default:
                            flight.setFareCharges(Double.parseDouble(flightData[6]));
                    }
                    flightInfos.add(flight);
                }
            }
        } catch (IOException fe) {
            System.err.println("File Not found");
            fe.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Date parse exception in readCsvFile method");
            e.printStackTrace();
        }
        return flightInfos;
    }
}
