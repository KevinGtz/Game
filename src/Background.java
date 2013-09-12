import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Background {

	private int x;
	private int y;
	
	private int dx;
	
	private static final String PATH = "res/background.png";
	private File file = new File(PATH);
	
	private BufferedImage background;
	
	public Background() {
		try {
			background = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		x += dx;
	}
	
	public void render(Graphics g) {
		g.drawImage(background, x, y, null);
	}
}
