/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.w9580029.oop.stockcontrollapp;

import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.w9580029.oop.stockcontrollapp.*;
import com.w9580029.oop.stockcontrollappui.StockControllAppDashboard;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class StockItemControllerTest {
    
    FileProcess fp = new FileProcess();
    BBStockItem bbsi = new BBStockItem();
    MMStockItem mmsi = new MMStockItem();
     HashMap<Integer, BBStockItem> bbStockMap= new HashMap<>();
     HashMap<Integer, BBStockItem> newBbStockMap = new HashMap<>();
    String stockFileName = "./resource/barkers_boutique_stock_list_example.csv";
    public StockItemControllerTest() {
        
        newBbStockMap.put(1, new BBStockItem("EVE1234567","An elegant red dress","Perfect for those evening parties",1000,12));
        fp.setFileName(stockFileName);
       
        try {
            bbStockMap = fp.loadFile(mmsi);
        } catch (IOException ex) {
            Logger.getLogger(StockControllAppDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        bbsi.setBbStockMap(bbStockMap);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addNewStock method, of class StockItemController.
     */
    @Test
    public void testAddNewStock() {
        System.out.println("addNewStock");
       
        StockItemController instance = new StockItemController();
        boolean expResult = true;
        boolean result = instance.addNewStock(newBbStockMap, bbStockMap, bbsi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateStock method, of class StockItemController.
     */
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock");
        String newProdCode = "EVE1234567";
        StockItemController instance = new StockItemController();
        boolean expResult = true;
        boolean result = instance.updateStock(newProdCode, newBbStockMap, bbStockMap, bbsi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isStockExists method, of class StockItemController.
     */
    @Test
    public void testIsStockExists() {
        System.out.println("isStockExists");
        String newProdCode = "EVE1234567";
       
        StockItemController instance = new StockItemController();
        boolean expResult = true;
        boolean result = instance.isStockExists(newProdCode, bbStockMap);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of sellStock method, of class StockItemController.
     */
    @Test
    public void testSellStock() {
        System.out.println("sellStock");
        String sellProdCode = "EVE1234567";
        
        int sellQuantity = 0;
        StockItemController instance = new StockItemController();
        boolean expResult = true;
        boolean result = instance.sellStock(sellProdCode, bbStockMap, sellQuantity, bbsi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of hasMinStockQuantity method, of class StockItemController.
     */
    @Test
    public void testHasMinStockQuantity() {
        System.out.println("hasMinStockQuantity");
        int curStockQuantity = 10;
       
        StockItemController instance = new StockItemController();
        boolean expResult = true;
        boolean result = instance.hasMinStockQuantity(curStockQuantity, bbsi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of recordSaleTranscation method, of class StockItemController.
     */
    @Test
    public void testRecordSaleTranscation() throws Exception {
        System.out.println("recordSaleTranscation");
        String prodCode = "EVE1234567";
        int quantitySold = 0;
        int unitePrice = 0;
        StockItemController instance = new StockItemController();
        instance.recordSaleTranscation(prodCode, quantitySold, unitePrice);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of updateStockCSV method, of class StockItemController.
     */
   // @Test
    public void testUpdateStockCSV() throws Exception {
        System.out.println("updateStockCSV");
        
        String fileName = stockFileName;
        StockItemController instance = new StockItemController();
        instance.updateStockCSV(bbStockMap, fileName);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of checkLowStockProducts method, of class StockItemController.
     */
    @Test
    public void testCheckLowStockProducts() {
        System.out.println("checkLowStockProducts");
       
        StockItemController instance = new StockItemController();
        instance.checkLowStockProducts(bbStockMap, bbsi);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class StockItemController.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        String productCode = "EVE1234567";
       
        StockItemController instance = new StockItemController();
        boolean expResult = true;
        boolean result = instance.deleteProduct(productCode, bbStockMap, bbsi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
