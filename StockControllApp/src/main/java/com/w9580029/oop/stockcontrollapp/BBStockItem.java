/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w9580029.oop.stockcontrollapp;

import java.util.*;

/**
 *
 * @author w9580029
 */
public class BBStockItem {
    //variable declaratons
    private String prodCode, prodTitle, prodDescription;
    private int unitPrice, quantity;
    private HashMap bbStockMap = new HashMap<Integer, BBStockItem>();
    private final int MIN_STOCK_QUANTITY = 5;
    private String guiDialogMessage = "";
    private ArrayList<String> lowStockProductList = new ArrayList<>();
    
    //getter setter methods
    public String getGuiDialogMessage() {
        return guiDialogMessage;
    }

    public void setGuiDialogMessage(String guiDialogMessage) {
        this.guiDialogMessage = guiDialogMessage;
    }

    public int getMIN_STOCK_QUANTITY() {
        return MIN_STOCK_QUANTITY;
    }

    public ArrayList<String> getLowStockProductList() {
        return lowStockProductList;
    }

    public void setLowStockProductList(ArrayList<String> lowStockProductList) {
        this.lowStockProductList = lowStockProductList;
    }

    public HashMap getBbStockMap() {
        return bbStockMap;
    }

    public void setBbStockMap(HashMap bbStockMap) {
        this.bbStockMap = bbStockMap;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BBStockItem(String prodCode, String prodTitle, String prodDescription, int unitPrice, int quantity) {
        this.prodCode = prodCode;
        this.prodTitle = prodTitle;
        this.prodDescription = prodDescription;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BBStockItem() {
    }

    @Override
    public String toString() {
        return "BBStockItem{" + "prodCode=" + prodCode + ", prodTitle=" + prodTitle + ", prodDescription=" + prodDescription + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }

    //self contained method to display all Stocks
    public void displayAllStock() {
        HashMap< Integer, BBStockItem> map = getBbStockMap();
        for (Map.Entry< Integer, BBStockItem> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
