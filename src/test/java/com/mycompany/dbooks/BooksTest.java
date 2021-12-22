

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbooks;

import com.mycompany.dbooks.db.Orders;
import com.mycompany.dbooks.db.Customers;
import com.mycompany.dbooks.db.Books;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
 * @author 9977q
 */
public class BooksTest {
    
    public BooksTest() {
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
    
@org.junit.jupiter.api.Test
    public void testExport() throws Exception {
        System.out.println("export");
        HashMap<Orders, Customers> orderData = new HashMap<>();
        File outputFile = new File("output.txt");
        
        Orders o = new Orders();
        o.setIdOrders("1");
        
        Books b = new Books();
        b.setAuthor("S.King");
        b.setNameBook("Strelok");
        o.setIdOrders("1");
        
        Customers c = new Customers();
        c.setAddress("Leskova 2");
        c.setNumber("89910071684");
        c.setNameCustomer("Nikolaev Alexander");
        o.setIdOrders("1");
       
        orderData.put(o, c);
        
        Ordcust.export(orderData, outputFile);
               
        FileReader fr = new FileReader(outputFile);
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        br.close();
        
        String[] data = str.split(",");
        assertEquals(data[0], o.getIdOrders());
        assertEquals(data[1], c.getNameCustomer());
        
    }
    
@Test
    public void testImportOrders() throws Exception {
        System.out.println("importOrders");
        File inputFile = new File("input.txt");
        String idOrders = "4";
        String NameCustomer  = "Litvinov Mikhael";
        String NameBook = "Flowers for algernon";
        
        FileWriter fw     = new FileWriter(inputFile);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(idOrders + ","
                    + NameCustomer + ","
                    + NameBook + "\n");
        bw.close();
        
        HashMap<Orders, Customers> exp = new HashMap<>();
        Orders o = new Orders();
        o.setIdOrders(idOrders);
         
        Customers c = new Customers();
        c.setNameCustomer(NameCustomer);
        o.setIdOrders("4");
               
        exp.put(o, c);
        
        HashMap<Orders, Customers> result = Ordcust.importOrders(inputFile);
        assertEquals(exp, result);
    }
    
}