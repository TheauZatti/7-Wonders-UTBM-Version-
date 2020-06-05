package fr.utbm.lo43.view;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import fr.utbm.lo43.view.WonderView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that represent the Board of the other players at that use JFrame
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */

public class BoardList extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = screenSize.width;
    private int screenHeight = screenSize.height;
    private WonderView wonder1 = new WonderView();
    private WonderView wonder2 = new WonderView();
    private WonderView wonder3 = new WonderView();
    private WonderView wonder4 = new WonderView();
    private WonderView wonder5 = new WonderView();
    private WonderView wonder6 = new WonderView();
    private ArrayList<WonderView> wonders = new ArrayList<WonderView>();
    private JFrame test = new JFrame();


    /**
     * Constructor with parameter
     * @param row the number of row to display
     * @param col the number of col to display
     */

    public BoardList(int row,int col) throws IOException {
        this.setTitle("Board View");
        this.setLayout(null);
        this.setSize(screenWidth,screenHeight);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wonders.add(wonder1);
        wonders.add(wonder2);
        wonders.add(wonder3);
        wonders.add(wonder4);
        wonders.add(wonder5);
        wonders.add(wonder6);

        boardListDraw(row,col);
        this.setVisible(true);
    }

    /**
     * Drawing the board of the other players and add all the listener
     */

    public void boardListDraw(int row,int col) throws IOException {
        int i =0;
        int j = 0;
        //For each wonder, draw them and add listener for hover event
        for (WonderView wonder : wonders){
            wonder.setBounds(50+((screenWidth-150)/2)*j+50*j,10+((screenHeight-40)/3)*i+10*i,(screenWidth-150)/2,(screenHeight-40)/3);
            wonder.addMouseListener(new MouseAdapter() {
                @Override
                //On mouse hover, add JFrame with the cards of the player
                public void mouseEntered(MouseEvent e) {
                    wonder.setBackground(Color.red);
                    test.setBounds(e.getX()+100,e.getY()+100,900,500);
                    test.setBackground(Color.yellow);
                    test.setVisible(true);
                }

                @Override
                //On mouse leave, close the JFrame
                public void mouseExited(MouseEvent e) {
                    wonder.setBackground(Color.blue);
                    test.dispose();
                }
            });
            this.add(wonder);
            if (j<col-1){
                j++;
            }else{
                j=0;
                i++;
            }
        }
    }
}
