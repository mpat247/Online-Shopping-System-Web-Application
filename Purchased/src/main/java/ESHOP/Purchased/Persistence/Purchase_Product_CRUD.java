/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.Purchased.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import ESHOP.Purchased.Helper.*;
public class Purchase_Product_CRUD {
    private static Connection getCon(){
    Connection con=null;
     try{
         
         Class.forName("com.mysql.cj.jdbc.Driver");
        //con=DriverManager.getConnection("jdbc:mysql://db:3306/hold_LBS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
       
       con=DriverManager.getConnection("jdbc:mysql://"+ connection +"/PURCHASED?autoReconnect=true&useSSL=false", "root", "student");
        System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
     public static boolean addPurchase(String username, String product){
      
        try{
            Connection con= getCon();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.now();
            String q = "insert into CART "
                    + "(Product, userName, purchaseDate) values "
                    + "('"+product+"', "
                    +"'"+username+"', "
                    +"'"+date.format(formatter)+"');";
                    Statement stmt = con.createStatement();   
                    System.out.println(q);
                    stmt.execute(q);
			con.close();
                        return true;

		}catch(Exception e){System.out.println(e);
                return false;
                }
 
        
    }
     public static PurchasedProduct getPurchased(String product){
        PurchasedProduct products=null;
        try{
            Connection con= getCon();
            
            String q = "select * from CART"
                    + " WHERE "
                    
                    + "Product = '"+product+"';";
            System.out.println(q);

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
                                String date=rs.getDate("purchaseDate").toString();
                                String username=rs.getString("userName");
                                 products = new PurchasedProduct(username,product,date);
                                
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
    
        return products;
        
    }

    public static boolean addPurchase(String product, String userid, String holddate) {
      return( addPurchase(userid, product));
    }
}
