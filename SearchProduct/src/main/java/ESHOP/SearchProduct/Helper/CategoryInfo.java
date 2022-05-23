/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.SearchProduct.Helper;

/**
 *
 * @author student
 */
public class CategoryInfo {
    int id;
    String category;
    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public CategoryInfo(int id , String category) {
        this.id=id;
        this.category=category;
                
    }
}
