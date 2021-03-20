package com.gridnine.testing;


import com.gridnine.testing.filter.FlightArrivalBeforeDeparture;
import com.gridnine.testing.filter.FlightBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.FlightLandTimeTwoHoursFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightTest {
    List <Flight> flightList;
    List <Flight> emptyFlightList;
    List <Flight> nullFlightList;

    @BeforeEach
    public void initialize() {
        flightList = FlightBuilder.createFlights();
        emptyFlightList = new ArrayList<>();
        nullFlightList = null;
    }

    @Test
    public void givenFlights_whenFilterFlightArriveBeforeDeparture_thenIllegalFlightRemoves(){
        FlightArrivalBeforeDeparture filter = new FlightArrivalBeforeDeparture();
        List<Flight> filteredFlights = filter.getFilteredFlights(flightList);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    public void givenNull_whenFilterFlightArriveBeforeDeparture_thenReturnEmptyList() {
        FlightArrivalBeforeDeparture filter = new FlightArrivalBeforeDeparture();
        List<Flight> filteredFlights = filter.getFilteredFlights(nullFlightList);
        Assertions.assertEquals(0, filteredFlights.size());
    }

    @Test
    public void givenEmptyFlights_whenFilterFlightArriveBeforeDeparture_thenReturnEmptyList() {
        FlightArrivalBeforeDeparture filter = new FlightArrivalBeforeDeparture();
        List<Flight> filteredFlights = filter.getFilteredFlights(emptyFlightList);
        Assertions.assertEquals(0, filteredFlights.size());
    }

    @Test
    public void givenFlights_whenFilterFlightBeforeCurrentTime_thenIllegalFlightRemoves(){
        FlightBeforeCurrentTimeFilter filter = new FlightBeforeCurrentTimeFilter();
        List<Flight> filteredFlights = filter.getFilteredFlights(flightList);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    public void givenNull_whenFilterFlightBeforeCurrentTime_thenReturnEmptyList() {
        FlightBeforeCurrentTimeFilter filter = new FlightBeforeCurrentTimeFilter();
        List<Flight> filteredFlights = filter.getFilteredFlights(nullFlightList);
        Assertions.assertEquals(0, filteredFlights.size());
    }

    @Test
    public void givenEmptyFlights_whenFilterFlightBeforeCurrentTime_thenReturnEmptyList() {
        FlightBeforeCurrentTimeFilter filter = new FlightBeforeCurrentTimeFilter();
        List<Flight> filteredFlights = filter.getFilteredFlights(emptyFlightList);
        Assertions.assertEquals(0, filteredFlights.size());
    }

    @Test
    public void givenFlights_whenFilterFlightLandTimeTwoHours_thenIllegalFlightRemoves(){
        FlightLandTimeTwoHoursFilter filter = new FlightLandTimeTwoHoursFilter();
        List<Flight> filteredFlights = filter.getFilteredFlights(flightList);
        Assertions.assertEquals(4, filteredFlights.size());
    }

    @Test
    public void givenNull_whenFilterFlightLandTimeTwoHours_thenReturnEmptyList() {
        FlightLandTimeTwoHoursFilter filter = new FlightLandTimeTwoHoursFilter();
        List<Flight> filteredFlights = filter.getFilteredFlights(nullFlightList);
        Assertions.assertEquals(0, filteredFlights.size());
    }

    @Test
    public void givenEmptyFlights_whenFilterFlightLandTimeTwoHours_thenReturnEmptyList() {
        FlightLandTimeTwoHoursFilter filter = new FlightLandTimeTwoHoursFilter();
        List<Flight> filteredFlights = filter.getFilteredFlights(emptyFlightList);
        Assertions.assertEquals(0, filteredFlights.size());
    }

}
