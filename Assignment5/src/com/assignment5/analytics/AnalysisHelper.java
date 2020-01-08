/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vaibhavdhoke
 */
public class AnalysisHelper {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public void analysisBeforeAdjustment(){
           
        Map<Integer,Order> ordersMap = DataStore.getInstance().getSalesData();
        Map<Integer,Product> productMap = DataStore.getInstance().getProductsCopy();
       
        Map<Integer,Double> productToAverageSellPrice = new HashMap<>();
        Map<Integer,Double> productWithQuantity = new HashMap<>();
        Map<Integer,Double> productWithAverageSell = new HashMap<>();
       
       
       
       
        for(Map.Entry o:ordersMap.entrySet()){
            double totalPrice=0;
            double totalQuanity =0;
            Order order =(Order) o.getValue();
            Item item = order.getItem();
            double salesPrice=order.getItem().getSalesPrice()*order.getItem().getQuantity();
            if(productToAverageSellPrice.containsKey(item.getProductId())){
                salesPrice = productToAverageSellPrice.get(item.getProductId());
                totalPrice = salesPrice + item.getQuantity()*item.getSalesPrice();
                double quantity = productWithQuantity.get(item.getProductId());
                totalQuanity = quantity + item.getQuantity();
                productWithQuantity.put(item.getProductId(), totalQuanity);
                double average = 0.0;
                average = totalPrice/totalQuanity;
                productWithAverageSell.put(item.getProductId(), average);
                productToAverageSellPrice.put(order.getItem().getProductId(), totalPrice);
            }else
            {
               
                productWithAverageSell.put(item.getProductId(), item.getSalesPrice());
                productToAverageSellPrice.put(item.getProductId(), salesPrice);
                productWithQuantity.put(item.getProductId(), item.getQuantity());
               
            }
        }
//      
//        for(Product product : productMap.values()){
//           int quantity=0;
//           double total=0.0;      
//           for(Order order : ordersMap.values()){
//               if(product.getProductId()==order.getItem().getProductId()){
//                   total += order.getItem().getQuantity()*order.getItem().getSalesPrice();
//                   quantity += order.getItem().getQuantity();
//               }
//           }
//           double average = total/quantity;
//           double difference = average - product.getTargetPrice();
//           System.out.println(product.getProductId()+" | "+average+" | "+product.getTargetPrice()+" | "+difference);
//           productWithAverageSell.put(product.getProductId(), average);
//       }
       

        Map<Integer,Double> productToDifferenceMap = new HashMap<>();
       
       
        System.out.println("Product Id     |    Average                 |       Target Price    |         Difference        ");
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (Map.Entry m: productWithAverageSell.entrySet()){
            Product product = productMap.get((int)m.getKey());
            double difference = (double)m.getValue()-product.getTargetPrice();
            System.out.println("           "+m.getKey()+ "        "+df.format(m.getValue())+"                             "+product.getTargetPrice()+"                     "+df.format(difference));
            productToDifferenceMap.put((int)m.getKey(), difference);
        }
       
        Map<Integer,Double> productToPositiveDifference = new HashMap<>();
        Map<Integer,Double> producToNegativeDifference = new HashMap<>();
       
       
        for(Map.Entry p:productToDifferenceMap.entrySet()){
            if((double)p.getValue()>=0){
                productToPositiveDifference.put((int)p.getKey(), (double)p.getValue());
               
            }else {
                producToNegativeDifference.put((int)p.getKey(), (double)p.getValue());
            }
        }
       
        Set convertSet1= producToNegativeDifference.entrySet();
            List<Map.Entry<Integer,Double>> negativelist = new ArrayList<>(convertSet1);
            Collections.sort(negativelist,new Comparator<Map.Entry<Integer,Double>>(){
            public int compare(Map.Entry<Integer,Double> a,Map.Entry<Integer,Double>b){
                return Double.compare(a.getValue(),b.getValue());
            }
            });
           
