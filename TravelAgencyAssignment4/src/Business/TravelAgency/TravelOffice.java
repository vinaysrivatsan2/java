/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Customer.CustomerDirectory;
import Business.Airliner.*;

/**
 *
 * @author vaibhavdhoke
 */
public class TravelOffice {
    private CustomerDirectory customerDirectory;
    
    public TravelOffice(MasterTravelSchedule masterTravelSchedule) {
        this.customerDirectory = new CustomerDirectory(masterTravelSchedule);
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
    
}
