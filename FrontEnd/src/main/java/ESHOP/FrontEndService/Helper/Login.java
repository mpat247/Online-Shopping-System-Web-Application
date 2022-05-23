/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.FrontEndService.Helper;
import ESHOP.FrontEndService.Persistance.User_Crud;

/**
 *
 * @author student
 */
public class Login {

    public static boolean isAuthenticated(String uname, String password){
    UserInfo result=User_Crud.read(uname, password);
    if (result!=null){
        return true;
    }
        return false;
    }
 }

