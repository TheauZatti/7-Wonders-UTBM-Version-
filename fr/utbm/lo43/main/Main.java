package fr.utbm.lo43.main;

import java.net.InetAddress;

import java.net.UnknownHostException;

import fr.utbm.lo43.model.ClientConnexion;
import fr.utbm.lo43.model.Server;
import fr.utbm.lo43.view.Window;

import java.io.IOException;

/**The main class of the project
 * @author Francesco
 * @author Théau
 */
public class Main{

	/**
	 * @param args <p>Argument passed to the programm through command line. If args is "server *port*" the programm will launch in 
	 * server configuration. If args is "client *ip* *port*" the programm will launch in client mode
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException{
        if(args[0].equalsIgnoreCase("Server")) {
        	if(args[1] != null) { 
        		//Creating an object Server, parsing the args to get on which port listen and pass it to the Server arguments
   	             Server server = new Server(Integer.parseInt(args[1]));
       	         server.open(); //Opening the server
        	} 
        }else if(args[0].equalsIgnoreCase("Client")) {
        	if(args[1] != null && args[2] != null) {
			try {
				//Creating an object ClientConnexion to connect to the server and make some request
				ClientConnexion client =  new ClientConnexion(InetAddress.getByName(args[1]),Integer.parseInt(args[2]));
				Thread t = new Thread(client); //Running the client connexion in an other thread
				t.start(); //Starting the thread
				Window w = new Window(); //Opening the graphic interface
			} catch (NumberFormatException | UnknownHostException e) {
				e.printStackTrace();
			}
        	}
        } 

   }
}
