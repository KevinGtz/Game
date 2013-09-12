import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character {
	
	public int x; 
	public int y;
	
	public int dx; 
	public float dy;
	
	private static final String PATH = "res/random.png";
	private File file = new File(PATH);
	
	private BufferedImage character;

	private boolean jumped;
	
	public enum STATES {RIGHT, LEFT};
	public STATES currentState;
	
	private boolean walking;
	
	public boolean left;
	public boolean right = true;
	
	public Character() {
		x = 50;
		y = Canvas.HEIGHT - 100;
		
		currentState = STATES.RIGHT;
		
		try {
			character = ImageIO.read(file);
		} catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public void update(){	
		int groundLevel = Canvas.HEIGHT - 100;
		
		if(y + dy >= groundLevel) {
			y = groundLevel;
		} else {
			y += dy;
		}
		
		if(jumped) {
			dy += 1;
			
			if(y + dy >= groundLevel) {
				y = groundLevel;
				dy = 0;
				jumped = false;
			}
		}

		x += dx;
	}
	
	public void jump() {
		if(!jumped) {
			dy = -15;
			jumped = true;
		}
	}
	
	public void moveRight() {
		walking = true;
		dx = 6;
		currentState = STATES.RIGHT;
	}
	
	public void moveLeft() {
		walking = true;
		dx = -6;
		currentState = STATES.LEFT;
	}
	
	public void stop() {
		dx = 0;
		walking = false;
	}
	
	public void animate() {
		if(walking) {
			if(currentState == STATES.LEFT){
				try {
					character = ImageIO.read(new File("res/randomleft2.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if(currentState == STATES.RIGHT) {
				try {
					character = ImageIO.read(new File("res/random2.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			if(currentState == STATES.LEFT){
				try{
					character = ImageIO.read(new File("res/randomleft.png"));
				} catch(Exception e){
					e.printStackTrace();
				}
			} else if(currentState == STATES.RIGHT) {
				try {
					character = ImageIO.read(new File("res/random.png"));
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void render(Graphics g){
		animate();
		g.drawImage(character, x, y, null);
		g.drawImage(Enemy.enemy, 400, Canvas.HEIGHT - 100, null);
		
		g.setColor(Color.BLACK);
		
		g.drawString(String.valueOf(y), 50, 50);
		g.drawString(String.valueOf(x), 80, 50);
		
		g.drawString(String.valueOf(Enemy.x), 150, 50);
		g.drawString(String.valueOf(Enemy.y), 175, 50);
		
		g.dispose();
	}
}
