/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proven.chattreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author dmora
 */
    
public class ThreadOutServerChat implements Runnable
{
	PrintWriter pwPrintWriter;
	Socket clientSock = null;
	
	public ThreadOutServerChat(Socket clientSock)
	{
		this.clientSock = clientSock;
	}
        @Override
	public void run() {
		try{
		pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
		
		while(true)
		{
			String msgToClientString = null;
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//get userinput
			
			msgToClientString = input.readLine();//get message to send to client
			
			pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
			pwPrintWriter.flush();//flush the PrintWriter
			System.out.println("Please enter something to send back to client..");
		}//end while
		}
		catch(IOException ex){System.out.println(ex.getMessage());}	
	}//end run
}//end class
