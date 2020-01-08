/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airliner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author vaibhavdhoke
 */
public class Flight {
    private String locationFrom;
    private String locationTo;
    private String date;
    private Airplane airplane;
    private boolean cancelled;
    private List<Seat> seatlist;
    private Integer price;

    

    public Flight() {
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.date = date;
        this.airplane = airplane;
        this.cancelled = cancelled;
        this.seatlist = new ArrayList<>();
        this.price=price;
        
        
        Seat s = new Seat(0,"",true);
        for(int i=1;i<=150;i++){
            
            if(i<=25 || i>=126){
            s=new Seat(i,"W", true);
            }else if(i>=26 && i<=50 || i>=101 && i<=125){
            s=new Seat(i,"M", true);
            }else if(i>=51&&i<=100){
            s=new Seat(i,"A", true);
            }
            seatlist.add(s);
        }
    }
    
    public Seat bookSeat(String actualSeat){
        
        for(int i= 0;i<seatlist.size();i++){
            if(seatlist.get(i).getActualSeat().equals(actualSeat)){
                seatlist.get(i).setAvailable(false);
                return seatlist.get(i);
            }
        }
        return null;
    }
    
    public List displayAvailableSeats(){
        List<Seat> tempList= new ArrayList();
        for(Seat s:seatlist){
            if(s.isAvailable()){
            tempList.add(s);
            }
        }
        return tempList;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public List<Seat> getSeatlist() {
        return seatlist;
    }

    public void setSeatlist(List<Seat> seatlist) {
        this.seatlist = seatlist;
    }
    
    @Override
    public String toString(){
    return airplane.getAirlinerName();
    }
    
    
}
