import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	private boolean dL = false, dR = false, dU = false, dD = false;
	
	public Sprite(){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("craft.png"));
		} catch (IOException e) {
			System.out.println("nothing");
		}
		ImageIcon ii = new ImageIcon(img);
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
		
		if(x < 1){
			x = 1;
		}
		if(y < 1){
			y = 1;
		}
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
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				dx = -1;
			break;

			case KeyEvent.VK_RIGHT:
				dx = 1;
			break;

			case KeyEvent.VK_UP:
				dy = -1;
			break;

			case KeyEvent.VK_DOWN:
				dy = 1;
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				dx = 0;
            break;

			case KeyEvent.VK_RIGHT:
				dx = 0;
			break;

			case KeyEvent.VK_UP:
				dy = 0;
            break;

			case KeyEvent.VK_DOWN:
				dy = 0;
			break;
		}
	}
	
	
}
