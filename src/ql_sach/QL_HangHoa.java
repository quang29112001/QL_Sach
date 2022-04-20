/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_sach;

import ql_sach.DBConnect.SQLProcessing;
import ql_sach.Views.JLogin;

/**
 *
 * @author HaPhong
 */
public class QL_HangHoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello anh em");
        SQLProcessing mySQLProcessing= new SQLProcessing();
        JLogin a= new JLogin();
    }
    
}
