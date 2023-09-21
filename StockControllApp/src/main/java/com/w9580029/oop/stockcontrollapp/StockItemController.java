/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w9580029.oop.stockcontrollapp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w9580029
 */
public class StockItemController {

    BBStockItem bBStockItem = new BBStockItem();
    FileProcess fileProcess = new FileProcess();

    //Add Stock method
    public boolean addNewStock(HashMap<Integer, BBStockItem> newBbStockMap, HashMap<Integer, BBStockItem> bbStockMap, BBStockItem bbsi) {
        System.out.println("--- StockItemController addNewStock() Start------");
        //helper variable to know whether the stock is added to the csv file
        boolean isAddNewStock = false;
        //HashMap bbStockMap = bBStockItem.getBbStockMap();
        System.out.println("Total Stock : " + bbStockMap.size());
        System.out.println("New Stock : " + newBbStockMap.size());

        //check the new Prodcode is already exits in the bbStockMap
        //if exits then update the matched prodcode with the current new details
        //if not exits then add a new entry to the bbStockMap
        //finally write the updated bbStockMap to the csv file
        for (Map.Entry< Integer, BBStockItem> entry : newBbStockMap.entrySet()) {

            System.out.println(entry.getValue().getProdCode());

            String newProdCode = entry.getValue().getProdCode();
            String newProdTitle = entry.getValue().getProdTitle();
            String newProdDescription = entry.getValue().getProdDescription();
            int newUnitPrice = entry.getValue().getUnitPrice();
            int newQuantity = entry.getValue().getQuantity();

            //Update the Map if product Already exits 
            if (isStockExists(newProdCode, bbStockMap)) {
                System.out.println("Product Already Exits -- Updating the new details ...");
                boolean isUpdaed = updateStock(newProdCode, newBbStockMap, bbStockMap, bbsi);
                if (isUpdaed) {
                    isAddNewStock = true;
                    System.out.println("*** Updated Stock ***");
                    bbsi.setGuiDialogMessage("Product already exits\nUpdating the product details...\nProduct updated successfully.");
                }

            } else {
                //Add the product to the list 
                System.out.println("New Product Found -- Adding to the stock ...");
                int newMapCount = bbStockMap.size() + 1;
                bbStockMap.put(newMapCount, new BBStockItem(newProdCode, newProdTitle, newProdDescription, newUnitPrice, newQuantity));
                bbsi.setBbStockMap(bbStockMap);
                isAddNewStock = true;
                System.out.println("*** Added Stock ***");
                bbsi.setGuiDialogMessage("Adding new product details...\nProduct added successfully.");
            }
        }
        System.out.println("Total Stock : " + bbStockMap.size());
        bBStockItem.displayAllStock();
        System.out.println("--- StockItemController addNewStock() End------");

        //TODO: Update the CSV FILE
        return isAddNewStock;
    }

    //method to update Stock details with matching product id 
    public boolean updateStock(String newProdCode, HashMap<Integer, BBStockItem> newBbStockMap, HashMap<Integer, BBStockItem> bbStockMap, BBStockItem bbsi) {
        System.out.println("--- StockItemController updateStock() Start------");
        boolean isUpdated = false;
        //keeping a copy of All Stock before modifying
        HashMap<Integer, BBStockItem> tempBbStockMap = bbStockMap;

        //iterate the bbStockMap and find the matching prodCode, then update the tempBbStockMap, finally save the new collection
        for (Map.Entry< Integer, BBStockItem> entry : bbStockMap.entrySet()) {
            int mapKey = entry.getKey();
            String prodCode = entry.getValue().getProdCode();
            if (newProdCode.equalsIgnoreCase(prodCode)) {
                System.out.println("\tFound the prduct to update the details for :" + prodCode);
                for (Map.Entry< Integer, BBStockItem> e : newBbStockMap.entrySet()) {

                    if (newProdCode.equalsIgnoreCase(e.getValue().getProdCode())) {
//                        System.out.println("Inner : " + e.getValue().getProdCode());
                        tempBbStockMap.put(mapKey, new BBStockItem(e.getValue().getProdCode(),
                                e.getValue().getProdTitle(), e.getValue().getProdDescription(),
                                e.getValue().getUnitPrice(), e.getValue().getQuantity()));
                        isUpdated = true;
                        bbsi.setBbStockMap(tempBbStockMap);
                        bbsi.setGuiDialogMessage("Updating the product details...\nProduct updated successfully.");
                    }
                }
            }

        }
        
//        bbsi.displayAllStock();
        System.out.println("--- StockItemController updateStock() End------");
        return isUpdated;
    }

