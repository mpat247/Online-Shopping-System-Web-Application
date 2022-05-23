/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.FrontEndService.Persistance;

/**
 *
 * @author student
 */
import java.sql.*;


public class userconnect {
    private static Connection con;
    
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+ connection + "/ACCOUNTS?serverTimezone=UTC", "root","student");
            System.out.println("Connection established");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}