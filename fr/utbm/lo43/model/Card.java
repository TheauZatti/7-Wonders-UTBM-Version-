package fr.utbm.lo43.model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**Card is the class that represent a Card object in the game
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class Card {

	protected String name;
	protected Color color;
	protected int age;
	protected HashMap<Ressource,Integer> constructCostRessource;
	protected int constructCostIzlyMoney;
	protected boolean isFree;
	protected Card previousBuilding;
	protected ArrayList<Integer> nbrOfPlayerForUse;

	/**
	 * Default constructor
	 */
	public Card(){
		this.name = "";
		this.color = Color.white;
		this.age = 0;
		this.constructCostRessource = new HashMap<Ressource,Integer>();
		this.constructCostIzlyMoney = 0;
		this.isFree = false;
		this.nbrOfPlayerForUse = new ArrayList<Integer>();
	}
	
	/**
	 * Constructor with all parameters 
	 */
	public Card(String name, Color color, int age, HashMap<Ressource,Integer> constructCostRessource, int constructCostIzlyMoney, boolean isFree, Card previousBuilding, ArrayList<Integer> nbrOfPlayerForUse){
		this.name = name;
		this.color = color;
		this.age = age;
		this.constructCostIzlyMoney = constructCostIzlyMoney;
		this.isFree = isFree;
		this.constructCostRessource = constructCostRessource;
		this.previousBuilding = previousBuilding;
		this.nbrOfPlayerForUse = nbrOfPlayerForUse;
	}
	
	/**
	 * Getting the card name
	 * @return The Card name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getting the card color
	 * @return The Card color
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Getting the age in which the card is used
	 * @return The age in which the card is used
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Getting the cost in ressource to build the card
	 * @return All the ressources needed to build the card
	 */
	public HashMap<Ressource,Integer> getConstructCostRessource() {
		return this.constructCostRessource;
	}
	
	/**
	 * Getting the cost in IzlyMoney to build de card
	 * @return The amount of IzlyMoney needed to build
	 */
	public int getConstructCostIM() {
		return this.constructCostIzlyMoney;
	}
	
	/**
	 * Checking if the Card is free
	 * @return true if the card is free, false otherwise
	 */
	public boolean isCardFree() {
		return this.isFree;
	}

	/**
	 * Getting the previous building 
	 * @return The card corresponding to the previous building
	 */
	public Card getPreviousBuilding() {
		return this.previousBuilding;
	}
	
	/**
	 * Getting the different number of player to know if the card can be used one or multiple time
	 * @return A list containing the number of players to know the frequency of the card in a deck
	 */
	public ArrayList<Integer> getNbrOfPlayerForUse() {
		return this.nbrOfPlayerForUse;
	}
	
}
