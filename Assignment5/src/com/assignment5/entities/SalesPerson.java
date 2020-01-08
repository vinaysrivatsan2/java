/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kasai
 */
public class SalesPerson {
    private int supplierId;
    private List<String> marketSegment;
    private List<Order> ordersList;

    public SalesPerson(int supplierId) {
        this.supplierId = supplierId;
        this.marketSegment = new ArrayList<>();
        this.ordersList = new ArrayList<>();
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public List<String> getMarketSegment() {
        return marketSegment;
    }

    public void setMarketSegment(List<String> marketSegment) {
        this.marketSegment = marketSegment;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    
    
}
