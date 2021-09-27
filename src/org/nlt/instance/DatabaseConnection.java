/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nlt.instance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dbcon;
    private DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookManagementCRUD","root","1234");
            System.out.println("Connection Established");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static DatabaseConnection getDatabaseConnection(){
        if (dbcon == null) {
            dbcon = new DatabaseConnection();
        } 
        return dbcon;
    }
    
   public Connection getCOnnection(){
       return con;
   }
}
