/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

import Business.Airliner.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author vaibhavdhoke
 */
public class FlightSchedule {
    private List<Flight> flightSchedule;

    public FlightSchedule(List<Airplane> airplane)  {
        
        flightSchedule = new ArrayList<>();
        
        Flight flight1 = new Flight();
        flight1.setLocationTo("Boston");
        flight1.setLocationFrom("London");
        flight1.setDate("10-12-2019");
        flight1.setCancelled(false);
        flight1.setAirplane(airplane.get(0));
        flight1.setPrice(150);
        
        
        
        this.flightSchedule.add(flight1);
        
        Flight flight2 = new Flight();
        flight2.setAirplane(airplane.get(1));
        flight2.setCancelled(true);
        flight2.setDate("12-12-2019");
        flight2.setLocationFrom("Delhi");
        flight2.setLocationTo("Mumbai");
        flight2.setPrice(200);
        
        this.flightSchedule.add(flight2);
        
    }

    public List<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(List<Flight> flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    
    
    
    
    
    public Flight addFlight(Airplane plane,String fromLoc,String toLocation,String date,Boolean cancelled,Integer price){
        Flight flight = new Flight();
        flight.setAirplane(plane);
        flight.setCancelled(cancelled);
        flight.setDate(date);
        flight.setLocationFrom(fromLoc);
        flight.setLocationTo(toLocation);
        flight.setPrice(price);
        flightSchedule.add(flight);
        return flight;
    }
}
