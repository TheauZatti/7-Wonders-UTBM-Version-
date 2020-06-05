package fr.utbm.lo43.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that represent a card deck in the game
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class CardDeck {

	private ArrayList<Card> cards;
	
	/**
	 * Constructor
	 */
	CardDeck(){
		this.cards = new ArrayList<Card>();
	}
	
	/**
	 * Method that assemble the card decks for each ages according to the number of players
	 * @param nbrOfPlayers Number of players in the game
	 * @param age Age of the deck
	 * @return A Deck for the given age with the good card in it 
	 */
	public CardDeck createDeck(int nbrOfPlayers, int age){
		CardDeck deck = new CardDeck();
		CardDeck guild = new CardDeck();
		int nbrOfGuildCard = 9 - (7-nbrOfPlayers); //Amount of guild card to select randomly in the guildcard list, formula get from the rules of the game
		CardList[] listOfCards = CardList.values(); //Getting all the cards
		
		//Iterate through all the cards
		for(int i=0;i<listOfCards.length - 1;i++) {
			//If the actual card is from the age given in parameter
			if(listOfCards[i].getCard().getAge() == age) {
				/*If it's not a guild card, we get the apparition frequency of the card and we compare it to the number of players
				If it's lower than the number of players we add the card to the deck*/
				if(!(listOfCards[i].getCard() instanceof GuildCard)) {
					for(int nb : listOfCards[i].getCard().getNbrOfPlayerForUse()) {
						if(nb <= nbrOfPlayers) {
							deck.addCard(listOfCards[i].getCard());
						}
					}
				}else {
					guild.addCard(listOfCards[i].getCard()); //We add the guild cards in an other card deck
				}
			}
		}
		
		//If the age is the age 3 we add the required number of guild card in the deck in a random way
		if(!guild.isEmpty()) {
			for(int j = 1; j <= nbrOfGuildCard;j++) {
				guild.shuffle(); //We shuffle the deck
				deck.addCard(guild.getCards().get(0));
			}
		}
				
		return deck; 
	}
	
	/**
	 * Getting the list of cards in the deck
	 * @return All the cards of the deck
	 */
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	/**
	 * Removing a card from the card list
	 * @param card Card to remove
	 */
	public void removeCard(Card card) {
		this.cards.remove(card);
	}

	/**
	 * Adding a card to the card list
	 * @param card Card to add
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 * Checking if the deck is empty
	 * @return true if it is, false otherwise
	 */
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
	
	/**
	 *Method to shuffle the deck 
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}
