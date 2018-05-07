/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven.chattreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author dmora
 */
public class ThreadOutClientChat implements Runnable {

    Socket socket = null;
    PrintWriter print = null;
    BufferedReader breader = null;

    public ThreadOutClientChat(Socket socket) {
        this.socket = socket;
    }//end constructor

    @Override
    public void run() {
        try {
            if (socket.isConnected()) {
                System.out.println("Client connected to " + socket.getInetAddress() + " on port " + socket.getPort());
                this.print = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    System.out.println("Type your message to send to server..type '.' to exit");
                    breader = new BufferedReader(new InputStreamReader(System.in));
                    String msgtoServerString = null;
                    msgtoServerString = breader.readLine();
                    this.print.println(msgtoServerString);
                    this.print.flush();

                    if (msgtoServerString.equals(".")) {
                        break;
                    }
                }//end while
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }//end run method

}//end class
