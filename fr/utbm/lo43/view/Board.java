package fr.utbm.lo43.view;

import fr.utbm.lo43.view.BoardList;
import fr.utbm.lo43.view.CardDeckView;
import fr.utbm.lo43.view.CardView;
import fr.utbm.lo43.view.WonderView;
import fr.utbm.lo43.view.TradeMenu;
import fr.utbm.lo43.model.ClientConnexion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class that represent the main Board at that use JPanel
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class Board extends JPanel{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private CardDeckView hand;
	private CardView discard;
	private WonderView wonder;
	private BufferedImage moneyPic;
	private JLabel title;
	private JLabel moneyImage;
	private JLabel moneyAmount;
	private JButton trade;
	private JButton boardView;
	private JButton reafy;

	/**
	 * Default constructor
	 */

	public Board() throws IOException {

		this.setLayout(null);
		//Adding the main component to the board
		hand = new CardDeckView(this);
		discard = new CardView("Dos");
		wonder = new WonderView(this);

		//Adding trade button
		trade = new JButton("Trade");
		trade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TradeMenu();
            }
        });

		//Adding reafy button
		reafy = new JButton("Reafy");
		reafy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		//Adding other boards view
		boardView = new JButton("Board");
		boardView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new BoardList(3,2);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		moneyPic = ImageIO.read(new File("images/izlyMoney.png"));
		moneyImage = new JLabel(new ImageIcon(moneyPic));
		moneyAmount = new JLabel("10");
		moneyAmount.setFont(new Font("Sherif", Font.BOLD, 22));
		moneyAmount.setOpaque(true);
		title = new JLabel("Tronc Commun");
		title.setFont(new Font("Sherif", Font.BOLD, 22));
		boardPaint();
	}

	/**
	 * Getting the wonder
	 * @return the WonderView used on the Board
	 */

	public WonderView getWonder(){
		return this.wonder;
	}

	/**
	 * Painting the Wonder with the steps
	 */

	public void boardPaint(){
	    this.wonder.wonderPaint();
	    title.setBounds((screenWidth-200)/2,10,200,100);
        moneyImage.setBounds(screenWidth-400,100,100,100);
        moneyAmount.setBounds(screenWidth-300,100,100,100);
        discard.setBounds((screenWidth-300)/2,150,300,200);
        trade.setBounds(screenWidth-100,screenHeight-250,80,200);
		reafy.setBounds(screenWidth-200,100,80,100);
		boardView.setBounds(screenWidth-180,screenHeight-250,80,200);
        this.add(title);
        this.add(trade);
		this.add(reafy);
        this.add(boardView);
        this.add(moneyImage);
        this.add(moneyAmount);
        this.add(discard);
    }
}
