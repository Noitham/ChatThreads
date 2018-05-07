package org.proven.chattreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.*;

public class ThreadInClientChat implements Runnable {

    Socket socket = null;
    BufferedReader recieve = null;

    public ThreadInClientChat(Socket socket) {
        this.socket = socket;
    }//end constructor

    @Override
    public void run() {
        try {
            recieve = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));//get inputstream
            String msgRecieved = null;
            while ((msgRecieved = recieve.readLine()) != null) {
                System.out.println("From Server: " + msgRecieved);
                System.out.println("Please enter something to send to server..");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }//end run
    
}//end
