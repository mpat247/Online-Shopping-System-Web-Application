/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.Purchased.Business;

import ESHOP.Purchased.Helper.PurchasedProduct;
import ESHOP.Purchased.Persistence.Purchase_Product_CRUD;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ESHOP.Purchased.Helper.PurchasedProduct;
import ESHOP.Purchased.Persistence.Purchase_Product_CRUD;
/**
 *
 * @author student
 */
public class PurchaseBusiness {
    public PurchasedProduct getProducts(String product) {
        PurchasedProduct pp = Purchase_Product_CRUD.getPurchased(product);

        return (pp);
    }

public boolean purchase(String userid, String product) throws ClassNotFoundException, SQLException, 
        ServerAddressNotSuppliedException, IOException, InterruptedException
    {
       
        boolean success = false;

        success = Purchase_Product_CRUD.addPurchase(userid, product);
        
        if(success){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("MM-dd-yyyy"));
            LocalDate date = LocalDate.now();
            
            Messaging.sendMessage("PURCHASE: " + product +":"+ userid+date.format(formatter));
        }
    
    
        return (success);
    }
}
