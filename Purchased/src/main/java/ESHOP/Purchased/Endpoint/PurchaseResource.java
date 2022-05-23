/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.Purchased.Endpoint;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ESHOP.Purchased.Business.PurchaseBusiness;
import ESHOP.Purchased.Helper.PurchasedProduct;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.sql.SQLException;
@Path("purchase")
public class PurchaseResource {
@Context
    private UriInfo context;    
 public PurchaseResource(){
 }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("isPurchased/{product}")
    public String getXml(@PathParam("product") String product) {
        System.out.println(product);
        PurchaseBusiness purchase = new PurchaseBusiness();
        PurchasedProduct products = purchase.getProducts(product);
        if (products == null) {
            return("");
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(PurchasedProduct.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(products, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(PurchaseResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String  updateBookHold(@FormParam("product") String product, @FormParam("userid") String userid) throws ClassNotFoundException, 
            SQLException,
            ServerAddressNotSuppliedException,
            IOException,
            InterruptedException {
        
          PurchaseBusiness products = new PurchaseBusiness();
          boolean pp=products.purchase(userid, product);
          if(pp)
              return("Inserted");
          else
              return("Not inserted");
          
    }
 }
