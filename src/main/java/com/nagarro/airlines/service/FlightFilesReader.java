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
                    FlightInfo flight = new FlightInfo(flightData[0], flightData[1], flightData[2], userInputParams.getFlightDate(), flightData[4], Double.parseDouble(flightData[5]), Double.parseDouble(flightData[6]), flightData[7].charAt(0), userInputParams.getFlightClass().toString());
                    flightInfos.add(flight);
                    //System.out.println(csvFile.getName() + flight.toString());
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
