/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

import com.sun.org.apache.bcel.internal.generic.F2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vaibhavdhoke
 */
public class AirlinerDirectory {
    private List<Airliner> airlinerList;
    
    public AirlinerDirectory() {
        airlinerList = new ArrayList<>();
        
        List<Airplane> planeList1 = new ArrayList<>();
        
        Airplane airplane1 = new Airplane("A123","Luftansa");
        Airplane airplane2 = new Airplane("B234","Luftansa");
        planeList1.add(airplane1);
        planeList1.add(airplane2);
        FlightSchedule flightSchedule1 = new FlightSchedule(planeList1);
        Airliner airliner1 = new Airliner();
        airliner1.setAirlinerName("Luftansa");
        airliner1.setAddress("London");
        airliner1.setAirplane(planeList1);
        airliner1.setFlightSchedule(flightSchedule1);
        
        List<Airplane> planeList2 = new ArrayList<>();
        Airplane airplane3= new Airplane("BA410","British Airways");
        Airplane airplane4 = new Airplane("A310","British Airways");
        planeList2.add(airplane3);
        planeList2.add(airplane4);
        FlightSchedule flightSchedule2 = new FlightSchedule(planeList2);
        Airliner airliner2 = new Airliner();
        airliner2.setAirlinerName("British Airways");
        airliner2.setAddress("Boston");
        airliner2.setAirplane(planeList2);
        airliner2.setFlightSchedule(flightSchedule2);
        
        
        airlinerList.add(airliner1);
        airlinerList.add(airliner2);
        
        System.out.println("Tez");
        System.out.println("Airliners "+airlinerList.size());
        
    }

    public List<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(List<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }

    
    public Airliner addAirliner(String name, String address){
    Airliner airliner = new Airliner();

    airliner.setAddress(address);
    airliner.setAirlinerName(name);
    airlinerList.add(airliner);
    return airliner;    
    }
    
    
    public void deleteAirliner(Airliner airliner){
        airlinerList.remove(airliner);
    }

}
