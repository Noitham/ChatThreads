/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven.chattreads;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author dmora
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 444);
            ThreadOutClientChat sendThread = new ThreadOutClientChat(sock);
            Thread thread = new Thread(sendThread);
            thread.start();
            ThreadInClientChat recieveThread = new ThreadInClientChat(sock);
            Thread thread2 = new Thread(recieveThread);
            thread2.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
