/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.SearchProduct.Business;

import ESHOP.SearchProduct.EndPoint.MyAppServletContextListener;
import ESHOP.SearchProduct.Persistence.Search_CRUD;
import io.grpc.stub.StreamObserver;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.event.Event;
import io.kubemq.sdk.event.EventReceive;
import io.kubemq.sdk.event.Subscriber;
import io.kubemq.sdk.subscription.EventsStoreType;
import io.kubemq.sdk.subscription.SubscribeRequest;
import io.kubemq.sdk.subscription.SubscribeType;

/**
 *
 * @author student
 */

import io.kubemq.sdk.tools.Converter;
import javax.net.ssl.SSLException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Messaging {
    
    public static void Receiving_Events_Store(String cname) throws SSLException, ServerAddressNotSuppliedException{
        String channelName = cname, ClientId = "hello-subscriber";
        String kubeMQAddress = System.getenv("kubeMQAddress");
        
        
        Subscriber subscriber = new Subscriber(kubeMQAddress);
        SubscribeRequest subscribeRequest = new SubscribeRequest();
        subscribeRequest.setChannel(channelName);
        subscribeRequest.setClientID(ClientId);
        subscribeRequest.setSubscribeType(SubscribeType.EventsStore);
        subscribeRequest.setEventsStoreType(EventsStoreType.StartAtSequence);
        subscribeRequest.setEventsStoreTypeValue(1);
        
        StreamObserver<EventReceive> streamObserver = new StreamObserver<EventReceive>() {

            @Override
            public void onNext(EventReceive value) {
                try {
                    String val=(String) Converter.FromByteArray(value.getBody());
                    System.out.printf("Event Received: EventID: %s, Channel: %s, Metadata: %s, Body: %s",
                        value.getEventId(), value.getChannel(), value.getMetadata(),
                        Converter.FromByteArray(value.getBody()));
                    
                    String[] msgParts = val.split(":");
                    
                    if(msgParts.length==4){
                        
                        if(msgParts[0].equals("HOLD")){
                        
                          String productName=msgParts[1];
                          String username=msgParts[2];
                          String date=msgParts[3];
                          
                          Search_CRUD.addProduct(productName, username, date);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    System.out.printf("ClassNotFoundException: %s", e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.printf("IOException: %s", e.getMessage());
                    e.printStackTrace();
                } catch (SQLException ex) {
                    Logger.getLogger(MyAppServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }

            @Override
            public void onError(Throwable t) {
                System.out.printf("onError:  %s", t.getMessage());
            }

            @Override
            public void onCompleted() {

            }

        };
        
        
        
        subscriber.SubscribeToEvents(subscribeRequest, streamObserver);

    }

   
}
    