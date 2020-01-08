/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author admin
 */
public class ElectricalFittingRequest extends WorkRequest{
    private String houseType;

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    private String dimension;
    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    
}
