/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_sach.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ql_sach.Model.SanPham;

/**
 *
 * @author
 */
public class SQLProcessing {
    static Connection conn= MySQLConnnection.getConnection();
    static Statement statement;

    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    public static boolean checkLogin(String username, String password){
        String sql= "select *from taikhoan where username='"+username+"' and password='"+password+"'";
        try {
            ResultSet resultSet= statement.executeQuery(sql);
            resultSet.last();
            if (resultSet.getRow()>=1){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            return false;
        }
    }
    
    public static List<SanPham> getAllSanPham(){
        List<SanPham> sps= new ArrayList<>();
        String sql="select *from sach";
        try {
            ResultSet res= statement.executeQuery(sql);
            while (res.next()){
                int msp= res.getInt(1);
                String tenSP= res.getString(2);
                String xuatXu = res.getString(3);
                int sl= res.getInt(4);
                int gia= res.getInt(5);
                sps.add(new SanPham(msp, tenSP, xuatXu, sl, gia));          
            }
            return sps;
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return null;
        }
    }
    
     public static List<SanPham> getAllSanPhamDaHet(){
        List<SanPham> sps= new ArrayList<>();
        String sql="select *from sach where soLuong=0";
        try {
            ResultSet res= statement.executeQuery(sql);
            while (res.next()){
                int msp= res.getInt(1);
                String tenSP= res.getString(2);
                String xuatXu = res.getString(3);
                int sl= res.getInt(4);
                int gia= res.getInt(5);
                sps.add(new SanPham(msp, tenSP, xuatXu, sl, gia));          
            }
            return sps;
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return null;
        }
    }
     
    public static List<SanPham> getAllSanPhamSapHet(){
        List<SanPham> sps= new ArrayList<>();
        String sql="select *from sach where soLuong<=10";
        try {
            ResultSet res= statement.executeQuery(sql);
            while (res.next()){
                int msp= res.getInt(1);
                String tenSP= res.getString(2);
                String xuatXu = res.getString(3);
                int sl= res.getInt(4);
                int gia= res.getInt(5);
                sps.add(new SanPham(msp, tenSP, xuatXu, sl, gia));          
            }
            return sps;
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return null;
        }
    } 
    
    public static int themSanPham(String tenSP, String xuatXu, int sl, int gia){
        try {
            String sql= "INSERT INTO `sach` (`maSanPham`, `tenSanPham`, `xuatXu`, `soLuong`, `giaTien`) VALUES (NULL,'"+tenSP+"' ,'"+xuatXu+"', '"+sl+"', '"+gia+"');";
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return -1;
        }
    }
    public static int suaSanPham(int maSP, String tenSP, String xuatXu, int sl, int gia){
        try {
            String sql= "UPDATE `sach`  set tenSanPham= '"+tenSP+"' , xuatXu='"+xuatXu+"', soLuong="+sl+", giaTien="+gia+" where maSanPham="+maSP+"";
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return -1;
        }
    }
    
    public static int xoaSanPham(int maSP){
        try {
            String sql= "DELETE FROM `sach` where maSanPham="+maSP+"";
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
            return -1;
        }
    }
    
    
    
    
    
}
