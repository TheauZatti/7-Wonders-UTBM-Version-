package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represent a ScienceCard and that inherit from Card
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class ScienceCard extends Card {

	private String symbol;
	
	/**
	 * Default constructor
	 */
	ScienceCard(){
		super();
		this.symbol = "";
	}
	
	/**
	 * Constructor with parameters
	 * @param name Name of the card
	 * @param age At which age we play this card
	 * @parem symbol The name of the symbol given by the card
	 * @param constructCostRessource The cost in resources if their is one, empty set if not
	 * @param previousBuilding The previous Building if their is one, new card if not 
	 * @param nbrOfPlayerForUse List for the frequency of the card
	 */
	ScienceCard(String symbol,String name, int age, HashMap<Ressource,Integer> constructCostRessource,Card previousBuilding, ArrayList<Integer> nbrOfPlayerForUse){
		super(name,new Color(0, 130, 24),age,constructCostRessource,0,false, previousBuilding, nbrOfPlayerForUse);
		this.symbol = symbol;
	}
	/**
	 * Getting the symbols on the card		
	 * @return the name of the symbol
	 */
	public String getSymbol() {
		return this.symbol;
	}

}
