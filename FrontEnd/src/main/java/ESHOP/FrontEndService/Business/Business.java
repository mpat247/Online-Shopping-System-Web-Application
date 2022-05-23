/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.FrontEndService.Business;
import ESHOP.FrontEndService.Helper.*;
import ESHOP.FrontEndService.Persistance.User_Crud;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
public class Business {
    public static boolean isAuthenticated(String uname, String password){
    UserInfo result=User_Crud.read(uname, password);
    if (result!=null){
        return true;
    }
        return false;
    }
    public static ProductsXML getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        WebTarget searchwebTarget
                = searchclient.target("http://"+searchService+"/SearchProduct/webresources/Search");
        InputStream is
                = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        ProductsXML products = productsxmltoObjects(xml);
        if (token != null) {
            Client holdclient = ClientBuilder.newClient();
            WebTarget holdwebTarget
                    = holdclient.target("http://" +purchaseService+"/Purchased/webresources/purchase/isPurchased");
            for (ProductInfo product : products.getProducts()) {

                InputStream holddata
                        = holdwebTarget.path(product.getName()).queryParam("token", token).
                                request(MediaType.APPLICATION_XML).get(InputStream.class);
                try{
                    ProductInfo a=purchasexmltoObjects(IOUtils.toString(holddata, "utf-8"));
                }
                catch(Exception e){
                }
                
                
            }
        }
        return (products);

    }
    private static ProductsXML productsxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ProductsXML.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ProductsXML products = (ProductsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return products;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static ProductInfo purchasexmltoObjects(String xml) {
        if(xml.isEmpty())
            return null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ProductInfo.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ProductInfo book = (ProductInfo) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return book;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
        
}
