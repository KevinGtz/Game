import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Canvas extends JPanel implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private boolean running;
	
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 720;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	
	private Character character;
	private Background background;
	private Enemy enemy;
	
	public Canvas(){
		character = new Character();
		background = new Background();
		enemy = new Enemy();
		
		setPreferredSize(SIZE);
		setFocusable(true);
		
		setDoubleBuffered(true);
		addKeyListener(this);
		
		thread = new Thread(this);
	}
	
	public void start() {
		running = true;
		thread.start();
	}
	
	public void stop() {
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		background.update();
		character.update();
		enemy.update();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.render(g);
		character.render(g);
		
	}
	
	@Override
	public void run() {
		while(running){
			update();
			repaint();
			
			try {
				Thread.sleep(17);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_D:
			character.moveRight();
			break;
		case KeyEvent.VK_A:
			character.moveLeft();
			break;
		case KeyEvent.VK_W:
			character.jump();
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A || key == KeyEvent.VK_D){
			character.stop();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
