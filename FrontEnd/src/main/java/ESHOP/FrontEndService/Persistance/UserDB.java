/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.FrontEndService.Persistance;

import ESHOP.FrontEndService.Persistance.userconnect;
import ESHOP.FrontEndService.Helper.UserInfo;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author student
 */
public class UserDB {
    Connection con;
    
    public UserDB(Connection con){
        this.con = con;
    }
    
    public boolean saveUser(UserInfo user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into USER(username,password) values(?,?)";
           
           PreparedStatement pt;
           pt = this.con.prepareStatement(query);
           pt.setString(1, user.getusername());
           pt.setString(2, user.getpassword());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
}