    //method to check if the product exists in the Product Map
    public boolean isStockExists(String newProdCode, HashMap<Integer, BBStockItem> bbStockMap) {
        System.out.println("--- StockItemController isStockExists() Start------");
        boolean foundProduct = false;
        //HashMap< Integer, BBStockItem> bbStockMap = bBStockItem.getBbStockMap();

        for (Map.Entry< Integer, BBStockItem> entry : bbStockMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println("*****BB STOCK ITEMS "+entry.getValue().getProdCode());
//            
            String prodCode = entry.getValue().getProdCode();
            if (newProdCode.equalsIgnoreCase(prodCode)) {
                foundProduct = true;
            }

        }
        System.out.println("--- StockItemController isStockExists() End------");
        return foundProduct;
    }

    //method to sell the stock
    public boolean sellStock(String sellProdCode, HashMap<Integer, BBStockItem> bbStockMap, int sellQuantity, BBStockItem bbsi) {
        System.out.println("--- StockItemController sellStock() Start------");
        boolean isStockSell = false;
        //keeping a copy of All Stock before modifying
        HashMap<Integer, BBStockItem> tempBbStockMap = bbStockMap;
        for (Map.Entry< Integer, BBStockItem> entry : bbStockMap.entrySet()) {
            int mapKey = entry.getKey();
            String prodCode = entry.getValue().getProdCode();
            int Quantity = entry.getValue().getQuantity();
            if (sellProdCode.equalsIgnoreCase(prodCode)) {
                if (sellQuantity <= Quantity ) { //hasMinStockQuantity(Quantity, bbsi)
                    System.out.println("\t Has min Stock quantity :Pass");
                    int updatedQuanity = Quantity - sellQuantity;
                    System.out.println("Quantity before : " + Quantity + "---- Updted Quantity : " + updatedQuanity);
                    tempBbStockMap.put(mapKey, new BBStockItem(entry.getValue().getProdCode(),
                            entry.getValue().getProdTitle(), entry.getValue().getProdDescription(),
                            entry.getValue().getUnitPrice(), updatedQuanity));
                    bbsi.setBbStockMap(tempBbStockMap);
                    try {
                        //record a seperate transaction file for the current item sold
                        //The file contains Date_and_time, Product_code,Quantity_sold,Unite_price, total_price
                        recordSaleTranscation(prodCode, sellQuantity, entry.getValue().getUnitPrice());
                    } catch (IOException ex) {
                        Logger.getLogger(StockItemController.class.getName()).log(Level.SEVERE,null,ex);
                        
                    }
                    isStockSell = true;
                    bbsi.setGuiDialogMessage("Product sale successfull!\nTransaction recorded.");
                }
                else{
                    isStockSell = true;
                    bbsi.setGuiDialogMessage("There is not enough stock to sell this product. Please enter quantity less than the stock quantity.");
                }
            }
        }
       
        bbsi.displayAllStock();
       
        System.out.println("--- StockItemController isStockExists() End------");
        return isStockSell;
    }

    public boolean hasMinStockQuantity(int curStockQuantity,BBStockItem bbsi) {
        System.out.println("--- StockItemController hasMinStockQuantity() Start------");
        boolean hasMinQuantity = false;
        int MIN_STOCK_QUANTITY = bbsi.getMIN_STOCK_QUANTITY();

        if (curStockQuantity > MIN_STOCK_QUANTITY) {
            hasMinQuantity = true;
        }
        System.out.println("--- StockItemController hasMinStockQuantity() End------");
        return hasMinQuantity;

    }

