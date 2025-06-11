/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codewithmotari.scims.util;

import com.codewithmotari.scims.config.DatasourceConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ztl
 */
public  class DBConnection {
    private static Connection con;
    private static final String username= DatasourceConfig.get("datasource.username");
    private static final String password=DatasourceConfig.get("datasource.password");
    private static final String url=DatasourceConfig.get("datasource.url");

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
