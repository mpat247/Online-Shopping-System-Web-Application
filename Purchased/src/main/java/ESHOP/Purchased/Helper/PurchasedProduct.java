/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.Purchased.Helper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchasedProduct {
    private String username;
    private String product;
    public PurchasedProduct(String username, String product, String holddate){
        this.username = username;
        this.product = product;
        this.holddate=holddate;
    }
    public PurchasedProduct() {
        this.product = "";
        this.holddate = "";
        this.username = "";
    }
    private String holddate;

    public String getUsername() {
        return username;
    }

    public String getHoldDate() {
        return holddate;
    }

    public String getProduct() {
        return product;
    }
}
