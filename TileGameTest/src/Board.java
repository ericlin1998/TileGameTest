import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel implements ActionListener{
	private static final long serialVersionUID = 0;
		
	private Timer timer;
    private Sprite craft;
    private ArrayList aliens;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
		
	public Board(){
		 addKeyListener(new TAdapter());
	     setFocusable(true);
	     setBackground(Color.BLACK);
	     setDoubleBuffered(true);
	     ingame = true;
	        
	     setSize(400, 300);

	     craft = new Sprite();

	     //initAliens();
	     
	     timer = new Timer(5, this);
	     timer.start();
	}
	
	public void addNotify() {
		super.addNotify();
		B_WIDTH = getWidth();
		B_HEIGHT = getHeight();   
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)(g);
		g2.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
		
	}
	  
	private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		craft.move();
		repaint();
		
	}
}
