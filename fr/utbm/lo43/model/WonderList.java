package fr.utbm.lo43.model;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("serial")
/**WonderList is an enum that list all the existing wonders in the 7 Wonders game
 * @author Francesco
 */
public enum WonderList {

	CORENTIN(new Wonder("corentin",new ArrayList<Integer>(){{add(3);add(0);add(7);}}, RessourceList.STYLOS.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(2));}}, new Bonus("Wonder_Zeus"), false)),
	DESISRE(new Wonder("desire",new ArrayList<Integer>(){{add(3);add(5);add(7);}}, RessourceList.NOURRITURE.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));}}, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(3));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(4));}} , null, false)),
	IKRAM(new Wonder("ikram",new ArrayList<Integer>(){{add(3);add(0);add(7);}}, RessourceList.JEUX.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));}}, new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(3));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.JEUX.getRes(), new Integer(2));}}, null, true)),	
	JULES(new Wonder("jules",new ArrayList<Integer>(){{add(3);add(0);add(7);}}, RessourceList.AMOUR.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));}}, new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(2));}}, new HashMap<Ressource,Integer>(){{put(RessourceList.AMOUR.getRes(), new Integer(2));}}, null, true)),	
	MARINE(new Wonder("marine",new ArrayList<Integer>(){{add(3);add(0);add(7);}}, RessourceList.BOISSON.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));}}, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(3));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(4));}} , null, false)),
	PAUL(new Wonder("paul",new ArrayList<Integer>(){{add(3);add(0);add(7);}}, RessourceList.SOMMEIL.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));}}, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(3));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(4));}} , null, false)),
	SULEE(new Wonder("sulee",new ArrayList<Integer>(){{add(3);add(0);add(7);}}, RessourceList.DIVERTISSEMENT.getRes(), new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));}} , new HashMap<Ressource,Integer>(){{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(2));}} , null, false));
	
	private Wonder wonder;
	
	/**
	 * Constructor of an element of this enum
	 * @param wonder The wonder that will be encapsulated in the enum element
	 */
	WonderList(Wonder wonder){
		this.wonder = wonder;
	}
	
	public String toString() {
		return null;
	}
	
	/**
	 * Getting the wonder encapsulated in the element
	 * @return the wonder encapsulated in the element
	 */
	public Wonder getWonder() {
		return this.wonder;
	}
	
	/**
	 * Method that take a card name and return the corresponding card by running a search in all elements of the enum
	 * @param name The name of the card searched
	 * @return The corresponding card object
	 */
	public static Wonder findByName(String name) {
		WonderList[] listOfWonder = WonderList.values();
		
		for(int i=0;i < listOfWonder.length - 1;i++) {
			if(listOfWonder[i].getWonder().getName().equalsIgnoreCase(name)) {
				return listOfWonder[i].getWonder();
			}
		}
		
		return null;
	}
	
	/**
	 * Method that return all the wonder of this enum
	 * @return A list with all the existing wonder inside
	 */
	public static ArrayList<Wonder> getAll(){
		WonderList[] listOfWonder = WonderList.values();
		ArrayList<Wonder> all = new ArrayList<Wonder>();
		
		for(int i=0;i<listOfWonder.length - 1;i++) {
			all.add(listOfWonder[i].getWonder());
		}
		
		return all;
	}
	
}
