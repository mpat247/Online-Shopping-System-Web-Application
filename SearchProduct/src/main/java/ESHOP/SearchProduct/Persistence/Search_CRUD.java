/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.SearchProduct.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import ESHOP.SearchProduct.Helper.*;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class Search_CRUD {
    
    private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+connection+"/PRODUCTS?serverTimezone=UTC","root","student");
            System.out.println("Connection established.");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
//    ("jdbc:mysql://localhost:3306/lms?autoReconnect=true&useSSL=false","root","student)");
    
    //jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC
    public static Set<ProductInfo> read(String productName){
        Set<ProductInfo> products = new HashSet <ProductInfo>();
            try{
                Connection con = getCon();
                
                
                String q = "SELECT PRODUCT.productName, PRODUCT.price, CATEGORY.categoryName, CATEGORY.categoryID FROM PRODUCT \n" +
                            "INNER JOIN CATEGORY \n" +
                            "ON PRODUCT.categoryID = CATEGORY.categoryID \n" +
                            "WHERE PRODUCT.productName=\"" + productName + "\"\n"+
                            "OR CATEGORY.categoryName=\"" + productName + "\"\n" +
                            "Group By PRODUCT.productName;";
                
                PreparedStatement ps = con.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String pname = rs.getString("productName");
                    double pprice = rs.getDouble("price");
                    String cate = rs.getString("categoryName");
                    int id=rs.getInt("categoryID");
                    CategoryInfo category=new CategoryInfo(id,cate);
                    products.add(new ProductInfo(pname, pprice, category));

                }
                con.close();
                
            }catch(Exception e){System.out.println(e);}
        
    
        return products;
    }
    public static void addProduct(String productName, String username, String date) throws ClassNotFoundException, SQLException{
      
        
            Connection con= getCon();
          
            String q = "insert into Product_Purchased "
                    + "(productName, Username, Date) values "
                    + "("+
                    "'" +productName+"'"+ ","
                    +"'"+username+"'" + ","
                    +"'"+date+"'"
                    +"');";
            Statement stmt = con.createStatement(); 
           
            stmt.execute(q);
			con.close();
                        

		 
 
        
    }
}

