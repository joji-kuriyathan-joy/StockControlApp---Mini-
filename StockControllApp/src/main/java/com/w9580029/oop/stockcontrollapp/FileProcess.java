/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.w9580029.oop.stockcontrollapp;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author w9580029
 */
public class FileProcess {

    private String fileName;
    String line = null;
    private final HashMap bbStockMap = new HashMap<Integer, BBStockItem>();
    private final HashMap MmStockMap = new HashMap<Integer, MMStockItem>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @param mmsi
     * @return @throws FileNotFoundException
     */
    public HashMap loadFile(MMStockItem mmsi) throws FileNotFoundException, IOException {
        System.out.println("--- FileProcess loadFile() Start------");
        //Once the MMStock is already integerated with the BBStock then we dont want to integrate it again
        //Since we know that MMStock Product code ends with -MM so check for the product code 
        //That has -MM at the end so that we dont want to inegerate it again
        //If need as the permisson for user a Smart approach. 
        boolean isMMStockIntegerated = true;
        // Read all lines in from CSV file and add to bbstockMap
        FileReader fileReader = new FileReader(getFileName());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int lineCount = 1;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] temp = line.split(",");
                String prodCode = temp[0];
                String prodTitle = temp[1];
                String prodDescription = temp[2];
                if (prodCode.toLowerCase().endsWith("-mm")) {
                    isMMStockIntegerated = false;
                }
                int unitPrice = Integer.parseInt(temp[3].trim());
                int quantity = Integer.parseInt(temp[4].trim());

                System.out.println("\tLine Number " + String.valueOf(lineCount) + " prodCode:" + prodCode + ""
                        + " prodTitle:" + prodTitle + "" + " prodDescription:" + prodDescription + "" + " unitPrice:"
                        + String.valueOf(unitPrice) + "" + " quantity:" + String.valueOf(quantity) + "");

                bbStockMap.put(lineCount, new BBStockItem(prodCode, prodTitle, prodDescription, unitPrice, quantity));
                lineCount++;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Exception in File Process -> " + e.getMessage());
        }

        if (isMMStockIntegerated) {
            //Integerating MmStock as well
            //
            String MmStockFileName = "./resource/mead_modernity_stock_list_example.csv";
            FileReader MmFileReader = new FileReader(MmStockFileName);
            BufferedReader MmBufferedReader = new BufferedReader(MmFileReader);
            lineCount++;
            line = null;
            try {
                while ((line = MmBufferedReader.readLine()) != null) {

                    String[] temp = line.split(",");
                    int departmentId = Integer.parseInt(temp[0]);
                    String prodCode = temp[1];
                    String prodNameAndDescription = temp[2];
                    int prodPricePounds = Integer.parseInt(temp[3].trim());
                    int prodPricePence = Integer.parseInt(temp[4].trim());
                    int prodQuantity = Integer.parseInt(temp[5].trim());

                    String prodDepName = mmsi.getMmDepartmentIdName(departmentId);
                    String mmToBbProdcode = prodDepName + prodCode + "-MM";
                    String[] items = prodNameAndDescription.split("\\s{5,}");
                    String title = items[0];
                    String description = items[1];
                    bbStockMap.put(lineCount, new BBStockItem(mmToBbProdcode, title, description, prodPricePence, prodQuantity));

                    System.out.println("\tMMSTOCK ->>Line Number " + String.valueOf(lineCount) + " departmentId:" + departmentId + "" + " prodCode:" + prodCode + ""
                            + " prodNameAndDescription:" + prodNameAndDescription + "" + " prodPricePounds:" + String.valueOf(prodPricePounds) + "" + " prodPricePence:"
                            + String.valueOf(prodPricePence) + "" + " prodQuantity:" + String.valueOf(prodQuantity) + "");

                    MmStockMap.put(lineCount, new MMStockItem(departmentId, prodCode, prodNameAndDescription,
                            prodPricePounds, prodPricePence, prodQuantity));
                    lineCount++;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Exception in File Process -> " + e);
            }
            mmsi.setMmStockMap(MmStockMap);

        }

        System.out.println("--- FileProcess loadFile() End------");
        return bbStockMap;
    }

    //method to wrte back
    public void writeFile(String fileName, List<String[]> csvData, boolean transcationFlag) throws IOException {
        System.out.println("--- FileProcess writeFile() Start------");

        //Record_Transcation folder lies with in the Project Folder 
        //So if flag is true which means a Record Transcatio file is written for the current item sold
        if (transcationFlag) {
            fileName = "Record_Transcation/" + fileName;
        }

        // default separator is a comma
        try ( CSVWriter writer = new CSVWriter(new FileWriter(fileName),
                CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            writer.writeAll(csvData);
        }
        System.out.println("--- FileProcess writeFile() End------");
    }
}
