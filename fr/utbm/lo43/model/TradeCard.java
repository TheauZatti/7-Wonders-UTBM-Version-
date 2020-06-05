package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represent a TradeCard and that inherit from Card
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class TradeCard extends Card {

	private Bonus bonus;
	private boolean canChoose;
	private Ressource choosenRes;
	
	/**
	 * Default constructor
	 */
	TradeCard(){
		super();
		this.bonus = new Bonus();
		this.canChoose = false;
		this.choosenRes = new Ressource();
	}
	
	/**
	 * Constructor with parameters
	 * @param name Name of the card
	 * @param age At which age we play this card
	 * @param canChose true if the player can choose between some resources
	 * @param isFree true if the card is free
	 * @param bonus Bonus given by the card
	 * @param constructCostRessource The cost in resources if their is one, empty set if not
	 * @param previousBuilding The previous Building if their is one, new card if not 
	 * @param nbrOfPlayerForUse List for the frequency of the card
	 */
	TradeCard(String name, int age, boolean canChose,HashMap<Ressource,Integer> constructCostRessource, boolean isFree, Card previousBuilding, ArrayList<Integer> nbrOfPlayerForUse, Bonus bonus){
		super(name, new Color(250, 192, 20), age, constructCostRessource, 0,isFree, previousBuilding, nbrOfPlayerForUse);
		this.bonus = bonus;
		this.canChoose = canChose;
		this.choosenRes = new Ressource();
	}
	
	/**
	 * Getting the given bonus
	 * @return The bonus
	 */
	public Bonus getBonus() {
		return this.bonus;
	}
	
	/**
	 * Getting the chosen resource
	 * @return The resource chosen by the player
	 */
	public Ressource getChoosenRes() {
		return this.choosenRes;
	}
	
	/**
	 * Set the resource to choose
	 * @param choice Ressource to choose
	 */
	public void chooseRes(Ressource choice) {
		this.choosenRes = choice;
	}

	/**
	 * To know if the card has a resource choice
	 * @return  true if the card has a resource choice
	 */
	public boolean canChoose() {
		return this.canChoose;
	}
	
}
