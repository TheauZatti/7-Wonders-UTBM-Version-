package fr.utbm.lo43.model;

/**Class that represent a Player in the game
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import fr.utbm.lo43.model.Card;
import fr.utbm.lo43.model.Wonder;
import fr.utbm.lo43.model.CardDeck;

public class Player {
	private String name;
	private int score;
	private ArrayList<Player> neighbours;
	private int izlyMoney;
	private int tradeIzlyMoney;
	private ArrayList<Card> buildings;
	private Wonder wonder;
	private CardDeck hand;
	private Card choosenCard;
	private int beer;
	private int grades;
	private int ECTS;
	private int looseCoins;

	/**
	 * Default constructor
	 */
	public Player(){
		this.name = ""; 
		this.score = 0;
		this.izlyMoney = 0;
		this.looseCoins = 0;
	}
	
	/**
	 * Constructor with parameters
	 * @param name Name of the player
	 */
	public Player(String name){
		this.name = name;
		this.score = 0;
		this.izlyMoney = 0;
		this.looseCoins = 0;
	}
	
	/**
	 * Getting the player name
	 * @return The name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getting the player score
	 * @return The score of the player
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Getting the two neighbors
	 * @return The list of the two neighbors
	 */
	public ArrayList<Player> getNeighbours() {
		return this.neighbours;
	}

	/**
	 * Getting the player's izly money
	 * @return Player's izly money
	 */
	public int getIzlyMoney() {
		return this.izlyMoney;
	}

	/**
	 * Add izly money to the player's treasure
	 * @param amount Amount of izly money to add
	 */
	public void addIzlyMoney(int amount) {
		this.izlyMoney += amount;
	}
	
	/**
	 * Remove izly money from the player's treasure
	 * @param amount Amount of izly money to remove
	 */
	public void removeIzlyMoney(int amount) {
		this.izlyMoney -= amount;
	}
	
	/**
	 * Getting the amount of izly money earned with trade
	 * @return Amount of izly money earned with trade
	 */
	public int getTradeIM() {
		return this.tradeIzlyMoney;
	}
	
	/**
	 * Method used to reset the amount of trade izly money
	 */
	public void resetTradeIM() {
		this.tradeIzlyMoney = 0;
	}
	
	/**
	 * Adding trade izly money
	 * @param amount The amount of money to add 
	 */
	public void addTradeIM(int amount) {
		this.tradeIzlyMoney += amount;
	}

	/**
	 * Getting the buildings of the player
	 * @return The list of all the card the player already built
	 */
	public ArrayList<Card> getBuildings() {
		return this.buildings;
	}

	/**
	 * Adding a card to the buildings list
	 * @param building The building to add
	 */
	public void addBuilding(Card building) {
		this.buildings.add(building);
	}

	/**
	 * Getting the player wonder
	 * @return The player wonder
	 */
	public Wonder getWonder() {
		return this.wonder;
	}
	
	/**
	 * Setting a wonder to this player
	 * @param w Wonder to set
	 */
	public void setWonder(Wonder w) {
		this.wonder = w;
	}

	/**
	 * Getting the cards the player has in hand
	 * @return Deck of cards representing the hand of the player
	 */
	public CardDeck getHand() {
		return this.hand;
	}

	/**
	 * Setting a hand to the player
	 * @param newHand Deck to add as a hand
	 */
	public void setHand(CardDeck newHand) {
		this.hand = newHand;
	}
	
	/**
	 * Adding a card to the hand
	 * @param c Card to add
	 */
	public void addToHand(Card c) {
		this.hand.addCard(c);
	}
	
	/**
	 * Getting the chosen card
	 * @return Card chosen by the player
	 */
	public Card getChoosenCard() {
		return this.choosenCard;
	}

	/**
	 * Setting the card 
	 * @param card Card to set
	 */
	public void setChoosenCard(Card card) {
		this.choosenCard = card;
	}
	
	/**
	 * Method to clear the chosen card
	 */
	public void clearChoosenCard() {
		this.choosenCard = null;
	}
	
	/**
	 * Getting the amount of beers owned by the player
	 * @return The amount of beers owned
	 */
	public int getBeer() {
		return beer;
	}

	/**
	 * Setting the amount of beers
	 */
	public void setBeer(int amount) {
		this.beer = amount;
	}
	
	/**
	 * Getting the amount of Grade
	 * @return Amount of grade
	 */
	public int getGrade() {
		return this.grades;
	}
	
	/**
	 * Adding a grade
	 * @param amount Grade to add
	 */
	public void addGrade(int amount) {
		this.grades += amount; 
	}
	
	/**
	 * Removing a grade
	 */
	public void removeGrade() {
		this.grades -= 1;
		this.looseCoins += 1;
		
	}
	
	/**
	 * Getting the number of looseCoins the player has
	 * @return Number of looseCoins
	 */
	public int getLooseCoins() {
		return this.looseCoins;
	}
	
	/**
	 * Getting the ECTS amount that the player has
	 * @return Number of ECTS
	 */
	public int getECTS() {
		return this.ECTS;
	}
	
	/**
	 * Add ECTS
	 * @param points Number of ECTS to add
	 */
	public void addECTS(int points) {
		this.ECTS += points;
	}
	
	/**
	 * Method to get the player resources
	 * @param isNeighbourOf true if we get this resources for trade, false otherwise
	 * @return The list of resources the player has
	 */
	public HashMap<Ressource, Integer> getPlayerRes(boolean isNeighbourOf){
		HashMap<Ressource, Integer> res = new HashMap<Ressource, Integer>();
		
		//We iterate through all the buildings the player has
		for(Card b : this.getBuildings()) {
			//If it's a resource card
			if(b instanceof RessourceCard) {
				//We check first if it's a choice card
				if(((RessourceCard) b).canChooseRese()) {
					Ressource r = ((RessourceCard) b).getChoosenRes(); //We get the chosen resource and then add it to the list
					if(!res.containsKey(r)) {
						res.put(r, 1);
					}else {
						res.put(r, res.get(r) + 1);
					}
				}else {
					//If it's not we get the resource produced
					Iterator<Entry<Ressource, Integer>> it = ((RessourceCard) b).getproductionList().entrySet().iterator();
				    while (it.hasNext()) {
						Map.Entry<Ressource, Integer> ressource = (Map.Entry<Ressource, Integer>)it.next();
				    	if(!res.containsKey(ressource.getKey())) {
				    		res.put(ressource.getKey(), ressource.getValue());
					        //System.out.println(ressource.getKey() + " = " + ressource.getValue());
				    	}else {
				    		res.put(ressource.getKey(), res.get(ressource.getKey()) + ressource.getValue());
				    	}
				    	it.remove(); // avoids a ConcurrentModificatioindexnException
				    }
				}
				//If it's a trade card
			}else if(b instanceof TradeCard) {
				//If we're not checking in the aim to trade, we can count the resources on the trading cards
				if(isNeighbourOf == false) {
					if(b.getName().equalsIgnoreCase("Bourse_merite") || b.getName().equalsIgnoreCase("Apl")) {
						Ressource r = ((RessourceCard) b).getChoosenRes();
						if(!res.containsKey(r)) {
							res.put(r, 1);
						}else {
							res.put(r, res.get(r) + 1);
						}
					}
				}
			}
		}
		
		//We're also getting the resources of the wonder
		if(res.containsKey(this.getWonder().getProd())) {
			res.put(this.getWonder().getProd(), res.get(this.getWonder().getProd()) + 1);
		}else {
			res.put(this.getWonder().getProd(), 1);
		}
		
		//If we're not checking in the aim to trade, we can count the bonus resources choice given by some wonders
		if(isNeighbourOf == false) {
			if(this.getWonder().getName().equalsIgnoreCase("Jules")) {
				if(!res.containsKey(this.getWonder().getChoosenRes())) {
					res.put(this.getWonder().getChoosenRes(), 1);
				}else {
					res.put(this.getWonder().getChoosenRes(), res.get(this.getWonder().getChoosenRes()) + 1);
				}	
			}else if(this.getWonder().getName().equalsIgnoreCase("Ikram")) {
				if(!res.containsKey(this.getWonder().getChoosenRes())) {
					res.put(this.getWonder().getChoosenRes(), 1);
				}else {
					res.put(this.getWonder().getChoosenRes(), res.get(this.getWonder().getChoosenRes()) + 1);
				}
			}
		}
		
		return res;
	}
}
