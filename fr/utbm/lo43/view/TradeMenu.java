package fr.utbm.lo43.view;

import fr.utbm.lo43.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Class that represent the Trade Menu between 2 players at that use JFrame
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class TradeMenu extends JFrame {

    private JButton submit;
    private JButton leave;
    private HashMap<String, Integer> test = new HashMap<String,Integer>();
    private JLabel totalCost;
    private JTextField totalValue;

    /**
     * Default constructor
     */

    public TradeMenu(){
        this.setTitle("Trading Menu");
        this.setLayout(null);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        test.put("test",2);
        test.put("autre",2);

        //Adding submit and leave button to the trade menu
        submit = new JButton("Submit");
        submit.setBounds(325,600,100,50);
        leave = new JButton("Leave");
        leave.setBounds(475,600,100,50);

        leave.addActionListener(new ActionListener() {
            @Override
            //Adding click listener to leave button
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        paintTrade(0);
        paintTrade(1);


        totalCost = new JLabel("Total cost :");
        totalCost.setFont(new Font("Sherif", Font.BOLD, 20));
        totalValue = new JTextField("0");
        totalValue.setEnabled(false);
        totalValue.setFont(new Font("Sherif", Font.BOLD, 20));
        totalCost.setBounds(350,500,200,50);
        totalValue.setBounds(475,500,100,50);
        this.add(totalCost);
        this.add(totalValue);

        this.add(submit);
        this.add(leave);
    }

    /**
     * Painting the Trade Menu frame
     * @param i id of the player to trade with
     */

    public void paintTrade(int i) {
        JLabel player = new JLabel("Player "+(i+1));
        player.setFont(new Font("Sherif", Font.BOLD, 20));
        player.setBounds(250+400*i,50,100,100);
        this.add(player);

        //Creating the buttons and text field for the ressources
        if (test.containsKey("test")){
            JLabel Ressource1 = new JLabel("Ressource 1 Image");
            Ressource1.setBounds(100 + 400*i,(600/test.size()-40),200,40);

            JTextField Ressource1Val = new JTextField("0");
            Ressource1Val.setBounds(300+ 400*i,(600/test.size()-30),30,30);

            JButton minusRes1 = new JButton("-");
            minusRes1.setBounds(250+ 400*i,(600/test.size()-30),45,30);
            minusRes1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int value = Integer.parseInt(Ressource1Val.getText());
                    int total = Integer.parseInt(totalValue.getText());
                    if (value > 0){
                        Ressource1Val.setText(""+(value-1));
                        totalValue.setText(""+(total-1));
                    }
                }
            });

            JButton plusRes1 = new JButton("+");
            plusRes1.setBounds(335+ 400*i,(600/test.size()-30),45,30);
            plusRes1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int total = Integer.parseInt(totalValue.getText());
                    int value = Integer.parseInt(Ressource1Val.getText());
                    Ressource1Val.setText(""+(value+1));
                    totalValue.setText(""+(total+1));
                }
            });

            this.add(Ressource1);
            this.add(minusRes1);
            this.add(plusRes1);
            this.add(Ressource1Val);
        }
        if (test.containsKey("autre")){
            JLabel Ressource2 = new JLabel("Ressource 2 Image");
            Ressource2.setBounds(100+ 400*i,(600/test.size()+40),200,40);

            JTextField Ressource2Val = new JTextField("0");
            Ressource2Val.setBounds(300+ 400*i,(600/test.size()+40),30,30);

            JButton minusRes2 = new JButton("-");
            minusRes2.setBounds(250+ 400*i,(600/test.size()+40),45,30);
            minusRes2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int total = Integer.parseInt(totalValue.getText());
                    int value = Integer.parseInt(Ressource2Val.getText());
                    if (value > 0){
                        Ressource2Val.setText(""+(value-1));
                        totalValue.setText(""+(total-1));
                    }
                }
            });

            JButton plusRes2 = new JButton("+");
            plusRes2.setBounds(335+ 400*i,(600/test.size()+40),45,30);
            plusRes2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int total = Integer.parseInt(totalValue.getText());
                    int value = Integer.parseInt(Ressource2Val.getText());
                    Ressource2Val.setText(""+(value+1));
                    totalValue.setText(""+(total+1));
                }
            });

            this.add(Ressource2);
            this.add(minusRes2);
            this.add(plusRes2);
            this.add(Ressource2Val);
        }
    }

}
