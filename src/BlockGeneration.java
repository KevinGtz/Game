import java.util.Random;

public class BlockGeneration {
	
	int x[];
	int y[];
	int length[];
	int width[];
	
	public void start(){
		x = new int[10];
		y = new int[10];
		length = new int[10];
		width = new int[10];
		
		Random r = new Random();
		for(int i = 0; i < x.length; i++){
			int roll = r.nextInt(100) + 1;
			x[i] = roll;
		}
		for(int i = 0; i < y.length; i++){
			int die = r.nextInt(100) + 1;
			y[i] = die;
		}
		for(int i = 0; i < length.length; i++){
			int die = r.nextInt(100) + 1;
			length[i] = die;
		}
		for(int i = 0; i < width.length; i++){
			int die = r.nextInt(100) + 1;
			width[i] = die;
		}
	}
	public int getX(int xpos){
		return x[xpos];
	}
	public int getY(int ypos){
		return y[ypos];
	}
	public int getLength(int lengthpos){
		return length[lengthpos];
	}
	public int getWidth(int widthpos){
		return width[widthpos];
	}
}
