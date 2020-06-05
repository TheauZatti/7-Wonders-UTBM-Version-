package fr.utbm.lo43.model;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class ClientThread implements Runnable{
	
	private Socket s;
	private Server server;
	private DataInputStream dis;
	private DataOutputStream dos; 
	private Player player;
	private int count = 0;
	
	ClientThread(Socket socket, Server server) {
		this.s = socket;
		this.player = new Player("Player n°" + (++count));
		this.server = server;
	}

	@Override
	public void run(){
		System.out.println("Démarrage de la communication...");
		boolean closeConnexion = false;
		while(!s.isClosed()){	         
			try {          
				this.dis = new DataInputStream(s.getInputStream()); 
				this.dos = new DataOutputStream(s.getOutputStream());
				
				String response = dis.readUTF();
				String[] request;
				String cmd = "";
				String args = "";
				
				if(response.contains(":")) {
					request = response.split(":");
					cmd = request[0];
					args = request[1];
				}else {
					cmd = response;
				}
		            		            
		        String toSend = ""; 
		        
		        TurnManager tm = server.getTM();
		        tm.addPlayer(this.player);
		            
		            switch(cmd.toUpperCase()){
		            	case "READY":
		            		server.ready();
		            		break;
		            	case "CHOICE":
		            		if(!args.isEmpty()) {
		            			Card c = CardList.findByName(args.split(",")[0]);
		            			if(c != null) {
		            				if(c instanceof RessourceCard) {
		            					if(RessourceList.findByName(args.split(",")[1]) != null) {
		            						((RessourceCard) c).setChoosenRes(RessourceList.findByName(args.split(",")[1]));
		            						toSend = "RESSOURCE_CHOSEN";
		            					}else {
		            						toSend = "RESSOURCE_NOT_FOUND";
		            					}
		            				}else if(c instanceof TradeCard){
		            					if(RessourceList.findByName(args.split(",")[1]) != null) {
		            						((TradeCard) c).chooseRes(RessourceList.findByName(args.split(",")[1]));
		            						toSend = "RESSOURCE_CHOSEN";
		            					}else {
		            						toSend = "RESSOURCE_NOT_FOUND";
		            					}
		            				}
		            			}else {
		            				Wonder w = WonderList.findByName(args.split(",")[1]);
		            				if(w != null) {
		            					if(RessourceList.findByName(args.split(",")[1]) != null) {
		            						w.chooseRes(RessourceList.findByName(args.split(",")[1]));
		            						toSend = "RESSOURCE_CHOSEN";
		            					}else if(args.split(",")[1].equalsIgnoreCase("Muscles") || args.split(",")[1].equalsIgnoreCase("Soirees") || args.split(",")[1].equalsIgnoreCase("Connaissances")) {
		            						w.setType(args.split(",")[1]);
		            						toSend = "TYPE_CHOSEN";
		            					}else {
		            						toSend = "RESSOURCE_OR_TYPE_NOT_FOUND";
		            					}
		            				}else {
		            					toSend = "CARD_OR_WONDER_NOT_FOUND";
		            				}			
		            			}
		            		}
		            		break;
		            	case "PICK":
		            	  if(!args.isEmpty()) {
		            		  if(CardList.findByName(args.replace('{', ' ').replace('}', ' ').trim()) != null){
		            			  Card c = CardList.findByName(args.replace('{', ' ').replace('}', ' ').trim());
			            		  tm.pickCard(player, c);
			            		  toSend = "CARD_PICKED";
		            		  }else {
		            			  toSend = "RESSOURCE_NOT_FOUND";
		            		  }
		            	  }else {
		            		  toSend = "MISSING_ARG";
		            	  }
		                  break;
		               case "BUILD":
		            	  if(args.isEmpty()) {
			            	  toSend = tm.build(player);
			            	  if(toSend.equalsIgnoreCase("CARD_BUILT")) {
			            		  server.actionDone();
			            	  }
		            	  }else if(args.equalsIgnoreCase("BONUS")){
		            		  toSend = tm.build(player);
			            	  if(toSend.equalsIgnoreCase("CARD_BUILT")) {
			            		  server.bonusActionDone();			            	  
			            	  }
		            	  }
		                  break; 
		               case "STEP":
		            	  if(args.isEmpty()) {
			            	  toSend = tm.buildStep(player);
			            	  if(toSend.equalsIgnoreCase("STEP_SUCCESSFULLY_BUILT")) {
			            		  server.actionDone();
			            	  }
		            	  }else if(args.equalsIgnoreCase("BONUS")){
		            		  toSend = tm.buildStep(player);
			            	  if(toSend.equalsIgnoreCase("STEP_SUCCESSFULLY_BUILT")) {
			            		  server.bonusActionDone();			            	  
			            	  }
		            	  }
		                  break;
		               case "TRADE" :
		            	   String[] subArgs = args.split(",");
		            	   HashMap<Ressource, Integer> tradingRes = new HashMap<Ressource, Integer>();		            	   
		            	   
		            	   for(String s : subArgs) {
		            		   s.replace('{', ' ').replace('}', ' ').trim();
		            		   if(s.contains("x")) {
		            			   if(RessourceList.findByName(s.split("x")[1])!= null) {
		            				   tradingRes.put(RessourceList.findByName(s.split("x")[1]), Integer.parseInt(s.split("x")[0]));
		            			   }else {
		            				   toSend = "RESSOURCE_NOT_FOUND";
		            				   break;
		            			   }
		            		   }
		            	   }
		            	   
		            	   if(subArgs[0].equalsIgnoreCase("RIGHT")) {
		            		   toSend = server.getTM().trade(player, player.getNeighbours().get(1), tradingRes,tm.getTradeValues(player, false, true).get(0), tm.getTradeValues(player, false, true).get(1));
		            	   }else if(subArgs[0].equalsIgnoreCase("LEFT")) {
		            		   toSend = server.getTM().trade(player, player.getNeighbours().get(0), tradingRes, tm.getTradeValues(player, true, false).get(0), tm.getTradeValues(player, true, false).get(1));
		            	   }
		            	   break;
		               case "DISCARD":
		            	   toSend = tm.discard(player);
		            	   if(args.isEmpty()) {
		            		   server.actionDone(); 
		            	   }else {
		            		   server.bonusActionDone();
		            	   }
		            	   break;
		               case "END_OF_AGE":
		            	   if(args.isEmpty()) {
		            		   toSend = cmd;
		            	   }else {
		            		   if(player.getWonder().getName().equalsIgnoreCase("Corentin")) {
		            			   toSend = "PLAY_BONUS";
		            		   }else {
		            			   toSend = cmd;
		            		   }
		            	   }
		            	   break;
		               case "END_OF_GAME":
		            	   if(args.isEmpty()) {
		            		   toSend = cmd;
		            	   }else {
		            		   if(player.getWonder().getName().equalsIgnoreCase("Corentin")) {
		            			   toSend = "PLAY_BONUS";
		            		   }else {
		            			   toSend = cmd;
		            		   }
		            	   }
		            	   break;
		               case "CLOSE":
		                  toSend = "END_COMMUNICATION"; 
		                  closeConnexion = true;
		                  break;
		               default : 
		                  toSend = "UNKNOWN";                     
		                  break;
		            }
		            
		            dos.writeUTF(toSend);
		            if(closeConnexion){
		               System.err.println("Fermeture de la connexion avec " + player.getName());
		               dis = null;
			           dos = null;
			           server.deleteClient(dos);
		               s.close();
		            }
		         }catch(SocketException e){
		            System.err.println("Connexion interrompue...");
		            break;
		         } catch (IOException e) {
		            e.printStackTrace();
		         }     
			}
		}
}

