package com.chatroom;
import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	String string = "hi";
	public static void main(String[] args) throws IOException{
		Client client= new Client();
		client.go();
		
	}
	public void go()throws IOException{
		setUpNetworking();
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Begin Chat...");
		while(!string.equals("end")) {
			string = br.readLine();
			writer.println(string);
			writer.flush();
			
		}
	}//go end
	private void setUpNetworking() {
		try {
			sock = new Socket("127.0.0.1",5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}//setup end

	public class IncomingReader implements Runnable{
		public void run() {
		String message;
			try {
				while((message = reader.readLine())!=null) {
				System.out.println("read"+ message);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}		
		}	
	}
}
