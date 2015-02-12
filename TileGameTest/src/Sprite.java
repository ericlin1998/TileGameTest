import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Sprite {
	private int dx;
	private int dy;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visible;
	private Image image;
	
	public Sprite(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("craft.png"));
		image = ii.getImage();
		width = ii.getIconWidth();
		height = ii.getIconHeight();
		visible = true;
		x = 40;
		y = 60;
	}
	
	public void move(){
		x += dx;
		y += dy;
		
		/*
		if(x < 1){
			x = 1;
		}
		if(y < 1){
			y = 1;
		}
		*/
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			x = -1;
		}
		if(key == KeyEvent.VK_RIGHT){
			x = 1;
		}
		if(key == KeyEvent.VK_UP){
			y = -1;
		}
		if(key == KeyEvent.VK_DOWN){
			y = 1;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
	}
	
	
}
