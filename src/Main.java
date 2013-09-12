import javax.swing.JFrame;

public class Main {

	private JFrame frame;
	private Canvas canvas;
	
	private static final String TITLE = "2D Platformer";
	
	public Main() {
		frame = new JFrame();
		canvas = new Canvas();
		
		frame.setTitle(TITLE);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	public void start() {
		canvas.start();
	}
	
	public void stop() {
		canvas.stop();
	}
	
	public static void main(String [] args){
		Main main = new Main();
		main.start();
	}
}
