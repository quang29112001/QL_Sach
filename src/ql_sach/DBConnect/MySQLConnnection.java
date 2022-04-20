/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_sach.DBConnect;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author 
 */
public class MySQLConnnection {
    private static String DB_URL = "jdbc:mysql://localhost:3306/ql_sach";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!"+ ex.getMessage());
        }
        return conn;
    }
}
