/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESHOP.Purchased.Business;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.event.Event;

/**
 *
 * @author student
 */

import io.kubemq.sdk.tools.Converter;
import javax.net.ssl.SSLException;
import java.io.IOException;

public class Messaging {
    
    public static void sendMessage(String message) throws IOException{
        String channelName = "purchased_channel";
        String clientID = "purchased-subsriber";
        String kubeMQAddress = System.getenv("kubeMQAddress");
        
        io.kubemq.sdk.event.Channel channel = new io.kubemq.sdk.event.Channel(channelName, clientID, false, kubeMQAddress);
        
        channel.setStore(true);
        Event event = new Event();
        event.setBody(Converter.ToByteArray(message));
        event.setEventId("event-Store-");
        try {
            channel.SendEvent(event);
        } catch(SSLException e){
            System.out.printf("SSLException: %s", e.getMessage());
            e.printStackTrace();
        } catch(ServerAddressNotSuppliedException e){
            System.out.printf("ServerAddressNotSuppliedException: %s", e.getMessage());
            e.printStackTrace();
        }
        
    }

    
    
}
    