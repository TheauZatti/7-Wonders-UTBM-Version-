package fr.utbm.lo43.model;

/**
 * Class that represent a resource of 7 wonders
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class Ressource {

	private String name;
	private String type;

	/**
	 * Default constructor
	 */
	Ressource(){
		this.name = "";
		this.type = "";
	}
	
	/**
	 * Constructor with parameters
	 * @param name Name of the resource
	 * @param type Type of the resource
	 */
	Ressource(String name, String type){
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Getting the name of the resource
	 * @return The name of the resource
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getting the type of the resource
	 * @return true if the resource is primitive, false if it's manufactured
	 */
	public boolean isPrimitive() {
		boolean isPrimitive = false;
		if(type.equalsIgnoreCase("Primitive")){
			isPrimitive = true;
		}else if(type.equalsIgnoreCase("Manufactured")) {
			isPrimitive = false;
		}
		return isPrimitive;
	}

}
