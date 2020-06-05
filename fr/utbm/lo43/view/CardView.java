package fr.utbm.lo43.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class that represent the View of a Card at that use JPanel
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class CardView extends JPanel{

	private String color;
	private String nom;

	/**
	 * Constructor with parameter
	 * @param str the name of the Card to display the right image (here only for the back of the card)
	 */

	public CardView(String str) throws IOException{
		BufferedImage cardImage = ImageIO.read(new File("images/Carte"+str+".jpg"));
		JLabel Image = new JLabel(new ImageIcon(cardImage));
		this.add(Image);
	}

	/**
	 * Constructor with parameter
	 * @param color the color of the card to display
	 * @param nom the name of the card to display
	 */

	public CardView(String color,String nom) throws IOException {
		this.color = color;
		this.nom = nom;
		BufferedImage cardImage = ImageIO.read(new File("images/Age1/carte"+color+"_"+nom+".jpg"));
		JLabel Image = new JLabel(new ImageIcon(cardImage));
		this.add(Image);
	}

	/*public void updateCard() throws IOException {
		BufferedImage cardImage = ImageIO.read(new File("images/CarteDos.jpg"));
		JLabel Image = new JLabel(new ImageIcon(cardImage));
		this.add(Image);
	}*/

	/**
	 * Getting the color
	 * @return the Color of the card
	 */

	public String getColor(){
		return this.color;
	}

	/**
	 * Getting the Name
	 * @return the Name of the player
	 */

	public String getNom(){
		return this.nom;
	}

}
