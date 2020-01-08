/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Airliner.*;
import Business.TravelAgency.MasterTravelSchedule;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vaibhavdhoke
 */
public class CustomerDirectory {
    private List<Customer> customerList;
    private MasterTravelSchedule masterTravelSchedule;
    private Customer customer;
    public CustomerDirectory(MasterTravelSchedule masterTravelSchedule) {
        this.masterTravelSchedule=masterTravelSchedule;
        this.customerList = new ArrayList<>();
        Customer c1= new Customer();
        c1.setCustomerName("Tej Ganan");
        c1.setAge(25);
        Seat seat = masterTravelSchedule.getMasterFlightSchedule().get(0).getFlightSchedule().get(0).bookSeat("W2");
        
        List<Seat> l1 = new ArrayList<>();
        l1.add(seat);
        c1.setSeatList(l1);
        c1.setFlight(masterTravelSchedule.getMasterFlightSchedule().get(0).getFlightSchedule().get(0));
        
        
        Customer c2= new Customer();
        c2.setCustomerName("Tej Ganan");
        c2.setAge(25);
        Seat seat1 = masterTravelSchedule.getMasterFlightSchedule().get(0).getFlightSchedule().get(1).bookSeat("W1");
        List<Seat> l2 = new ArrayList<>();
        l2.add(seat1);
        c2.setSeatList(l2);
        c2.setFlight(masterTravelSchedule.getMasterFlightSchedule().get(0).getFlightSchedule().get(1));
        
        customerList.add(c1);
        customerList.add(c2);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    
    public Customer addCustomer(String name,Integer age, String seat,Flight flight){
        List<FlightSchedule> masterFlightSchedule = this.masterTravelSchedule.getMasterFlightSchedule();
        
        
        List<Customer> list = getCustomerList();
        for(Customer ca:list){
        if(ca.getCustomerName().equals(name)){
            List<Seat> list1 = ca.getSeatList();
            list1.add(flight.bookSeat(seat));
            ca.setSeatList(list1);
            customerList.add(ca);
            return ca;
        }
        else{
            Customer c= new Customer();
            c.setAge(age);
            c.setCustomerName(name);
            c.setFlight(flight);
            List<Seat> l1= new ArrayList<>();
            l1.add(flight.bookSeat(seat));
            c.setSeatList(l1);
            customerList.add(c);
            return c;
        }
        }
        return null;
    }
    
}
