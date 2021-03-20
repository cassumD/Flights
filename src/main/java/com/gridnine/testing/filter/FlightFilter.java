package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> getFilteredFlights(List<Flight> flightList);
}