         Set convertSet2= productToPositiveDifference.entrySet();
            List<Map.Entry<Integer,Double>> positivelist = new ArrayList<>(convertSet2);
            Collections.sort(positivelist,new Comparator<Map.Entry<Integer,Double>>(){
            public int compare(Map.Entry<Integer,Double> a,Map.Entry<Integer,Double>b){
                return Double.compare(a.getValue(),b.getValue());
            }
            });
           
           
            System.out.println("______________________________________________________________________");
            System.out.println("Products with averagre price more than target price before adjustment" );
            System.out.println(" Product Id|        Difference");
            System.out.println("___________________________________");
            for(int i=0;i<positivelist.size();i++){
            System.out.println("| "+positivelist.get(i).getKey()+"        |            "+df.format(positivelist.get(i).getValue())+"  ");
            }
            System.out.println("____________________________________________________________________________");
       
       
            System.out.println("Products with average price less than target price before adjustment");
            System.out.println(" Product Id|        Difference");
            System.out.println("___________________________________");
            for(int i=0;i<negativelist.size();i++){
                System.out.println("| "+negativelist.get(i).getKey()+"        |          "+df.format(negativelist.get(i).getValue())+"  ");
            }
            System.out.println("____________________________________________________________________________________________________________________");
   
    }
     public void analysisAfterAdjustment(){
           
        Map<Integer,Order> ordersMap = DataStore.getInstance().getSalesData();
        Map<Integer,Product> productMap = DataStore.getInstance().getModifiedProducts();
       
        Map<Integer,Double> productToAverageSellPrice = new HashMap<>();
        Map<Integer,Double> productWithQuantity = new HashMap<>();
        Map<Integer,Double> productWithAverageSell = new HashMap<>();
       
       
        for(Map.Entry o:ordersMap.entrySet()){
            double totalPrice=0;
            double totalQuanity =0;
            Order order =(Order) o.getValue();
            Item item = order.getItem();
            double salesPrice=order.getItem().getSalesPrice()*order.getItem().getQuantity();
            if(productToAverageSellPrice.containsKey(item.getProductId())){
                salesPrice = productToAverageSellPrice.get(item.getProductId());
                totalPrice = salesPrice + item.getQuantity()*item.getSalesPrice();
                double quantity = productWithQuantity.get(item.getProductId());
                totalQuanity = quantity + item.getQuantity();
                productWithQuantity.put(item.getProductId(), totalQuanity);
                double average = 0.0;
                average = totalPrice/totalQuanity;
                productWithAverageSell.put(item.getProductId(), average);
                productToAverageSellPrice.put(order.getItem().getProductId(), totalPrice);
            }else
            {
               
                productWithAverageSell.put(item.getProductId(), item.getSalesPrice());
                productToAverageSellPrice.put(item.getProductId(), salesPrice);
                productWithQuantity.put(item.getProductId(), item.getQuantity());
               
            }
        }
//      
//        for(Product product : productMap.values()){
//           int quantity=0;
//           double total=0.0;      
//           for(Order order : ordersMap.values()){
//               if(product.getProductId()==order.getItem().getProductId()){
//                   total += order.getItem().getQuantity()*order.getItem().getSalesPrice();
//                   quantity += order.getItem().getQuantity();
//               }
//           }
//           double average = total/quantity;
//           double difference = average - product.getTargetPrice();
//           System.out.println(product.getProductId()+" | "+average+" | "+product.getTargetPrice()+" | "+difference);
//           productWithAverageSell.put(product.getProductId(), average);
//       }
       

        Map<Integer,Double> productToDifferenceMap = new HashMap<>();
       
       
       
        System.out.println("Product Id     |    Average                 |       Target Price    |         Difference     |         Error        ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (Map.Entry m: productWithAverageSell.entrySet()){
            Product product = productMap.get((int)m.getKey());
            double difference = (double)m.getValue()-product.getTargetPrice();
            double error = (product.getTargetPrice()-(double)m.getValue())/(double)m.getValue();
            System.out.println("           "+m.getKey()+ "        "+df.format(m.getValue())+"                              "+product.getTargetPrice()+"                    "+df.format(difference)+"                 "+df.format(error*100));
            productToDifferenceMap.put((int)m.getKey(), difference);
        }
       
        Map<Integer,Double> productToPositiveDifference = new HashMap<>();
        Map<Integer,Double> producToNegativeDifference = new HashMap<>();
       
       
        for(Map.Entry p:productToDifferenceMap.entrySet()){
            if((double)p.getValue()>=0){
                productToPositiveDifference.put((int)p.getKey(), (double)p.getValue());
               
            }else {
                producToNegativeDifference.put((int)p.getKey(), (double)p.getValue());
            }
        }
       
        Set convertSet1= producToNegativeDifference.entrySet();
            List<Map.Entry<Integer,Double>> negativelist = new ArrayList<>(convertSet1);
            Collections.sort(negativelist,new Comparator<Map.Entry<Integer,Double>>(){
            public int compare(Map.Entry<Integer,Double> a,Map.Entry<Integer,Double>b){
                return Double.compare(a.getValue(),b.getValue());
            }
            });
           
         Set convertSet2= productToPositiveDifference.entrySet();
            List<Map.Entry<Integer,Double>> positivelist = new ArrayList<>(convertSet2);
            Collections.sort(positivelist,new Comparator<Map.Entry<Integer,Double>>(){
            public int compare(Map.Entry<Integer,Double> a,Map.Entry<Integer,Double>b){
                return Double.compare(a.getValue(),b.getValue());
            }
            });
           
           
            System.out.println("____________________________________________________________________");
           System.out.println("Products with averagre price more than target price after adjustment" );
            System.out.println(" Product Id|        Difference");
            System.out.println("___________________________________");
            for(int i=0;i<positivelist.size();i++){
            System.out.println("| "+positivelist.get(i).getKey()+"        |            "+df.format(positivelist.get(i).getValue())+"  ");
            }
            System.out.println("____________________________________________________________________________");
       
       
            System.out.println("Products with average price less than target price after adjustment");
            System.out.println(" Product Id|        Difference");
            System.out.println("___________________________________");
            for(int i=0;i<negativelist.size();i++){
                System.out.println("| "+negativelist.get(i).getKey()+"        |          "+df.format(negativelist.get(i).getValue())+"  ");
            }
            System.out.println("____________________________________________________________________________");
   
    }
    public void threeMostPopularProduct(){
        Map<Integer,Order> orders= DataStore.getInstance().getOrders();
        Map<Integer,Product> products = DataStore.getInstance().getProducts();
        Map<Integer,Customer> customers = DataStore.getInstance().getCustomers();
       
        Map<Integer,Double> productWithQuanity = new HashMap<>();
//        System.out.println("Orders "+orders.size());
//        System.out.println("Products "+products.size());
//        System.out.println("Customer "+customers.size());
        for(Map.Entry m:orders.entrySet()){
            Order order =(Order) m.getValue();
            Item item = order.getItem();
            //int targetPrice = 0;
            //System.out.println("Item "+item.getProductId());
            Product p= products.get(item.getProductId());
           
            if(item.getSalesPrice()>p.getTargetPrice()){
                if(productWithQuanity.containsKey(item.getProductId())){
                    double quantity = productWithQuanity.get(item.getProductId());
                    double fQuant = quantity+item.getQuantity();
                    productWithQuanity.put(item.getProductId(), fQuant);
                }else
                {
                    productWithQuanity.put(item.getProductId(), item.getQuantity());
                }
            }
           
           
        }
       
       
           Set convertSet= productWithQuanity.entrySet();
            List<Map.Entry<Integer,Double>> list = new ArrayList<>(convertSet);
            Collections.sort(list,new Comparator<Map.Entry<Integer,Double>>(){
            public int compare(Map.Entry<Integer,Double> a,Map.Entry<Integer,Double>b){
                return Double.compare(b.getValue(), a.getValue());
            }
            });
           
            System.out.println("1.Top 3 best Negotiated products");
            int count=0;
            double prevCount=-1;
            for(int i=0;i<list.size()&&count<3;i++){
                double postCount=list.get(i).getValue();
                if(postCount!=prevCount){
                    count = count+1;
                }
                prevCount=postCount;
                System.out.println("Product Id "+list.get(i).getKey()+" Quanity "+list.get(i).getValue());
            }
            System.out.println("____________________________________________________________________________");
    }
    public void topThreeBestCustomers(){
        Map<Integer,Customer> customers = DataStore.getInstance().getCustomers();
        Map<Integer,Product> products = DataStore.getInstance().getProducts();
        Map<Integer,Integer> customerToDifference = new HashMap<>();
        //Iterating over customers to get the difference of sales price and target price
        for(Map.Entry m:customers.entrySet()){
            Customer customer =(Customer) m.getValue();
            List<Order> orders = customer.getOrderList();
            int total=0;
            for(Order o:orders){
               double salesPrice = o.getItem().getSalesPrice();
                int productId = o.getItem().getProductId();
                Product product = products.get(productId);
                double targetPrice = product.getTargetPrice();
                double difference = salesPrice-targetPrice;
                total += difference;//Adding the difference in total
            }
            customerToDifference.put((int)m.getKey(),total);//mapping customer id with its profit (sales-target)
        }
       
        Set convertSet= customerToDifference.entrySet();
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(convertSet);
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer>b){
                return b.getValue() - a.getValue();
            }
            });
           
           
            System.out.println("2.Top 3 Best Customers");
            int count=0;
            int prevCount=-1;
            for(int i=0;i<list.size()&&count<3;i++){
                int postCount=list.get(i).getValue();
                if(postCount!=prevCount){
                    count = count+1;
                }
                prevCount=postCount;
                System.out.println("Customer Id "+list.get(i).getKey()+" Profit "+list.get(i).getValue());
            }
            System.out.println("____________________________________________________________________________");
    }
   
   public void topThreeSalesPeople(){
       
        Map<Integer,SalesPerson> salesPersonMap = DataStore.getInstance().getSalesPersons();
        Map<Integer,Product> products = DataStore.getInstance().getProducts();
        Map<Integer,Integer> salesPersonToProfit = new HashMap<>();
        //Iterating over customers to get the difference of sales price and target price
        for(Map.Entry sPerson:salesPersonMap.entrySet()){
            SalesPerson salesPerson = (SalesPerson) sPerson.getValue();
            List<Order> orders = salesPerson.getOrdersList();
            int totalProfit=0;
            for(Order o:orders){
                double salesPrice = o.getItem().getSalesPrice();
                int productId = o.getItem().getProductId();
                Product product = products.get(productId);
                double targetPrice = product.getTargetPrice();
                double profit = (salesPrice-targetPrice)*o.getItem().getQuantity();
                totalProfit += profit;//Adding the difference in total
            }
            salesPersonToProfit.put((int)sPerson.getKey(),totalProfit);//mapping customer id with its profit (sales-target)
        }
       
       
        Set convertSet= salesPersonToProfit.entrySet();
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(convertSet);
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer>b){
                return b.getValue() - a.getValue();
            }
            });
           
           
           
            System.out.println("3.Top 3 Best Sales Person");
            int count=0;
            int prevCount=-1;
            for(int i=0;i<list.size()&&count<3;i++){
                int postCount=list.get(i).getValue();
                if(postCount!=prevCount){
                    count = count+1;
                }
                prevCount=postCount;
                System.out.println("Sales Pereson Id "+list.get(i).getKey()+" Profit "+list.get(i).getValue());
            }
            System.out.println("____________________________________________________________________________");
    }
   
   public void totalRevenue(){
        Map<Integer,SalesPerson> salesPersonMap = DataStore.getInstance().getSalesPersons();
        Map<Integer,Product> products = DataStore.getInstance().getProducts();
        Map<Integer,Double> salesPersonToProfit = new HashMap<>();
        //Iterating over customers to get the difference of sales price and target price
        for(Map.Entry sPerson:salesPersonMap.entrySet()){
            SalesPerson salesPerson = (SalesPerson) sPerson.getValue();
            List<Order> orders = salesPerson.getOrdersList();
            double totalProfit=0;
            for(Order o:orders){
                double salesPrice = o.getItem().getSalesPrice();
                int productId = o.getItem().getProductId();
                Product product = products.get(productId);
                double targetPrice = product.getTargetPrice();
                double profit = (salesPrice-targetPrice)*o.getItem().getQuantity();
                totalProfit += profit;//Adding the difference in total
            }
            salesPersonToProfit.put((int)sPerson.getKey(),totalProfit);//mapping customer id with its profit (sales-target)
        }
       
        int totalRevenue = 0;
       
        for(Map.Entry s:salesPersonToProfit.entrySet()){
            totalRevenue+=(double)s.getValue();
        }
       
        System.out.println("4.Total Revenue "+totalRevenue);
        System.out.println("");
        System.out.println("____________________________________________________________________________________________");
    }
      
}



