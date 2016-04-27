package com.flume.rpc.client;


import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.Charset;

public class RPCClient {
    public static void main(String[] args) {

        MyRPCClientWrapper client = null;

        String sampleData = "Hello Flume RPC!";

        for (int i = 0; i < 10; i++) {
            client = new MyRPCClientWrapper();
            client.init("localhost", 54321);
            client.sendDataToFlume(sampleData);
        }
    }
}


class MyRPCClientWrapper {

    private RpcClient client;

    private String hostname;

    private int port;

    public void init(String hostname, int port) {
        // Setup the RPCconnection
        this.hostname = hostname;
        this.port = port;
//        this.client = RpcClientFactory.getDefaultInstance(hostname, port);
        // Use thefollowing method to create a thrift client (instead of the above line):
         this.client = RpcClientFactory.getThriftInstance(hostname, port);
    }

    public void sendDataToFlume(String data) {
        // Create a Flume Event object that encapsulates the sample data
        Event event = EventBuilder.withBody(data, Charset.forName("UTF-8"));

        // Send the event
        try {
            client.append(event);
        } catch (EventDeliveryException ex) {
            ex.printStackTrace();
        } finally {
            client.close();
        }
    }
}