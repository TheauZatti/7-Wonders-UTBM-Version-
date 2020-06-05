package fr.utbm.lo43.model;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	private ArrayList<DataOutputStream> clients;
	private int nbrOfClients;
	private Integer port;
	private ServerSocket ss;
	private boolean isRunning;
	private boolean canConnect;
	private TurnManager tm;
	private int nbrOfActionsDone;
	private int nbrOfReady;
	private boolean bonusActionDone;
	
	@SuppressWarnings("serial")
	public Server(Integer port){
		this.nbrOfClients = 0;
		this.clients = new ArrayList<DataOutputStream>();
		this.port = port;
		this.isRunning = true;
		this.canConnect = true;
		this.bonusActionDone = false;
		tm = new TurnManager(new ArrayList<CardDeck>() {{add(new CardDeck().createDeck(nbrOfClients, 1));add(new CardDeck().createDeck(nbrOfClients, 2));add(new CardDeck().createDeck(nbrOfClients, 3));}});
		
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
	public void open() {
		  Server server = this;
		  printWelcome(port);
	      Thread t = new Thread(new Runnable(){
	         public void run(){
	            while(isRunning == true){
	            	long start = System.currentTimeMillis();
	            	while(System.currentTimeMillis() - start < 600000) {
	            		try {
	            			if(canConnect == true) {
	            				Socket client = ss.accept();
				                server.addClient(new DataOutputStream(client.getOutputStream()));
				                System.out.println("\nConnexion cliente détectée...");                  
				                Thread t1 = new Thread(new ClientThread(client,server));
				                t1.start();
			            	 }
			             } catch (IOException e) {
			                e.printStackTrace();
			             }
	            	}
	               
	               if((nbrOfReady == nbrOfClients)) {
	            	   server.getTM().giveWonder();
	            	   server.getTM().distributeDecks();
	            	   server.closeConnection();
	               }
	               
	               if(nbrOfActionsDone == nbrOfClients) {
	            	   String result = server.getTM().update();
	            	   Player getPlayerWithBonus = new Player();
	            	   for(Player p : server.getTM().getPlayers()) {
    					   if(p.getWonder().getName().equalsIgnoreCase("Corentin")) {
    						   getPlayerWithBonus = p;
    					   }
    				   }
	            	   if(result.equalsIgnoreCase("END_OF_AGE")) {
	            		   for(DataOutputStream dost : server.getClients()) {
	            			   try {
	            				   if(getPlayerWithBonus.getWonder().isStepBuilt(2)) {
	            					   dost.writeUTF("END_OF_AGE:BONUS");
	            					   while(!bonusActionDone) {
	            						   try {
	            							   wait();
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
	        	            			}
	            				   }else {
	            					   dost.writeUTF("END_OF_AGE");
	            				   }
	            				   server.getTM().endAge();
	            			   } catch (IOException e) {
	            				   e.printStackTrace();
	            			   }
	            		   }
	            	   }else if(result.equalsIgnoreCase("END_OF_GAME")) {
	            		   for(DataOutputStream dost : server.getClients()) {
	            			   try {
	            				   if(getPlayerWithBonus.getWonder().isStepBuilt(2)) {
	            					   dost.writeUTF("END_OF_GAME:BONUS");
	            					   while(!bonusActionDone) {
	            						   try {
	            							   wait();
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
	        	            			}
	            				   }else {
	            					   dost.writeUTF("END_OF_GAME");
	            				   }
	            				   server.getTM().endAge();
	            				   server.getTM().endGame();
	            				   String winner = "WINNER(S):";
	            				   for(Player p : server.getTM().getWinners()) {
	            					   winner += p.getName() + ",";
	            				   }
	            				   dost.writeUTF(winner);
	            			   } catch (IOException e) {
	            				   e.printStackTrace();
	            			   }
	            		   }
	            	   }
	               }
	            }
	            try {
 	               ss.close();
 	            } catch (IOException e) {
 	               e.printStackTrace();
 	               ss = null;
 	            }
	         }
	      });
	    t.start();
	}
	
	public void close() {
		this.isRunning = false;
	}
	
	private void printWelcome(Integer port) {
	    System.out.println("Démarrage du serveur.....");
	    System.out.println("Demarre sur le port : " + port.toString());
	    System.out.println("Serveur 7 Wonders démarré !");
	    System.out.println("Version : 1.1");
	    System.out.println("");
	    System.out.println("En attente de connexion...");
	    System.out.println("");
	}

	synchronized public void deleteClient(DataOutputStream dos){
	    this.nbrOfClients -= 1;
	    clients.remove(dos);
	  }

	 synchronized public void addClient(DataOutputStream dos){
	    this.nbrOfClients += 1;
	    clients.add(dos);
	  }

	  synchronized public int getNbClients()
	  {
	    return nbrOfClients;
	  }
	  
	  synchronized public ArrayList<DataOutputStream> getClients(){
		  return this.clients;
	  }
	  
	  synchronized public void closeConnection() {
		  this.canConnect = false;
	  }
	  
	  synchronized public void ready() {
		  this.nbrOfReady += 1;
	  }
	  
	  synchronized public TurnManager getTM() {
		  return this.tm;
	  }
	  
	  synchronized public void actionDone() {
		  this.nbrOfActionsDone += 1;
	  }
	  
	  synchronized public void bonusActionDone() {
		  this.bonusActionDone = true;
	  }
}
