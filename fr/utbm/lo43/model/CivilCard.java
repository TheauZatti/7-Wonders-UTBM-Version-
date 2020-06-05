package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represent a CivilCard and that inherit from Card
 * @author Francesco, Théau, Quentin, Malek
 */
public class CivilCard extends Card {

	private int ECTS;
	
	/**
	 * Default constructor
	 */
	CivilCard(){
		super();
		this.ECTS = 0;
	}
	
	/**
	 * Constructor with parameters
	 * @param ECTS Number of ECTS on the card
	 * @param name Name of the card
	 * @param age At which age we play this card
	 * @param isFree true if the building is free, false otherwise
	 * @param constructCostRessource The cost in resources if their is one, empty set if not
	 * @param previousBuilding The previous Building if their is one, new card if not 
	 * @param nbrOfPlayerForUse List for the frequency of the card
	 */
	CivilCard(int ECTS,String name,int age, HashMap<Ressource,Integer> constructCostRessource ,boolean isFree, Card previousBuilding, ArrayList<Integer> nbrOfPlayerForUse){
		super(name,new Color(42, 114, 191),age,constructCostRessource,0, isFree,previousBuilding, nbrOfPlayerForUse);
		this.ECTS = ECTS;	
	}
	
	/**
	 * Getting the number ECTS
	 * @return Number of ECTS
	 */
	public int getECTS() {
		return this.ECTS;
	}

}
