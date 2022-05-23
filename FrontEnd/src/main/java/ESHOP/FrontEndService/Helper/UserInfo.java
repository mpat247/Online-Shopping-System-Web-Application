/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.FrontEndService.Helper;

/**
 *
 * @author student
 */
public class UserInfo {
    String firstName;
    String lastname;
    String username;
    String password;
    int userId;
    public UserInfo(String firstName, String lastname, String username, String password, int UserId){
        this.firstName=firstName;
        this.lastname=lastname;
        this.password=password;
        this.username=username;
        this.userId=userId;
    }
    public UserInfo(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getfName(){
        return firstName;
    }
    public String getlname(){
        return lastname;
    }
    public String getusername(){
        return username;
    }
    public void setusername(String username){
        this.username = username;
    }
    public String getpassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
}