package fr.utbm.lo43.model;

import java.io.*;

public class CommandThread implements Runnable{

	  private BufferedReader in;
	  private Server server;
	  private String cmd = "";
	  private Thread t;
	
	CommandThread(Server server) { 
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.server = server;
		this.t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run(){
	    try{
	    	while((cmd = in.readLine()) != null) {
		    	if(cmd.equalsIgnoreCase("quit")) {
		    		//System.out.println("BITE");
		    		System.exit(0);
		    	}
		    	System.out.flush();
	    	}
	    	/*while ((cmd = dis.readUTF())!=null){
	    		if (cmd.equalsIgnoreCase("quit")) {
	    			System.out.println("Déconnexion du serveur...");
	    			System.exit(0);
	    		}else if(cmd.equalsIgnoreCase("total")){
	    			System.out.println("\nNombre de connectés : " + server.getNbClients());
	    		}else{
	    			System.out.println("Cette commande n'est pas supportée");
	    			System.out.println("Essayer la commande help pour avoir une liste des commandes");
	        	}
	       	}
	        System.out.flush(); */
	    }catch (IOException e) {}
	}
}
