/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vaibhavdhoke
 */
public class DataStore {
    private static DataStore dataStore;
    
    private Map<Integer, Customer> customers;
    private Map<Integer, Item> items;
    private Map<Integer, Order> orders;
    private Map<Integer, Product> products;
    private Map<Integer, SalesPerson> salesPersons;
    private Map<Integer,Order> salesData;
    private Map<Integer,Product> productsCopy;
    private Map<Integer,Product> modifiedProducts;

    public DataStore() {
        customers =  new HashMap<>();
        items     =  new HashMap<>();
        orders    =  new HashMap<>();
        products  =  new HashMap<>();
        salesPersons   =  new HashMap<>();
        modifiedProducts   =  new HashMap<>();
        productsCopy = new HashMap<>();
        salesData = new HashMap<>();
        
    }
    
    public static DataStore getInstance(){
        if(dataStore == null)
            dataStore = new DataStore();
        return dataStore;
    }
  
    public static DataStore getDataStore() {
        return dataStore;
    }

    public static void setDataStore(DataStore dataStore) {
        DataStore.dataStore = dataStore;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, SalesPerson> getSalesPersons() {
        return salesPersons;
    }

    public void setSalesPersons(Map<Integer, SalesPerson> salesPersons) {
        this.salesPersons = salesPersons;
    }

    public Map<Integer, Product> getModifiedProducts() {
        return modifiedProducts;
    }

    public void setModifiedProducts(Map<Integer, Product> modifiedProducts) {
        this.modifiedProducts = modifiedProducts;
    }

    public Map<Integer, Order> getSalesData() {
        return salesData;
    }

    public void setSalesData(Map<Integer, Order> salesData) {
        this.salesData = salesData;
    }

    public Map<Integer, Product> getProductsCopy() {
        return productsCopy;
    }

    public void setProductsCopy(Map<Integer, Product> productsCopy) {
        this.productsCopy = productsCopy;
    }

    
    
}
