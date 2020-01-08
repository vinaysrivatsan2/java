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
public class Seat {
    private Integer seatNo;
    private String seatType;
    private boolean available;
    private String actualSeat;

    public Seat(Integer seatNo, String seatType, boolean available) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.available = available;
        this.actualSeat = seatType+String.valueOf(seatNo);
    }

    public String getActualSeat() {
        return actualSeat;
    }

    public void setActualSeat(String actualSeat) {
        this.actualSeat = actualSeat;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    
}
