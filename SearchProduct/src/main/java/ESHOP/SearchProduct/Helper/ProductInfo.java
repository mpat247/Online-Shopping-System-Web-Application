/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.SearchProduct.Helper;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Product")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductInfo {
    String product;
    double price;
    ArrayList <CategoryInfo> category;
    public ProductInfo(){
        
    }
    public ProductInfo(String product, double price, CategoryInfo category){
        this.product=product;
        this.price=price;
        this.category= new ArrayList<CategoryInfo>();
        this.category.add(new CategoryInfo(category.getId(), category.getCategory()));
    }
    public String getName(){
        return product;
    }
      public ArrayList<CategoryInfo> getCategories() {
        return category;
    }
     public void addCategory(ArrayList<CategoryInfo> categories) {
         for(CategoryInfo c:categories){
            this.category.add(new CategoryInfo (c.getId(), c.getCategory()));
         }
    }
    public double getPrice(){
        return price;
    }
    
}