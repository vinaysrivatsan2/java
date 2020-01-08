/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

/**
 *
 * @author vaibhavdhoke
 */
public class Airplane {
    private String planeNumber;
    private String airlinerName;

    
    

    public Airplane(String planeNumber, String airlinerName) {
        this.planeNumber = planeNumber;
        this.airlinerName = airlinerName;
    }
    
    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }
    
    @Override
    public String toString(){
     return airlinerName;
    }
    
    
    
    
}
