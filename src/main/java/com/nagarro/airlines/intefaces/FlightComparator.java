package com.nagarro.airlines.intefaces;

import com.nagarro.airlines.entity.FlightInfo;

import java.util.Comparator;

/**
 * @author Sanyam Goel created on 23/8/18
 */
public interface FlightComparator extends Comparator<FlightInfo> {
    public int compare(FlightInfo flightInfo1, FlightInfo flightInfo2);
}
