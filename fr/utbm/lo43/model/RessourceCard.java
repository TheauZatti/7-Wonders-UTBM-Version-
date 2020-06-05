package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represent a RessourceCard and that inherit from Card
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class RessourceCard extends Card {

	private HashMap<Ressource,Integer> productionList;
	private Ressource choosenRes;
	private boolean chooseRes;
	
	/**
	 * Default constructor
	 */
	RessourceCard(){
		super();
		this.productionList = new HashMap<Ressource,Integer>();
		this.choosenRes = new Ressource();
		this.chooseRes = false;
	}
	
	/**
	 * Constructor with parameters
	 * @param productionList HashMap of resources the card produce
	 * @parem chooseRes true if the player can choose the resources produced
	 * @param name Name of the card
	 * @parem color Color of the card
	 * @param age At which age we play this card
	 * @param constructCostIzlyMoney The cost in izly money
	 * @param isFree true if the card is free
	 * @param nbrOfPlayerForUse List for the frequency of the card
	 */
	RessourceCard(HashMap<Ressource,Integer> productionList, boolean chooseRes, String name, Color color, int age,int constructCostIzlyMoney, boolean isFree, ArrayList<Integer> nbrOfPlayerForUse){
		super(name,color,age,new HashMap<Ressource, Integer>(),constructCostIzlyMoney,isFree, new Card(), nbrOfPlayerForUse);
		this.productionList = productionList;
		this.choosenRes = new Ressource();
		this.chooseRes = chooseRes;
	}

	/**
	 * Getting the production list
	 * @return A HashMap with the resources produced by the card
	 */
	public HashMap<Ressource,Integer> getproductionList() {
		return this.productionList;
	}

	/**
	 * Know if the card has a resource choice
	 * @return true if their is one
	 */
	public boolean canChooseRese() {
		return chooseRes;
	}
	
	/**
	 * Getting the chosen resource
	 * @return Resource that the player choose
	 */
	public Ressource getChoosenRes() {
		return this.choosenRes;
	}
	
	/**
	 * Setting the chosen resource
	 * @param res Chosen resource
	 */
	public void setChoosenRes(Ressource res) {
		this.choosenRes = res;
	}
	
	/**
	 * Remove the chosen resource
	 */
	public void removeChoosenRes() {
		this.choosenRes = null;
	}
	
	/**
	 * Determine if the player has already choose is resource
	 * @return true if he has
	 */
	public boolean ressourceChoosen() {
		if(choosenRes != null) {
			return true;
		}else {
			return false;
		}
	}

}
