package fr.utbm.lo43.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that represent the Menu of the game at that use JPanel
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class GameMenu extends JPanel {

    private JLabel welcome;
    private JLabel setIP;
    private JTextField IP;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private JButton startBtn;
    private JButton exitBtn;
    private Window window;

    /**
     * Constructor with parameter
     * @param w the window where to add the Menu
     */

    public GameMenu(Window w) {

        this.window = w;
        this.setLayout(null);
        welcome = new JLabel("Welcome to our 7 Wonders Game !");
        welcome.setBounds((screenWidth-500)/2,100,500,100);
        welcome.setFont(new Font("Sherif", Font.BOLD, 30));
        this.add(welcome);

        setIP = new JLabel("Please set the IP of the server :");
        setIP.setBounds((screenWidth-400)/2-200,400,400,100);
        setIP.setFont(new Font("Sherif", Font.BOLD, 20));
        this.add(setIP);

        IP = new JTextField("172.16.254.1");
        IP.setBounds((screenWidth-400)/2+120,425,300,50);
        this.add(IP);

        startBtn = new JButton("Start the game");
        startBtn.setBounds((screenWidth-150)/2-75,screenHeight-200,150,100);
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                window.nextPane();
            }
        });
        this.add(startBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds((screenWidth-150)/2+75,screenHeight-200,150,100);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        this.add(exitBtn);
    }
}