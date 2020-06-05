package fr.utbm.lo43.model;

import java.io.*;
import java.net.*;

public class ClientConnexion implements Runnable{

   private Socket connect;
   private DataOutputStream dos;
   private DataInputStream dis;
   private String request;
   private String serverResponse;
   private boolean isRunning;
   
   public ClientConnexion(InetAddress host, int port){
      try { 
         connect = new Socket(host, port);
         this.request = "";
         this.isRunning = true;
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public void run(){
	   while(isRunning == true) {
         try {
            dos = new DataOutputStream(connect.getOutputStream());
            dis = new DataInputStream(connect.getInputStream());
            
            if(!request.isEmpty()) {
            	dos.writeUTF(this.request);
            	System.out.println("Requête envoyée !" + request); 
            	this.serverResponse = dis.readUTF();
            	//notifyAll();
                if(serverResponse.equalsIgnoreCase("END_COMMUNICATION")) {
            		this.isRunning = false;
            		dis = null;
            		dos = null;
            		connect.close();
            	}
                request = "";
            }
         } catch (IOException e1) {
            e1.printStackTrace();
         }
	  }
   }
   
   synchronized public String getServerResponse() {
	   return this.serverResponse;
   }
   
   synchronized public void makeRequest(String request) {
	   this.request = request;
   }
  
}