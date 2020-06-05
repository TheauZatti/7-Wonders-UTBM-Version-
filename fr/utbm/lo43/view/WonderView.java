package fr.utbm.lo43.view;

import fr.utbm.lo43.view.Board;
import fr.utbm.lo43.view.CardView;

import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;

/**
 * Class that represent the View of the Wonder at that use JPanel
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class WonderView extends JPanel{

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = screenSize.height;
	private Board board;
	private CardView step1 = new CardView("Dos");
	private CardView step2 = new CardView("Dos");
	private CardView step3 = new CardView("Dos");

	/**
	 * Default constructor
	 */

	public WonderView() throws IOException{
		this.setSize(100,100);
		this.setBackground(Color.blue);
	}

	/**
	 * Constructor with parameter
	 * @param b the board where to add and draw the Wonder view
	 */

	public WonderView(Board b) throws IOException {
		step1.setVisible(false);
		step2.setVisible(false);
		step3.setVisible(false);
		this.board = b;
		wonderPaint();
		this.setBackground(Color.blue);
	}

	/**
	 * Updating the wonder's steps
	 * @param index the index of the step to update
	 */

	public void updateStep(int index) throws IOException{
		if (index == 1){
			step1.setVisible(true);
		}
		else if (index == 2){
			step1.setVisible(true);
		}
		else if (index == 3){
			step1.setVisible(true);
		}
	}

	/**
	 * Painting the Wonder view
	 */

	public void wonderPaint(){
		this.setBounds(0,(screenHeight-300),800,300);
		step1.setBounds(10,(screenHeight-100),250,120);
		step2.setBounds(270,(screenHeight-100),250,120);
		step3.setBounds(530,(screenHeight-100),250,120);
		this.board.add(step1);
		this.board.add(step2);
		this.board.add(step3);
		this.board.add(this);
	}


}