    public void recordSaleTranscation(String prodCode, int quantitySold, int unitePrice) throws IOException {
        System.out.println("--- StockItemController recordSaleTranscation() Start------");
        //getting the current system date time and then formating the date and time string
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

        String dateTimeStr = formatter.format(dateTime);
        //Setting the Header and the record that needs to be written in the csv file

        String[] header = {"Product Code", "DateTime", "Quantity", "Unite Price", "Total Price"};
        int totalPrice = unitePrice * quantitySold;
        String[] record = {prodCode, dateTimeStr, String.valueOf(quantitySold), String.valueOf(unitePrice), String.valueOf(totalPrice)};

        //Adding the header and the record to a list to write in the csv file
        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record);
        String transactionFileName = prodCode + dateTimeStr.replace("-", "_").replace(":", "_").replaceAll("\\s", "_") + ".csv";
        //finally write the file in the csv
        fileProcess.writeFile(transactionFileName, list, true);
        System.out.println("--- StockItemController isStockExists() End------");
    }

    //Method to update the csv file when a stock is Added, Sold, and when the file App is closed 
    @SuppressWarnings("empty-statement")
    public void updateStockCSV(HashMap<Integer, BBStockItem> bbStockMap, String fileName) throws IOException {
        System.out.println("--- StockItemController updateStockCSV() Start------");
         List<String[]> list = new ArrayList<>();
        // String[] record = {};
        for (Map.Entry< Integer, BBStockItem> entry : bbStockMap.entrySet()) {
            
           String[] record = {entry.getValue().getProdCode(),entry.getValue().getProdTitle(),entry.getValue().getProdDescription(),
           String.valueOf(entry.getValue().getUnitPrice()),String.valueOf(entry.getValue().getQuantity())};
           list.add(record);
        }
        fileProcess.writeFile(fileName, list, false);
        System.out.println("--- StockItemController updateStockCSV() End------");
        
    }

    public void checkLowStockProducts(HashMap<Integer, BBStockItem> stockMap, BBStockItem bbsi) {
        System.out.println("--- StockItemController checkLowStockProducts() Start------");

        //HashMap<Integer, BBStockItem> stockMap = bBStockItem.getBbStockMap();
        System.out.println("-->>Size" + stockMap.size());
        ArrayList<String> lowStockProductList = new ArrayList<>();
        int counter = 1;
        for (Map.Entry< Integer, BBStockItem> entry : stockMap.entrySet()) {
            String prodCode = entry.getValue().getProdCode();
            String prodTitle = entry.getValue().getProdTitle();
            int Quantity = entry.getValue().getQuantity();
            if (hasMinStockQuantity(Quantity, bbsi)) {
            } else {
                System.out.println("Found Product with minStock Quantity" + prodCode + " || " + prodTitle);
                lowStockProductList.add(String.valueOf(counter) + " :Code [" + prodCode + "] Title [" + prodTitle + "] has only [" + Quantity + "] quantity.");
                counter++;
            }
        }
        bbsi.setLowStockProductList(lowStockProductList);
        System.out.println("--- StockItemController checkLowStockProducts() End------");
    }

    public boolean deleteProduct(String productCode, HashMap<Integer, BBStockItem> bbStockMap, BBStockItem bbsi ){
        boolean isDeleted = false;
        System.out.println("--- StockItemController deleteProduct() Start------");
        //keeping a copy of All Stock before modifying
        HashMap<Integer, BBStockItem> tempBbStockMap = bbStockMap;
        for (Map.Entry< Integer, BBStockItem> entry : bbStockMap.entrySet()) {
             int mapKey = entry.getKey();
            String prodCode = entry.getValue().getProdCode();
            if (productCode.equalsIgnoreCase(prodCode)) {
                System.out.println("Found matching product code : "+prodCode);
                tempBbStockMap.remove(mapKey);
                bbsi.setBbStockMap(tempBbStockMap);
                isDeleted = true;
                bbsi.setGuiDialogMessage("Product ["+productCode+"] deleted successfull.");
            }
            if(isDeleted){
                break;
            }
        }
        System.out.println("--- StockItemController deleteProduct() End------");
        return isDeleted;
    }
}
