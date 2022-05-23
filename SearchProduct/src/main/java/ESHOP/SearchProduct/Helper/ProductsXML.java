/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.SearchProduct.Helper;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


 @XmlRootElement(name = "Products")
@XmlAccessorType (XmlAccessType.FIELD)
       public class ProductsXML{
     @XmlElement(name="Product")
           private ArrayList<ProductInfo> products;
           public List<ProductInfo>getProducts(){
               return products;
           }
          public ProductsXML(){
               
               
           }
           public void setProducts(ArrayList<ProductInfo> ps){
               products=ps;
               
           }
 }
