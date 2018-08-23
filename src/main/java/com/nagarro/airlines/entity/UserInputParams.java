package com.nagarro.airlines.entity;

import com.nagarro.airlines.enums.FlightClass;
import com.nagarro.airlines.enums.FlightOutputType;

import java.util.Date;

/**
 * @author Sanyam Goel created on 22/8/18
 */
public class UserInputParams {

    private String departureLocation;

    private String arrivalLocation;

    private Date flightDate;

    private FlightClass flightClass;

    private FlightOutputType outputPreference;

    @Override
    public String toString() {
        return "UserInputParams{" +
                "departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", flightClass=" + flightClass +
                ", outputPreference=" + outputPreference +
                '}';
    }

    public UserInputParams(String departureLocation, String arrivalLocation, Date flightDate, FlightClass flightClass, FlightOutputType outputPreference) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.flightDate = flightDate;
        this.flightClass = flightClass;
        this.outputPreference = outputPreference;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public FlightOutputType getOutputPreference() {
        return outputPreference;
    }

    public void setOutputPreference(FlightOutputType outputPreference) {
        this.outputPreference = outputPreference;
    }
}
