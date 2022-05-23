/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.FrontEndService.Persistance;
import ESHOP.FrontEndService.Helper.UserInfo;
import java.sql.*;
/**
 *
 * @author student
 */
public class User_Crud {
    private static Connection con;
    
    public static Connection getCon(){
        con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://" + connection +"/ACCOUNTS?serverTimezone=UTC", "root","student");
            System.out.println("Connection established");
        }catch (Exception e){System.out.println(e);}
        return con;
        }
    public static UserInfo read(String uname, String password){
        UserInfo bean=null;
        try{
            Connection con=getCon();
            String q="select * from USER";
            PreparedStatement ps=con.prepareStatement(q);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String fname=rs.getString("firstName");
                String lname=rs.getString("lastname");
                String user=rs.getString("username");
                String pass=rs.getString("password");
                int usrid=rs.getInt("userid");
                if (user.equals(uname) && pass.equals(password)){
                    bean=new UserInfo (fname,lname,user,pass,usrid);
                }
            }
            con.close();
        }catch (Exception e){System.out.println(e);}
            
    return bean;
    }
   
}

