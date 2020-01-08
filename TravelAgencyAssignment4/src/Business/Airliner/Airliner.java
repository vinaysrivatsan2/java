/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vaibhavdhoke
 */
public class Airliner {
    private String airlinerName;
    private String address;
    private List<Airplane> airplane;
    private FlightSchedule flightSchedule;

    public Airliner() {
        this.airlinerName = airlinerName;
        this.address = address;
        this.airplane = new ArrayList<>();
        this.flightSchedule = flightSchedule;
    }
    
    public List<Airplane> getAirplane() {
        return airplane;
    }

    public void setAirplane(List<Airplane> airplane) {
        this.airplane = airplane;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airplinerName) {
        this.airlinerName = airplinerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Airplane addAirplane(Airplane airplane){
        this.airplane.add(airplane);
        return airplane;
    }
    public String toString(){
        return this.airlinerName;
    }
    
}
