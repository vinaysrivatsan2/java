/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analytics.AnalysisHelper;
import com.assignment5.analytics.DataStore;
import java.io.IOException;
import com.assignment5.entities.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kasai
 */
public class GateWay {
    AnalysisHelper helper;
   

    public GateWay() {
        helper = new AnalysisHelper();
    }
    
    
    
    public static void main(String args[]) throws IOException{
        
        GateWay gateWay = new GateWay();
        DataGenerator generator = DataGenerator.getInstance();
        
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
        
        DataReader orderReader = new DataReader(generator.getOrderFilePath());
        DataReader orderReader1 = new DataReader("./SalesData1.csv");
        String[] orderRow;
        String[] orderRow1;
        //printRow(orderReader.getFileHeader());
        while((orderRow = orderReader.getNextRow()) != null){
            //printRow(orderRow);
            gateWay.generateData(orderRow);
        }
        while((orderRow1 = orderReader1.getNextRow()) != null){
            //printRow(orderRow1);
            gateWay.generateSalesData(orderRow1);
        }
        

        System.out.println("_____________________________________________________________");
        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        DataReader productReader1 = new DataReader("./ProductCatalogue1.csv");
        DataReader productReader2 = new DataReader("./ProductCatalogue2.csv");
        String[] prodRow;
        String[] prodRow1;
        String[] prodRow2;
        //printRow(productReader.getFileHeader());
        while((prodRow = productReader.getNextRow()) != null){
            //printRow(prodRow);
            gateWay.generateProduct(prodRow);
        }
        while((prodRow1 = productReader1.getNextRow()) != null){
            //printRow(prodRow1);
            gateWay.generateProductCopy(prodRow1);
        }
        while((prodRow2 = productReader2.getNextRow()) != null){
            //printRow(prodRow2);
            gateWay.generateModifiedProductCopy(prodRow2);
        }
       
        
        gateWay.runAnalysis();
        
    }
    
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
    }
    
    public void generateProduct(String[] row){
        int productId= Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Map<Integer,Product> products = DataStore.getInstance().getProducts();
        Product product = new Product(productId, minPrice, maxPrice, targetPrice);
        products.put(productId, product);
    }
    
    public void generateProductCopy(String[] row){
        int productId= Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Map<Integer,Product> products = DataStore.getInstance().getProductsCopy();
        Product product = new Product(productId, minPrice, maxPrice, targetPrice);
        products.put(productId, product);
    }
    
    public void generateModifiedProductCopy(String[] row){
        int productId= Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Map<Integer,Product> products = DataStore.getInstance().getModifiedProducts();
        Product product = new Product(productId, minPrice, maxPrice, targetPrice);
        products.put(productId, product);
    }
    
    public void generateData(String[] row){
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int salesPrice = Integer.parseInt(row[6]);
        int quanity = Integer.parseInt(row[3]);
        int orderId= Integer.parseInt(row[0]);
        int supplierId= Integer.parseInt(row[4]);
        int customerId= Integer.parseInt(row[5]);
        String marketSegment = row[7];
        Map<Integer,Item> items = DataStore.getInstance().getItems();
        
        Item item= new Item(itemId, productId, salesPrice, quanity);
        
        items.put(itemId, item);
        
        
       
        Map<Integer,Order> ordersList = DataStore.getInstance().getOrders();
        
        Order order= new Order(orderId,supplierId,customerId,item);
        
        ordersList.put(orderId, order);
        
        Map<Integer,Customer> customerList = DataStore.getInstance().getCustomers();
        if(customerList.containsKey(customerId)){
            Customer c = customerList.get(customerId);
            c.getOrderList().add(order);
        }else{
            Customer customer = new Customer(customerId);
            List<Order> orderList = customer.getOrderList();
            orderList.add(order);
            customer.setOrderList(orderList);
            customerList.put(customerId,customer);
        }
        
        Map<Integer,SalesPerson> salesPersons = DataStore.getInstance().getSalesPersons();
        
        if(salesPersons.containsKey(supplierId)){
            SalesPerson salesPerson = salesPersons.get(supplierId);
            List<Order> orderList = salesPerson.getOrdersList();
            orderList.add(order);
        }else{
            SalesPerson salesPerson = new SalesPerson(supplierId);
            List<Order> orderList = salesPerson.getOrdersList();
            List<String> segmentList = salesPerson.getMarketSegment();
            orderList.add(order);
            segmentList.add(marketSegment);
            salesPerson.setMarketSegment(segmentList);
            salesPerson.setOrdersList(orderList);
            salesPersons.put(supplierId, salesPerson);
        }
    }
    
    public void generateSalesData(String[] row){
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int salesPrice = Integer.parseInt(row[6]);
        int quanity = Integer.parseInt(row[3]);
        int orderId= Integer.parseInt(row[0]);
        int supplierId= Integer.parseInt(row[4]);
        int customerId= Integer.parseInt(row[5]);
        String marketSegment = row[7];
     
        Item item= new Item(itemId, productId, salesPrice, quanity);  
        Map<Integer,Order> ordersList = DataStore.getInstance().getSalesData();
        
        Order order= new Order(orderId,supplierId,customerId,item);
        
        ordersList.put(orderId, order);
    }
    
    
    
    private void runAnalysis(){
        
        helper.threeMostPopularProduct();
        helper.topThreeBestCustomers();
        helper.topThreeSalesPeople();
        helper.totalRevenue();
        helper.analysisBeforeAdjustment();
        helper.analysisAfterAdjustment();
    }
}
