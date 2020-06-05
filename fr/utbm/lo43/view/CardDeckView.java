package fr.utbm.lo43.view;

import fr.utbm.lo43.view.CardView;
import fr.utbm.lo43.view.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that represent the View of a CardDeck at that use JPanel
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class CardDeckView extends JPanel {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private CardView card1 = new CardView("Bleue","UvInfoDeb");
    private CardView card2 = new CardView("Bleue","UVLangues");
    private CardView card3 = new CardView("Bleue","UVMathDeb");
    private CardView card4 = new CardView("Bleue","UvPhysique");
    private CardView card5 = new CardView("Grise","JeuxVideo");
    private CardView card6 = new CardView("Grise","RDV");
    private CardView card7 = new CardView("Grise","Series");
    private ArrayList<CardView> hand = new ArrayList<CardView>(Arrays.asList(card1,card2,card3,card4,card5,card6,card7));
    private Board board;
    private Point mousePoint = new Point(0,0);
    private Point cardInitial = new Point(0,0);
    private ArrayList<CardView> buildedCards = new ArrayList<>();

    /**
     * Constructor with parameter
     * @param b the board where to draw the Card Deck
     */

    public CardDeckView(Board b) throws IOException {

        this.board = b;

        changeDeck();
        drawCards();

        //For each cards in hand, add listener and paint them
        for (CardView cardview : hand) {
            cardview.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cardview.setLocation(cardview.getX(),370);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    cardview.setLocation(cardview.getX(),400);
                }

                @Override
                public void mousePressed(MouseEvent e){
                    cardInitial.setLocation(cardview.getX(),cardview.getY());
                    mousePoint.setLocation(e.getX(),e.getY());
                }

                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("Card selected");
                }

                @Override
                public void mouseReleased(MouseEvent e){

                    //If card drop in discard zone, remove it from hand
                    if (cardview.getX()+e.getX() > (screenWidth-300)/2 && cardview.getX()+e.getX() < ((screenWidth-300)/2)+300 && cardview.getY()+e.getY() > 200 && cardview.getY()+e.getY() < 400){
                        removeCard(cardview);
                        cardview.setVisible(false);
                        drawCards();
                        board.boardPaint();

                    //If card drop in wonder zone, update step and remove it from hand
                    }else if(cardview.getX()+e.getX() > 0 && cardview.getX()+e.getX() < 800 && cardview.getY()+e.getY() > screenHeight-300 && cardview.getY()+e.getY() < screenHeight){
                        removeCard(cardview);
                        try {
                            board.getWonder().updateStep(1);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        cardview.setVisible(false);
                        drawCards();
                        board.boardPaint();
                    }

                    //If card drop in build zone, draw it and remove it from hand
                    else if(cardview.getX()+e.getX() > 800 && cardview.getX()+e.getX() < screenWidth-179 && cardview.getY()+e.getY() > screenHeight-300 && cardview.getY()+e.getY() < screenHeight){
                        removeCard(cardview);
                        try{
                            drawSelectedCard(cardview);
                        }catch(IOException ex){
                            ex.printStackTrace();
                        }
                        cardview.setVisible(false);
                        drawCards();
                        board.boardPaint();
                    }else{
                        //else, put it back in hand
                        cardview.setLocation(cardInitial.x,cardInitial.y+30);
                    }
                }
            });

            cardview.addMouseMotionListener(new MouseMotionListener() {
                @Override
                //Drag and drop for the card
                public void mouseDragged(MouseEvent e) {
                    cardview.setLocation(cardview.getX()+e.getX()-mousePoint.x,cardview.getY()+e.getY()-mousePoint.y);
                }

                @Override
                public void mouseMoved(MouseEvent e) {

                }
            });
        }
    }

    /**
     * Removing the card from the deck
     * @param cv the CardView to remove
     */

    public void removeCard(CardView cv){
        this.hand.remove(cv);
    }

    /**
     * Drawing the card deck
     */

    public void drawCards(){
        int j = 0;
        for (CardView cardview : hand) {
            int x = (screenWidth - (hand.size()*10+hand.size()*200))/2;
            cardview.setBounds(x+j*10+j*200,400,200,300);
            this.board.add(cardview);
            j++;
        }
    }

    /**
     * Changing the card deck with the other player one
     */

    public void changeDeck(){
        for (CardView cardview : hand) {
            int x = (screenWidth - 200)/2;
            cardview.setBounds(x,200,200,300);
            this.board.add(cardview);
        }
    }

    public void drawSelectedCard(CardView cv) throws IOException{
        //Create new card to add in buildCard zone
        CardView newcard = new CardView(cv.getColor(), cv.getNom());
        buildedCards.add(newcard);
        int i = 1;
        for(CardView cardview : buildedCards){
            cardview.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cardview.setLocation(cardview.getX(),screenHeight-400);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    cardview.setLocation(cardview.getX(),screenHeight-330);
                }
            });
            cardview.setBounds(screenWidth-380-40*i,screenHeight-330,200,300);
            this.board.add(cardview);
            i++;
        }
    }

}
