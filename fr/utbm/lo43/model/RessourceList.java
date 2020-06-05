package fr.utbm.lo43.model;

/**RessourceList is an enum that list all the existing resources in the 7 Wonders game
 * @author Francesco
 */
public enum RessourceList {

	NOURRITURE(new Ressource("nourriture", "primitive")),
	BOISSON(new Ressource("boisson", "primitive")),
	SOMMEIL(new Ressource("sommeil", "primitive")),
	STYLOS(new Ressource("stylos", "primitive")),
	JEUX(new Ressource("jeux", "manufactured")),
	AMOUR(new Ressource("amour", "manufactured")),
	DIVERTISSEMENT(new Ressource("divertissement", "manufactured"));
	
	private Ressource res;
	
	/**
	 * Constructor of an element of this enum
	 * @param res The resource that will be encapsulated in the enum element
	 */
	RessourceList(Ressource res){
		this.res = res;
	}
	
	public String toString() {
		return null;
	}
	
	/**
	 * Getting the resource encapsulated in the element
	 * @return the resource encapsulated in the element
	 */
	public Ressource getRes() {
		return this.res;
	}
	
	/**
	 * Method that take a card name and return the corresponding card by running a search in all elements of the enum
	 * @param name The name of the card searched
	 * @return The corresponding card object
	 */
	public static Ressource findByName(String name) {
		RessourceList[] listOfRe = RessourceList.values();
		
		for(int i=0;i < listOfRe.length - 1;i++) {
			if(listOfRe[i].getRes().getName().equalsIgnoreCase(name)) {
				return listOfRe[i].getRes();
			}
		}
		
		return null;
	}
	
}
