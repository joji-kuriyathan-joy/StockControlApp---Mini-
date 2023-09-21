/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.w9580029.oop.stockcontrollapp;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class BBStockItemTest {
    
    public BBStockItemTest() {
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
     * Test of getGuiDialogMessage method, of class BBStockItem.
     */
    @Test
    public void testGetGuiDialogMessage() {
        System.out.println("getGuiDialogMessage");
        BBStockItem instance = new BBStockItem();
        String expResult = "";
        String result = instance.getGuiDialogMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setGuiDialogMessage method, of class BBStockItem.
     */
    @Test
    public void testSetGuiDialogMessage() {
        System.out.println("setGuiDialogMessage");
        String guiDialogMessage = "";
        BBStockItem instance = new BBStockItem();
        instance.setGuiDialogMessage(guiDialogMessage);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getMIN_STOCK_QUANTITY method, of class BBStockItem.
     */
    @Test
    public void testGetMIN_STOCK_QUANTITY() {
        System.out.println("getMIN_STOCK_QUANTITY");
        BBStockItem instance = new BBStockItem();
        int expResult = 5;
        int result = instance.getMIN_STOCK_QUANTITY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getLowStockProductList method, of class BBStockItem.
     */
    @Test
    public void testGetLowStockProductList() {
        System.out.println("getLowStockProductList");
        BBStockItem instance = new BBStockItem();
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = instance.getLowStockProductList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setLowStockProductList method, of class BBStockItem.
     */
    @Test
    public void testSetLowStockProductList() {
        System.out.println("setLowStockProductList");
        ArrayList<String> lowStockProductList = null;
        BBStockItem instance = new BBStockItem();
        instance.setLowStockProductList(lowStockProductList);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getBbStockMap method, of class BBStockItem.
     */
    @Test
    public void testGetBbStockMap() {
        System.out.println("getBbStockMap");
        BBStockItem instance = new BBStockItem();
        HashMap expResult = new HashMap();
        HashMap result = instance.getBbStockMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setBbStockMap method, of class BBStockItem.
     */
    @Test
    public void testSetBbStockMap() {
        System.out.println("setBbStockMap");
        HashMap bbStockMap = null;
        BBStockItem instance = new BBStockItem();
        instance.setBbStockMap(bbStockMap);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getProdCode method, of class BBStockItem.
     */
    @Test
    public void testGetProdCode() {
        System.out.println("getProdCode");
        BBStockItem instance = new BBStockItem();
        String expResult = null;
        String result = instance.getProdCode();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setProdCode method, of class BBStockItem.
     */
    @Test
    public void testSetProdCode() {
        System.out.println("setProdCode");
        String prodCode = "101";
        BBStockItem instance = new BBStockItem();
        instance.setProdCode(prodCode);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getProdTitle method, of class BBStockItem.
     */
    @Test
    public void testGetProdTitle() {
        System.out.println("getProdTitle");
        BBStockItem instance = new BBStockItem();
        String expResult = null;
        String result = instance.getProdTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setProdTitle method, of class BBStockItem.
     */
    @Test
    public void testSetProdTitle() {
        System.out.println("setProdTitle");
        String prodTitle = "";
        BBStockItem instance = new BBStockItem();
        instance.setProdTitle(prodTitle);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getProdDescription method, of class BBStockItem.
     */
    @Test
    public void testGetProdDescription() {
        System.out.println("getProdDescription");
        BBStockItem instance = new BBStockItem();
        String expResult = null;
        String result = instance.getProdDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setProdDescription method, of class BBStockItem.
     */
    @Test
    public void testSetProdDescription() {
        System.out.println("setProdDescription");
        String prodDescription = "";
        BBStockItem instance = new BBStockItem();
        instance.setProdDescription(prodDescription);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class BBStockItem.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        BBStockItem instance = new BBStockItem();
        int expResult = 0;
        int result = instance.getUnitPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitPrice method, of class BBStockItem.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        int unitPrice = 0;
        BBStockItem instance = new BBStockItem();
        instance.setUnitPrice(unitPrice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class BBStockItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        BBStockItem instance = new BBStockItem();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class BBStockItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        BBStockItem instance = new BBStockItem();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BBStockItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BBStockItem instance = new BBStockItem();
       String expResult = "BBStockItem{prodCode=null, prodTitle=null, prodDescription=null, unitPrice=0, quantity=0}";
       
        String result = instance.toString();
        System.out.println("CCCC"+result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllStock method, of class BBStockItem.
     */
    @Test
    public void testDisplayAllStock() {
        System.out.println("displayAllStock");
        BBStockItem instance = new BBStockItem();
        instance.displayAllStock();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
