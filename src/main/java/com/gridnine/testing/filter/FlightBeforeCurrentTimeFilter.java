package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightBeforeCurrentTimeFilter implements FlightFilter {
    @Override
    public List<Flight> getFilteredFlights(List<Flight> flightList) {
        if (flightList == null) {
            return Collections.emptyList();
        }
        return flightList.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}
