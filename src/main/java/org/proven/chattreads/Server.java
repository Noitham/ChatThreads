/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven.chattreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dmora
 */
public class Server {

    public static void main(String[] args) throws IOException {

        final int port = 444;
        System.out.println("Server is started");
        System.out.println("Server waiting for connection on port " + port);
        ServerSocket ss = new ServerSocket(port);

        while (true) {

            Socket clientSocket = ss.accept();
            System.out.println("Recieved connection from " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort());
            //create two threads to send and recieve from client

            ThreadInServerChat recieve = new ThreadInServerChat(clientSocket);
            Thread thread = new Thread(recieve);
            thread.start();
            ThreadOutServerChat send = new ThreadOutServerChat(clientSocket);
            Thread thread2 = new Thread(send);
            thread2.start();

        }

    }

}
