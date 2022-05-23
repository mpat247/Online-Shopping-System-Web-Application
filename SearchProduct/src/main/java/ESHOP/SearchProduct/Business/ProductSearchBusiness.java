/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.SearchProduct.Business;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import ESHOP.SearchProduct.Helper.*;
import ESHOP.SearchProduct.Persistence.Search_CRUD;
import java.util.Arrays;
public class ProductSearchBusiness {
public  ProductsXML getProductsbyQuery(String query){
       Set<ProductInfo> products = Search_CRUD.read(query);
       Map<String ,ProductInfo> allProducts= new HashMap ();
           System.out.println("&&&&&&&&&&&&&&&&&&&&&&"+ products.size());
        for(ProductInfo product : products){
            if(allProducts.containsKey(product.getName())){
                allProducts.get(product.getName()).addCategory(product.getCategories());
            }
            else{
               
                allProducts.put(product.getName(),product);
            }
        }
        System.out.println("**********************"+ allProducts.size());
        ProductsXML cs;
        cs = new ProductsXML();
        cs.setProducts(new ArrayList(allProducts.values()));
        return (cs);
    }    
}
