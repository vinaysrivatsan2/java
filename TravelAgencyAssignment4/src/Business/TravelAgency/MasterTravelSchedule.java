/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Airliner.AirlinerDirectory;
import Business.Airliner.FlightSchedule;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import Business.Airliner.*;
/**
 *
 * @author vaibhavdhoke
 */
public class MasterTravelSchedule {
    private List<FlightSchedule> masterFlightSchedule;
    private AirlinerDirectory airlinerDirectory;
    
    public MasterTravelSchedule(AirlinerDirectory airlinerDirectory) {
        this.airlinerDirectory=airlinerDirectory;
        
        List<Airliner> airliners = new ArrayList<>();
        airliners = airlinerDirectory.getAirlinerList();
        this.masterFlightSchedule =  new ArrayList<>();
        
        for(Airliner ad:airliners){
            masterFlightSchedule.add(ad.getFlightSchedule());
        }
   
    }

    
    public List<FlightSchedule> getMasterFlightSchedule() {
        return masterFlightSchedule;
    }

    public void setMasterFlightSchedule(List<FlightSchedule> masterFlightSchedule) {
        this.masterFlightSchedule = masterFlightSchedule;
    }
    
}
