/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Airliner.AirlinerDirectory;

/**
 *
 * @author vaibhavdhoke
 */
public class TravelAgency {
    private MasterTravelSchedule masterTravelSchedule;
    private AirlinerDirectory airlinerDirectory;
    private TravelOffice travelOffice;

    public TravelAgency() {
        this.airlinerDirectory = new AirlinerDirectory();
        this.masterTravelSchedule = new MasterTravelSchedule(airlinerDirectory);
        this.travelOffice = new TravelOffice(masterTravelSchedule);
    }

    public MasterTravelSchedule getMasterTravelSchedule() {
        return masterTravelSchedule;
    }

    public void setMasterTravelSchedule(MasterTravelSchedule masterTravelSchedule) {
        this.masterTravelSchedule = masterTravelSchedule;
    }

    public AirlinerDirectory getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(AirlinerDirectory airlinerDirectory) {
        this.airlinerDirectory = airlinerDirectory;
    }

    public TravelOffice getTravelOffice() {
        return travelOffice;
    }

    public void setTravelOffice(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }
    
}
