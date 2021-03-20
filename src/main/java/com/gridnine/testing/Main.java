package com.gridnine.testing;

import com.gridnine.testing.filter.FlightArrivalBeforeDeparture;
import com.gridnine.testing.filter.FlightBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.FlightLandTimeTwoHoursFilter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List <Flight> flightList = FlightBuilder.createFlights();
        flightList.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------");
        flightList.stream().filter(flight -> flight.getSegments().size() > 1).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------");
        flightList.stream().filter(flight -> flight.getSegments().size() == 1).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------");
        FlightBeforeCurrentTimeFilter flightBeforeCurrentTimeFilter = new FlightBeforeCurrentTimeFilter();
        FlightArrivalBeforeDeparture flightArrivalBeforeDeparture = new FlightArrivalBeforeDeparture();
        flightBeforeCurrentTimeFilter.getFilteredFlights(flightList).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------");
        flightArrivalBeforeDeparture.getFilteredFlights(flightList).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------");
        FlightLandTimeTwoHoursFilter flightLandTimeTwoHoursFilter = new FlightLandTimeTwoHoursFilter();
        flightLandTimeTwoHoursFilter.getFilteredFlights(flightList).forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------");




    }
}
