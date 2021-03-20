package com.gridnine.testing.filter;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightLandTimeTwoHoursFilter implements FlightFilter {
    @Override
    public List<Flight> getFilteredFlights(List<Flight> flightList) {
        if (flightList == null) {
            return Collections.emptyList();
        }
        return flightList.stream()
                .filter(flight -> getTotalLandHours(flight) <= 2)
                .collect(Collectors.toList());
    }

    private long getTotalLandHours(Flight flight) {
        long totalLandHours = 0L;
        for (int i = 0; i < flight.getSegments().size() - 1; i++) {
            Segment currentSegment = flight.getSegments().get(i);
            Segment nextSegment = flight.getSegments().get(i + 1);
            long landHours = ChronoUnit.HOURS.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate());
            totalLandHours += landHours;
        }

        return totalLandHours;
    }
}
