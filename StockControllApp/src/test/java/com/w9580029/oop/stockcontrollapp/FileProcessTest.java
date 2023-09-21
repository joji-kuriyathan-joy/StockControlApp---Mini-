/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.w9580029.oop.stockcontrollapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class FileProcessTest {
    FileProcess fp = new FileProcess();
    BBStockItem bbsi = new BBStockItem();
    String stockFileName = "./resource/barkers_boutique_stock_list_example.csv";
    public FileProcessTest() {
        fp.setFileName(stockFileName);
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
     * Test of getFileName method, of class FileProcess.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        FileProcess instance = new FileProcess();
        String expResult = null;
        String result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setFileName method, of class FileProcess.
     */
    @Test
    public void testSetFileName() {
        System.out.println("setFileName");
        String fileName = "";
        FileProcess instance = new FileProcess();
        instance.setFileName(fileName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadFile method, of class FileProcess.
     */
    //@Test
    public void testLoadFile() throws Exception {
        System.out.println("loadFile");
        MMStockItem mmsi = new MMStockItem();
        FileProcess instance = new FileProcess();
        HashMap expResult = null;
        HashMap result = instance.loadFile(mmsi);
        System.out.println("XXX : "+result.toString());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeFile method, of class FileProcess.
     */
    @Test
    public void testWriteFile() throws Exception {
        System.out.println("writeFile");
        String fileName = "xyz";
        String[] header = {"Product Code", "DateTime", "Quantity", "Unite Price", "Total Price"};
         String[] record = {"101", "2023-10-12 nm", String.valueOf(10), String.valueOf(100), String.valueOf(1000)};
         List<String[]> csvData = new ArrayList<>();
        csvData.add(header);
        csvData.add(record);
        boolean transcationFlag = false;
        FileProcess instance = new FileProcess();
        instance.writeFile(fileName, csvData, transcationFlag);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
