/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codewithmotari.scims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ztl
 */
public  class DBConnection {
    private static Connection con;
    private static final String username="root";
    private static final String password="Zurion";
    private static final String url="jdbc:mysql://localhost:3306/ContactRegistry";

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("error loading the class", ex);
        }
    }
    
    
    
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(url,username,password);
    }
    
}
