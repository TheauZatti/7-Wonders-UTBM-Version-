package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represent a MilitaryCard and that inherit from Card
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class MilitaryCard extends Card {

	private int beer;
	
	/**
	 * Default constructor
	 */
	MilitaryCard(){
		super();
		this.beer = 0;
	}
	
	/**
	 * Constructor with parameters
	 * @param beer Number of beers on the card
	 * @param name Name of the card
	 * @param age At which age we play this card
	 * @param constructCostRessource The cost in resources if their is one, empty set if not
	 * @param previousBuilding The previous Building if their is one, new card if not 
	 * @param nbrOfPlayerForUse List for the frequency of the card
	 */
	MilitaryCard(int beer,String name, int age, HashMap<Ressource,Integer> constructCostRessource,Card previousBuilding, ArrayList<Integer> nbrOfPlayerForUse){
		super(name,new Color(189, 15, 15),age,constructCostRessource,0,false,previousBuilding, nbrOfPlayerForUse);
		this.beer = beer;
	}

	/**
	 * Getting the amount of beers on the card
	 * @return Amount of beers
	 */
	public int getBeer() {
		return this.beer;
	}

}
