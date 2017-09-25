package com.gmh.demo;


import io.socket.engineio.client.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket("ws://localhost:9092");
            socket.open();



            Thread.sleep(3000);
            socket.close();
        } catch (Exception e){

        }
    }
}
