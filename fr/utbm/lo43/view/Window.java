package fr.utbm.lo43.view;
import fr.utbm.lo43.view.WonderView;
import fr.utbm.lo43.view.Board;
import fr.utbm.lo43.view.GameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Class that represent the main Window at that use JFrame and display the Board
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */


public class Window extends JFrame{

	private JButton settingsBtn;
	private JButton returnBtn;
	private JButton leaveBtn;
	private WonderView wonderView;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private CardLayout card = new CardLayout();
	private GameMenu gameMenu;
	private JPanel btnPane = new JPanel();
	private JPanel gameBoardPane = new JPanel(new BorderLayout());
	private Board board = new Board();
	private GridBagConstraints settingsBtns = new GridBagConstraints();
	private JPanel settingsPane = new JPanel(new GridBagLayout());
	private JPanel cardPane = new JPanel();
	private JPanel bottomPane = new JPanel(new FlowLayout(FlowLayout.LEFT));

	/**
	 * Default constructor
	 */

	public Window() throws IOException {

		gameMenu = new GameMenu(this);
		this.setTitle("7 Wonders");
		this.setSize(screenWidth,screenHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		//Adding settings button
		settingsBtn = new JButton("Settings");
		settingsBtn.setPreferredSize(new Dimension(100, 100));
		settingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextPane();
			}
		});
		btnPane.add(settingsBtn);
		btnPane.setBounds(10,10,110,110);

		//Adding return button to the settings Pane
		returnBtn = new JButton("Back to game");
		returnBtn.setPreferredSize(new Dimension(200, 100));
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextPane();
			}
		});
		settingsBtns.gridx = 1;
		settingsBtns.gridy = 0;
		settingsPane.add(returnBtn,settingsBtns);

		//Adding leave Button to the settings Pane
		leaveBtn = new JButton("Leave game");
		leaveBtn.setPreferredSize(new Dimension(200, 100));
		leaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		settingsBtns.gridx = 1;
		settingsBtns.gridy = 1;
		settingsPane.add(leaveBtn,settingsBtns);

		gameBoardPane.add(btnPane);
		gameBoardPane.add(board,BorderLayout.CENTER);
		gameBoardPane.add(bottomPane,BorderLayout.SOUTH);

		//Creating all the Panes
		cardPane.setLayout(card);
		cardPane.add(gameMenu,"Game Menu");
		cardPane.add(gameBoardPane, "Game Pane");
		cardPane.add(settingsPane, "Settings Pane");

		this.add(cardPane);

		this.setVisible(true);
	}

	/**
	 * Going to the next Pane of the Window
	 */

	public void nextPane(){
		card.next(cardPane);
	}
}
