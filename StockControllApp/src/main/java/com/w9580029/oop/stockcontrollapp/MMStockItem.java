package com.w9580029.oop.stockcontrollapp;


import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author w9580029
 */
public class MMStockItem {

    private int departmentId;
    private String departmentIdName;
    private String code;
    private String nameAndDescription;
    private int unitPricePounds;
    private int unitPricePence;
    private int quantityInStock;
    private HashMap mmStockMap = new HashMap<Integer, MMStockItem>();
    
    public HashMap getMmStockMap() {
        return mmStockMap;
    }

    public void setMmStockMap(HashMap mmStockMap) {
        this.mmStockMap = mmStockMap;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameAndDescription() {
        return nameAndDescription;
    }

    public void setNameAndDescription(String nameAndDescription) {
        this.nameAndDescription = nameAndDescription;
    }

    public int getUnitPricePounds() {
        return unitPricePounds;
    }

    public void setUnitPricePounds(int unitPricePounds) {
        this.unitPricePounds = unitPricePounds;
    }

    public int getUnitPricePence() {
        return unitPricePence;
    }

    public void setUnitPricePence(int unitPricePence) {
        this.unitPricePence = unitPricePence;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public MMStockItem(int departmentId, String code, String nameAndDescription, int unitPricePounds, int unitPricePence, int quantityInStock) {
        this.departmentId = departmentId;
        this.code = code;
        this.nameAndDescription = nameAndDescription;
        this.unitPricePounds = unitPricePounds;
        this.unitPricePence = unitPricePence;
        this.quantityInStock = quantityInStock;
    }
    
    public String getMmDepartmentIdName(int departmentId){
        switch (departmentId) {
            case 1:
                departmentIdName = "EVE";
                break;
            case 2:
                departmentIdName = "CAS";
                break;
            default:
                departmentIdName = "SPO";
                break;
        }
        return departmentIdName;
    }
    
    public MMStockItem() {
    }

    @Override
    public String toString() {
        return "MMStockItem{" + "departmentId=" + departmentId + ", code=" + code + ", nameAndDescription=" + nameAndDescription + ", unitPricePounds=" + unitPricePounds + ", unitPricePence=" + unitPricePence + ", quantityInStock=" + quantityInStock + ", mmStockMap=" + mmStockMap + '}';
    }

}
