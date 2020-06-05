package fr.utbm.lo43.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**TurnManager is the class that manage all the essential method of the game, the turn handling and updating the game state
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class TurnManager {

	private ArrayList<Player> players;
	private ArrayList<Player> winners;
	private ArrayList<Wonder> wonders;
	private CardDeck discard;
	private ArrayList<CardDeck> agesDeck; 
	private int age;
	private int turnIndex;

	/**
	 * Default constructor
	 */
	public TurnManager(){
		this.players = new ArrayList<Player>();
		this.winners = new ArrayList<Player>();
		this.wonders = WonderList.getAll();
		this.discard = new CardDeck();
		this.agesDeck = new ArrayList<CardDeck>();
		this.age = 1;
		this.turnIndex = 0;
	}
	
	/**
	 * Constructor that take a list of CardDeck
	 * @param agesDeck
	 */
    public TurnManager(ArrayList<CardDeck> agesDeck){
		this.players = new ArrayList<Player>();
		this.winners = new ArrayList<Player>();
		this.wonders = WonderList.getAll();
		this.discard = new CardDeck();
		this.agesDeck = agesDeck;
		this.age = 1;
		this.turnIndex = 0;
	}
	
    /**
     * Method that update the turn and the game state in the specified case
     * @return A formated string send by the server to the client so it can update the interface
     */
	public String update() {
		//If we aren't at the end of the age
		if(this.turnIndex != 6) {
			//We transfer the money get by trade to the player account for each player and we reset the attribute that stock the trade money
			for(Player p : this.players) {
				p.addIzlyMoney(p.getTradeIM());
				p.resetTradeIM();
			}
			//Turning each decks between players
			this.deckTurn();
			//Updating the turnIndex
			turnIndex ++;
		}else {
			//If the age is 1 or 2 we indicate that an age is finished
			if(this.age != 3) {
				turnIndex = 0; // Reseting the turnIndex to restart the age
				return "END_OF_AGE";
			}else {
				return "END_OF_GAME"; //Else, we indicate the server that the game is finished
			}
		}
		return "";
	}
	
	/**
	 * Adding a player to the players list
	 * @param p The player we want to add to the players list
	 */
	public void addPlayer(Player p) {
		this.players.add(p);
	}

	/**
	 * Getting a list of all the players
	 * @return All the players
	 */
	public ArrayList<Player> getPlayers(){
		return this.players;
	}
	
	/**
	 * Getting a list of the winner(s)
	 * @return A list containing the winner or the winners if their is an e
	 */
	public ArrayList<Player> getWinners(){
		return this.winners;
	}
	
	/**
	 * Method that attribute randomly a wonder to each players
	 */
	public void giveWonder() {
		//For each players
		for(Player p : players) {
			int rand = (int) (Math.random() * wonders.size()); //Generating a random number between 0 and the number of wonders
			p.setWonder(wonders.get(rand)); //Attributing to the actual player the wonder at the random position
			wonders.remove(rand); //Removing the wonder from the list
		}
	}
	
	/**
	 * Method that distribute the age deck to all players
	 */
	public void distributeDecks() {
		CardDeck cd = agesDeck.get(age-1); //Getting the deck corresponding to the actual age
		cd.shuffle(); //Shuffle the deck
		int playerIndex = 0; //Counter to know to which player we're giving a card
		//For each card in the deck
		for(Card c: cd.getCards()) {
			if(!cd.isEmpty()) {
				players.get(playerIndex).addToHand(c); //Adding to the player number playerIndex a Card
				cd.getCards().remove(c); //Removing the given card from the deck
				if(playerIndex < players.size()) { //If we're still in the list boundaries
					playerIndex += 1; //Incrementing the playerIndex by one
				}else {
					playerIndex = 0; //Else, reseting it to zero	
				}
			}
		}
	}

	/**
	 * Method that turn the deck between players clockwise or anti-clockwise depending on the age
	 */
	public void deckTurn() {
		//Creating a temporary variable an other one to do the swap
		CardDeck temp = new CardDeck();
		CardDeck swap = new CardDeck();
		
		//If we're not at age 2, we turn clockwise
		if(age != 2) {
			for(int i=0;i<players.size();++i) {
				//If the actual player is the last
				if(i == players.size()-1) {
					players.get(0).setHand(temp); //We take as first temporary deck the deck that was on the first player hand
				}else {
					//If we've not already selected a temporary deck
					if(temp.isEmpty()) {
						temp = players.get(i+1).getHand(); //We get the deck from the next player
						players.get(i+1).setHand(players.get(i).getHand()); //We put in the next player and the actual player's hand
					}else { //if a temporary deck is selected
						swap = players.get(i+1).getHand(); //We put in swap the deck from the next player
						players.get(i+1).setHand(temp); //We put in the next player hand the deck in the temporary variable
						temp = swap; //Put swap in temp to do the next swap cycle
					}
				}
			}
		}else { //else we turn anti-clockwise, it work on the same logic that clockwise, we've just inverted indexes
			for(int i=players.size()-1;i>=0;--i) {
				if(i == 0) {
					players.get(players.size()-1).setHand(temp);
				}else {
					if(temp.isEmpty()) {
						temp = players.get(i-1).getHand();
						players.get(i-1).setHand(players.get(i).getHand());
					}else {
						swap = players.get(i-1).getHand();;
						players.get(i-1).setHand(temp);
						temp = swap;
					}
				}
			}
		}
		
	}
	
	/**
	 * Method to make a trade between two players
	 * @param p Player that want to trade
	 * @param toTradeWith Player that is the trade partner
	 * @param tradedRessources Resources to exchange
	 * @param valuePrimitive Cost of the primitive resources
	 * @param valueManufactured Cost of the manufactured resources
	 * @return Formated information for the client
	 */
	public String trade(Player p, Player toTradeWith, HashMap<Ressource, Integer> tradedRessources, int valuePrimitive, int valueManufactured) {
		int price = 0; //We create a local variable to compute the final price of the exchange
		
		/*We iterate through the HashMap representing the resources to trade and compute the price according
		 * to the fact that the resources analyzed with the iterator is primitive or manufactured
		 */
		Iterator<Entry<Ressource, Integer>> it = tradedRessources.entrySet().iterator();
	    while (it.hasNext()) {	
			Map.Entry<Ressource, Integer> ressource = (Map.Entry<Ressource, Integer>)it.next();
			if(ressource.getKey().isPrimitive()) {
				price += ressource.getValue() * valuePrimitive;
			}else {
				price += ressource.getValue() * valueManufactured;
			}
		   	it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    //Checking if the player has enough money to trade
	    if(p.getIzlyMoney() > price) {
	    	p.removeIzlyMoney(price);//Removing money
	    	toTradeWith.addTradeIM(price);//Adding money to the trade money attribute because this money only can be used during the next turn
	    	return "TRADE_SUCCESSFULL"; //Informing the client that the trade was successful
	    }else {
	    	return "NOT_ENOUGH_MONEY"; //If the trade fail, informing the client with the corresponding error code
	    }
	}
	
	/**
	 * Method used to get the cost of each resource type
	 * @param p The player that wants to trade
	 * @param toLeft true if the player trade with his left neighbor
	 * @param toRight true if the player trade with his right neighbor
	 * @return A list containing the cost for each type in the following order : primitivePrice, manufacturedPrice
	 */
	public ArrayList<Integer> getTradeValues(Player p, boolean toLeft, boolean toRight){
		//Init the two variables with initial cost
		int primitivePrice = 2; 
		int manufacturedPrice = 2;
		ArrayList<Integer> prices = new ArrayList<Integer>(); //List that we return
		
		//Checking if the player has some cards that allow him to pay less and changing the price if it's the case
		for(Card b : p.getBuildings()) {
    		if(b.getName().equalsIgnoreCase(("Bourses")) && toRight) {
    			primitivePrice = 1;
    		}else if(b.getName().equalsIgnoreCase("Apprentissage") && toLeft) {
    			primitivePrice = 1;
			}else if(b.getName().equalsIgnoreCase("CAF")) {
    			manufacturedPrice = 1;
    		}else {
    			primitivePrice = 2;
    			manufacturedPrice = 2;
    		}
    	}
		
		//Adding the prices to the list and returning it
		prices.add(primitivePrice);
		prices.add(manufacturedPrice);
		return prices;
	}
	
	/**
	 * Method called to end an Age
	 */
	public void endAge() {
		int countingBeers; //variable to count the beers of each players
		
		for(Player p : players) {
			countingBeers = 0; 
			//We loop through all the actual player buildings
			for(Card c : p.getBuildings()) {
				if(c instanceof MilitaryCard) {
					countingBeers += ((MilitaryCard) c).getBeer(); //If the card is a MilitaryCard we get the amount of beers given by the card and had it to the counting variable
				}
			}
			//If the player got the Wonder Paul and if the second step is built, we count the two shields given by the wonder
			if(p.getWonder().getName().equalsIgnoreCase("Paul")) {
				if(p.getWonder().isStepBuilt(2)) {
					countingBeers += 2;
				}
			}
			//We save the total in the corresponding attribute
			p.setBeer(countingBeers);
		}
		
		//For each player we compare the number of beers the actual player has with the number of beers is neighbors have
		for(Player p: players) {
			ArrayList<Player> neighbours = p.getNeighbours(); //We get the two neighbors
			for(Player n : neighbours) { //For each neighbor
				if(n.getBeer() < p.getBeer()) { //Comparing the number of beers, and depending of the age add a Grade to the player
					switch(this.age) {
						case 1:
							p.addGrade(1);
							break;
						case 2:
							p.addGrade(3);
							break;
						case 3:
							p.addGrade(5);
							break;
					}
				}else {
					p.removeGrade(); //If he has less than the neighbor, we remove a Grade
				}
			}
		}	
	}
	
	/**
	 * Method called in the endGame method that compute the number of points 
	 * @param sc List of ScienceCard used to compute the combinations
	 * @param p ScienceCard's belonger
	 * @return The amount of points resulting of the differents combinations and number of each symbols
	 */
	public int getScientificCombination(ArrayList<ScienceCard> sc, Player p) {
		int numberOfMuscle = 0;
		int numberOfParty = 0;
		int numberOfKnowledge = 0;
		int numberOfCombination = 0;
		int min = 0;
		int temp = 0;
		int points = 0;
		
		//We get the numbers of each symbol by iterating through the ScienceCard list
		for(ScienceCard s : sc) {
			if(s.getSymbol().equalsIgnoreCase("Muscle")) {
				numberOfMuscle += 1;
			}else if(s.getSymbol().equalsIgnoreCase("Soirees")) {
				numberOfParty += 1;
			}else if(s.getSymbol().equalsIgnoreCase("Connaissances")) {
				numberOfKnowledge += 1;
			}
		}
		
		//Getting also the symbols chosen by the player on the corresponding wonder if the step 2 is built
		if(p.getWonder().getName().equalsIgnoreCase("Marine")) {
			if(!p.getWonder().getType().equals("")) {
				if(p.getWonder().getType().equalsIgnoreCase("Muscle")) {
					numberOfMuscle += 1;
				}else if(p.getWonder().getType().equalsIgnoreCase("Soirees")) {
					numberOfParty += 1;
				}else if(p.getWonder().getType().equalsIgnoreCase("Connaissances")) {
					numberOfKnowledge += 1;
				}
			}
		}
		
		//Getting the symbol given by the specific guild card
		String symbolGuild = "";
		for(Card c : p.getBuildings()) {
			if(c instanceof GuildCard) {
				if(c.getName().equalsIgnoreCase("Guild_troll")) {
					symbolGuild = ((GuildCard) c).getBonus().giveBonus(p, true);
				}
			}
		}
		
		if(symbolGuild.equalsIgnoreCase("Muscle")) {
			numberOfMuscle += 1;
		}else if(symbolGuild.equalsIgnoreCase("Soirees")) {
			numberOfParty += 1;
		}else if(symbolGuild.equalsIgnoreCase("Connaissances")) {
			numberOfKnowledge += 1;
		}
		
		//Comparing the number of each symbol and getting the smallest one to know how many combination of 3 differets symbols we can do
		min = Math.min(numberOfParty, Math.min(numberOfKnowledge, numberOfMuscle));
		if(min == 0) {
			numberOfCombination = 0;
		}else if(min == numberOfMuscle) {
			numberOfCombination = numberOfParty - (numberOfParty%min);
			temp = numberOfKnowledge - (numberOfKnowledge%min);
			if(temp < numberOfCombination) {
				numberOfCombination = temp;
			}
		}else if(min == numberOfParty) {
			numberOfCombination = numberOfMuscle - (numberOfMuscle%min);
			temp = numberOfKnowledge - (numberOfKnowledge%min);
			if(temp < numberOfCombination) {
				numberOfCombination = temp;
			}
		}else if(min == numberOfKnowledge) {
			numberOfCombination = numberOfParty - (numberOfParty%min);
			temp = numberOfMuscle - (numberOfMuscle%min);
			if(temp < numberOfCombination) {
				numberOfCombination = temp;
			}
		}
		
		//Computing the points according to the formulas given in the original game rules
		points = (numberOfKnowledge * numberOfKnowledge) + (numberOfMuscle * numberOfMuscle) + (numberOfParty * numberOfParty) + (7*numberOfCombination);
		return points;
	}

	/**
	 * Method called at the end of the game to find the winner or the winners
	 */
	public void endGame() {
		ArrayList<Score> scores = new ArrayList<Score>(); //List to store the player's score
		//List for all type of cards
		ArrayList<ScienceCard> scCard= new ArrayList<ScienceCard>();
		ArrayList<TradeCard> tCard = new ArrayList<TradeCard>();
		ArrayList<GuildCard> gCard = new ArrayList<GuildCard>();
		
		//We compute the score for each player
		for(Player p : players) {
			Score score = new Score(p); //Creating a new score for the given player
			
			//We loop through the player buildings
			for(Card c : p.getBuildings()) {
				if(c instanceof CivilCard) {
					p.addECTS(((CivilCard) c).getECTS()); //If it's a civil card we just get the ECTS on it, else we add the card in the list that correspond to it type
				}else if(c instanceof ScienceCard) {
					scCard.add(((ScienceCard) c));
				}else if(c instanceof TradeCard) {
					tCard.add(((TradeCard) c));
				}else if(c instanceof GuildCard) {
					gCard.add(((GuildCard) c));
				}
			}
			
			//For each tradeCard we get the card bonus if their is one
			for(TradeCard tc : tCard) {
				if(tc.getBonus() != null) {
					tc.getBonus().giveBonus(p,true);
				}
			}
			
			//For each guild card we get the guild bonus
			for(GuildCard gc : gCard) {
				if(!gc.getName().equalsIgnoreCase("Guild_troll")) {
					gc.getBonus().giveBonus(p, true);
				}
			}
			
			score.addScore(this.getScientificCombination(scCard, p)); //Adding to the score the number of points made with scientific symbols
			score.addScore(p.getGrade()); //Adding to the score the Grade numbers (in the original game, it's the number of battle points)
			score.addScore((p.getIzlyMoney() - (p.getIzlyMoney() % 3))/3); //Adding to the score a point for each groups of 3 izlyMoney
			score.addScore(p.getECTS()); //Adding to the score the number of ECTS
			scores.add(score); //Adding the score to the scores list
		}		
		scores.sort(null);//Sorting the list with the compareTo() method defined in the Score class
		
		//Checking if their is equality between some players. We take the last element in the list 'cause it's the higher score
		ArrayList<Player> equality = new ArrayList<Player>();
		for(int i = scores.size() - 2; i >= 0; i--) {
			if(scores.get(i) == scores.get(scores.size() - 1)) {
				equality.add(scores.get(i).getPlayer());
			}
		}
		
		//If their is an equality, we check the treasure of the players with the same to see if on win. In the other case we announce the equality
		Player winner = null;
		for(int j = 0; j < equality.size(); j++) {
			if(j != equality.size() - 1) {
				if(equality.get(j).getIzlyMoney() > equality.get(j+1).getIzlyMoney()) {
					winner = equality.get(j);
				}else if(equality.get(j).getIzlyMoney() < equality.get(j+1).getIzlyMoney()) {
					winner = equality.get(j+1);
				}
			}else {
				if(equality.get(0).getIzlyMoney() > equality.get(equality.size() - 1).getIzlyMoney()) {
					winner = equality.get(0);
				}else if(equality.get(0).getIzlyMoney() < equality.get(equality.size() - 1).getIzlyMoney()) {
					winner = equality.get(equality.size() - 1);
				}
			}
		}
		
		//Saving the winner(s)
		if(winner != null) {
			winners.add(winner);
		}else {
			for(Player p : equality) {
				winners.add(p);
			}
		}
	}
	
	/**
	 * Method called to build a card
	 * @param p Player who wants to build
	 * @return Formated information for the client
	 */
	public String build(Player p) {
		Card choosen = p.getChoosenCard(); //We get the card the player has chosen
		HashMap<Ressource, Integer> constructCostRessource = choosen.getConstructCostRessource(); //Getting the cost of the card
		HashMap<Ressource, Integer> playerRes = p.getPlayerRes(false); //Getting the player resources
		HashMap<Ressource, Integer> missing = new HashMap<Ressource, Integer>(); //HashMap to store the missing resources
		
		//If their is effectively a chosen card
		if(choosen != null) {
			//Checking if the player hasn't build this card yet
			if(!p.getBuildings().contains(choosen)) {
				//If the card is chained
				if(choosen.getPreviousBuilding() != null) {
					//If the player has built the needed building
					if(p.getBuildings().contains(choosen.getPreviousBuilding())) {
						p.addBuilding(choosen); //Adding the card to the building list
						//Checking if their is some bonus to apply
						if(choosen instanceof TradeCard) {
							((TradeCard) choosen).getBonus().giveBonus(p, false);
						}
						p.clearChoosenCard(); //clear the chosen card slot
						return "CARD_BUILT"; //Informing the client that the build is successful
					}
				//Else if the card has a resource construct cost
				}else if(!choosen.getConstructCostRessource().isEmpty()) {
					//We iterate through the HashMap to see if their is some missing resources
					Iterator<Entry<Ressource, Integer>> it = constructCostRessource.entrySet().iterator();
				    while (it.hasNext()) {	
						Map.Entry<Ressource, Integer> ressource = (Map.Entry<Ressource, Integer>)it.next();
					   	if(playerRes.containsKey(ressource.getKey())) {
					   		if(playerRes.get(ressource.getKey()) < ressource.getValue()) {
					    		missing.put(ressource.getKey(), ressource.getValue()- playerRes.get(ressource.getKey()));	
					    	}
					   	}
					   	it.remove(); // avoids a ConcurrentModificationException
				    }
				    
				    //If no resources are missing, we build the card
				    if(!missing.isEmpty()) {
				    	p.addBuilding(choosen);
				    	//Checking if their is some bonus to apply
						if(choosen instanceof TradeCard) {
							((TradeCard) choosen).getBonus().giveBonus(p, false);
						}
				    	p.clearChoosenCard();
				    	return "CARD_BUILT";
				    //But if some resources are missing we send to the client all the resources missing to update the trade menu
				    }else if(missing.isEmpty()){
				    	String toReturn = "RESSOURCE_ARE_MISSING:";
				    	Iterator<Entry<Ressource, Integer>> it1 = missing.entrySet().iterator();
					    while (it1.hasNext()) {	
							Map.Entry<Ressource, Integer> ressource = (Map.Entry<Ressource, Integer>)it.next();
							if(it1.hasNext()) {
								toReturn += "{" + ressource.getValue() + "x" + ressource.getKey().getName() + "},";
							}else {
								toReturn += "{" + ressource.getValue() + "x" + ressource.getKey().getName() + "}";
							}
						   	it1.remove(); // avoids a ConcurrentModificationException
					    }
					    return toReturn;
				    }
				 //Else if the card got a izly money cost
				}else if(!choosen.isCardFree()) {
					//If the player has enough money, we build the card and we substract the price to the player izly money
					if(p.getIzlyMoney() == choosen.getConstructCostIM()) {
						p.addBuilding(choosen);
						p.removeIzlyMoney(choosen.getConstructCostIM());
						//Checking if their is some bonus to apply
						if(choosen instanceof TradeCard) {
							((TradeCard) choosen).getBonus().giveBonus(p, false);
						}
						p.clearChoosenCard();
						return "CARD_BUILT";
					}else {
						return "NOT_ENOUGH_MONEY"; //Informing the client with the right error code
					}
				//Else if the card is totally free, we build it directly
				}else if(choosen.isCardFree()) {
					p.addBuilding(choosen);
					//Checking if their is some bonus to apply
					if(choosen instanceof TradeCard) {
						((TradeCard) choosen).getBonus().giveBonus(p, false);
					}
					p.clearChoosenCard(); 
					return "CARD_BUILT";
				}else {
					return "IMPOSSIBLE_TO_BUILD"; //If all the previous condition aren't satisfied we inform the player he can't build this card
				}
			}else {
				return "ALREADY_BUILT"; //Informing the client the card is already built
			}
		}
		return "";
	}

	/**
	 * Method used to pick a card
	 * @param p The player that pick the card
	 * @param c The card to pick
	 */
	public void pickCard(Player p, Card c) {
		p.setChoosenCard(c); //Setting the chosen card
		p.getHand().removeCard(c); //Remove the card from the player hand
	}

	/**
	 * Method called to build a wonder step
	 * @param p
	 * @return Formated information for the client
	 */
	public String buildStep(Player p) {
		Card choosen = p.getChoosenCard(); //Get the chosen card
		int step = p.getWonder().getCurrentStep(); //Get the step to build
		HashMap<Ressource, Integer> constructionCost = p.getWonder().getStepConstructCost(step); //Get construct cost for the corresponding step
		HashMap<Ressource, Integer> playerRes = p.getPlayerRes(false); //Get the player resources
		HashMap<Ressource, Integer> missing = new HashMap<Ressource, Integer>(); //HashMap to store the missing resources
		
		//If their is effectively a chosen card
		if(choosen != null) {
			//We iterate through the HashMap to see if their is some missing resources
			Iterator<Entry<Ressource, Integer>> it = constructionCost.entrySet().iterator();
		    while (it.hasNext()) {	
				Map.Entry<Ressource, Integer> ressource = (Map.Entry<Ressource, Integer>)it.next();
			   	if(playerRes.containsKey(ressource.getKey())) {
			   		if(playerRes.get(ressource.getKey()) < ressource.getValue()) {
			    		missing.put(ressource.getKey(), ressource.getValue()- playerRes.get(ressource.getKey()));	
			    	}
			   	}
			   	it.remove(); // avoids a ConcurrentModificationException
		    }
		    
		    //If any resources are missing
		    if(!missing.isEmpty()) {
		    	boolean success = p.getWonder().buildStep(step); //We store the result of the step building operation
		    	//If it's a success we give the player the bonus : some ECTS or izlyMoney
		    	if(success) {
		    		if(p.getWonder().getCurrentStep() == 2) {
		    			if(p.getWonder().getName().equalsIgnoreCase("Desire")){
		    				p.addECTS(p.getWonder().getECTS(step));
		    			}else if(p.getWonder().getName().equalsIgnoreCase("Sulee")){
		    				p.addIzlyMoney(9);
		    			}
		    		}else {
		    			p.addECTS(p.getWonder().getECTS(step));
		    		}
		    		return "STEP_SUCCESSFULLY_BUILT";
		    	}else {
		    		return "WONDER_FINISHED"; 
		    	}
		    	//If resources are missing, returning missing resources to the client
		    }else if(missing.isEmpty()){
		    	String toReturn = "RESSOURCE_ARE_MISSING:";
		    	Iterator<Entry<Ressource, Integer>> it1 = missing.entrySet().iterator();
			    while (it1.hasNext()) {	
					Map.Entry<Ressource, Integer> ressource = (Map.Entry<Ressource, Integer>)it.next();
					if(it1.hasNext()) {
						toReturn += "{" + ressource.getValue() + "x" + ressource.getKey().getName() + "},";
					}else {
						toReturn += "{" + ressource.getValue() + "x" + ressource.getKey().getName() + "}";
					}
				   	it1.remove(); // avoids a ConcurrentModificationException
			    }
			    return toReturn;
		    }
		}
		return "";
	}

	/**
	 * Method used to discard the card the player has chosen
	 * @param p Actual player
	 * @return Formated response for the client
	 */
	public String discard(Player p) {
		//Checking that a card is actually selected
		if(p.getChoosenCard() != null) {
			this.discard.addCard(p.getChoosenCard()); //Discard the card
			p.clearChoosenCard(); //Remove the chosen card
			p.addIzlyMoney(3); //Add 3 izlyMoney to the player's treasure
			return "CARD_DISCARDED"; //Informing the client that the card is discarded correctly
		}else {
			return "NO_CARD"; //Informing the client of the problem with the right error code
		}
	}

}
