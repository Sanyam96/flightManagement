package com.nagarro.airlines.entity;

import com.nagarro.airlines.enums.FlightClass;

import java.util.Date;

/**
 * @author Sanyam Goel created on 22/8/18
 */
public class FlightInfo {

    private String flightNumber;

    private String departureLocation;

    private String arrivalLocation;

    private Date validTillDate;

    private String flightTime;

    private double flightDuration;

    private double fareCharges;

    private char seatAvailability;

    private String flightClass;

    @Override
    public String toString() {
        return "FlightInfo{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", validTillDate=" + validTillDate +
                ", flightTime='" + flightTime + '\'' +
                ", flightDuration=" + flightDuration +
                ", fareCharges='" + fareCharges + '\'' +
                ", seatAvailability=" + seatAvailability +
                ", flightClass='" + flightClass + '\'' +
                '}';
    }

    public FlightInfo(String flightNumber, String departureLocation, String arrivalLocation, Date validTillDate, String flightTime, double flightDuration, double fareCharges, char seatAvailability, String flightClass) {
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

    public Date getValidTillDate() {
        return validTillDate;
    }

    public void setValidTillDate(Date validTillDate) {
        this.validTillDate = validTillDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public double getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(double flightDuration) {
        this.flightDuration = flightDuration;
    }

    public double getFareCharges() {
        return fareCharges;
    }

    public void setFareCharges(double fareCharges) {
        this.fareCharges = fareCharges;
    }

    public char getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(char seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}
