/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author tanishka
 */
public class DeliveryRequest extends WorkRequest {
     private String Remarks;
     private String DeliveryAddress;

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }
    public String getTestResult() {
        return Remarks;
    }

    public void setTestResult(String Remarks) {
        this.Remarks = Remarks;
    }
    @Override
     public String toString(){
         
         return this.getRemarks();
     }

}
