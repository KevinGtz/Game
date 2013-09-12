import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	
	public static BufferedImage enemy;
	
	private static final String PATH = "res/enemy1.png";
	private File file = new File(PATH);
	
	private int timer;
	
	public enum STATES {RIGHT, LEFT};
	public STATES currentState = STATES.RIGHT;
	
	public static int x; 
	public static int y;
	
	public Enemy() {
		x = 200;
		y = Canvas.SIZE.height - 100;
		
		try {
			enemy = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(currentState == STATES.RIGHT){
			try {
				enemy = ImageIO.read(file);
				timer++;
				if(timer == 300) {
					currentState = STATES.LEFT;
					timer = 0;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(currentState == STATES.LEFT) {
			try {
				enemy = ImageIO.read(new File("res/enemyleft.png"));
				timer++;
				if(timer == 300){
					currentState = STATES.RIGHT;
					timer = 0;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
