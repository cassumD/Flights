package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightArrivalBeforeDeparture implements FlightFilter {
    @Override
    public List<Flight> getFilteredFlights(List<Flight> flightList) {
        if (flightList == null) {
            return Collections.emptyList();
        }
        return flightList.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
