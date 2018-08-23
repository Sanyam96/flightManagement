package com.nagarro.airlines.entity;

import com.nagarro.airlines.enums.FlightClass;

/**
 * @author Sanyam Goel created on 22/8/18
 */
public class FlightInfo {

    private String flightNumber;

    private String departureLocation;

    private String arrivalLocation;

    private String validTillDate;

    private String flightTime;

    private String flightDuration;

    private String fareCharges;

    private char seatAvailability;

    private FlightClass flightClass;

    /**
     * Constructor
     * @param flightNumber
     * @param departureLocation
     * @param arrivalLocation
     * @param validTillDate
     * @param flightTime
     * @param flightDuration
     * @param fareCharges
     * @param seatAvailability
     * @param flightClass
     */
    public FlightInfo(String flightNumber, String departureLocation, String arrivalLocation, String validTillDate, String flightTime, String flightDuration, String fareCharges, char seatAvailability, FlightClass flightClass) {
        this.flightNumber = flightNumber;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.validTillDate = validTillDate;
        this.flightTime = flightTime;
        this.flightDuration = flightDuration;
        this.fareCharges = fareCharges;
        this.seatAvailability = seatAvailability;
        this.flightClass = flightClass;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", validTillDate='" + validTillDate + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", flightDuration='" + flightDuration + '\'' +
                ", fareCharges='" + fareCharges + '\'' +
                ", seatAvailability=" + seatAvailability +
                ", flightClass=" + flightClass +
                '}';
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public String getValidTillDate() {
        return validTillDate;
    }

    public void setValidTillDate(String validTillDate) {
        this.validTillDate = validTillDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public String getFareCharges() {
        return fareCharges;
    }

    public void setFareCharges(String fareCharges) {
        this.fareCharges = fareCharges;
    }

    public char getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(char seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }
}
