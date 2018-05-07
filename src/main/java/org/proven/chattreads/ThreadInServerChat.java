/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven.chattreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ThreadInServerChat implements Runnable {

    Socket clientSocket = null;
    BufferedReader brBufferedReader = null;

    public ThreadInServerChat(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }//end constructor

    @Override
    public void run() {
        try {
            brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            String messageString;
            while (true) {
                while ((messageString = brBufferedReader.readLine()) != null) {//assign message from client to messageString
                    if (messageString.equals(".")) {
                        break;//break to close socket if EXIT
                    }
                    System.out.println("From Client: " + messageString);//print the message from client
                    System.out.println("Please enter something to send back to client..");
                }
                this.clientSocket.close();
                System.exit(0);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}//end class
