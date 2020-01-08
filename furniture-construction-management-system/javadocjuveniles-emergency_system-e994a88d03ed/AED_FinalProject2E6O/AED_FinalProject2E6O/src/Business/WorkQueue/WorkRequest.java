/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String remarks;
    private int order;
    private String houseType;
    private String garden;
    private int bedroom;
    private int livingroom;
    private int kitchen;
    private int bathroom;
    private String estimatedDelivery;
    private String ModeofDelivery;
    private String DeliveryType;
    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }
    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
    public String getModeofDelivery() {
        return ModeofDelivery;
    }
    public void setModeofDelivery(String ModeofDelivery) {
        this.ModeofDelivery = ModeofDelivery;
    }
    public String getDeliveryType() {
        return DeliveryType;
    }
    public void setDeliveryType(String DeliveryType) {
        this.DeliveryType = DeliveryType;
    }
    public int getLivingroom() {
        return livingroom;
    }

    public void setLivingroom(int livingroom) {
        this.livingroom = livingroom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }
    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    private String DeliveryAddress;

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    private String name;
    private String phoneNumber;
    private String address;
    private String furnitureType;
    private String woodType;
    private String dimension;
    private String quantity;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private int numberofsockets;
    private int numberoflights;
    private String heater;
    private String earthing;

    public int getNumberofsockets() {
        return numberofsockets;
    }

    public void setNumberofsockets(int numberofsockets) {
        this.numberofsockets = numberofsockets;
    }

    public int getNumberoflights() {
        return numberoflights;
    }

    public void setNumberoflights(int numberoflights) {
        this.numberoflights = numberoflights;
    }

    public String getHeater() {
        return heater;
    }

    public void setHeater(String heater) {
        this.heater = heater;
    }

    public String getEarthing() {
        return earthing;
    }

    public void setEarthing(String earthing) {
        this.earthing = earthing;
    }
    
    

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    public WorkRequest(){
        requestDate = new Date();
    }

    

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    @Override
     public String toString(){
         
         return this.getName();
     }
    }
