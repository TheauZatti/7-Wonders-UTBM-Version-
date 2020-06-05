package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represent a GuildCard and that inherit from Card
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class GuildCard extends Card {

	private Bonus bonus;
	
	/**
	 * Default constructor
	 */
	GuildCard(){
		super();
		this.bonus = new Bonus();
	}
	
	/**
	 * Constructor with parameters
	 * @param bonus Bonus given by the guild
	 * @param name Name of the card
	 * @param constructCostRessource The cost in resources if their is one, empty set if not
	 */
	@SuppressWarnings("serial")
	GuildCard(Bonus bonus, String name, HashMap<Ressource,Integer> constructCostRessource){
		super(name,new Color(86, 44, 110),3,constructCostRessource,0,false,new Card(), new ArrayList<Integer>() {{add(7);}});
		this.bonus = bonus;
	}

	/**
	 * Getting the card bonus
	 * @return The bonus 
	 */
	public Bonus getBonus() {
		return this.bonus;
	}

}
