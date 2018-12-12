import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class Mao{
	public int map[][];
	public int maoWidth;
	public int maoHeight;
	private Game game;

	public Mao(int row, int col, Game game) {
		this.game = game;
		map = new int[row][col];
		for(int i=0; i < map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				map[i][j]=1;
			}
		}
		

		maoWidth = 240/col;
		maoHeight = 60/row;
		
		for(int i =0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j]>0) {
					int brickX=j * maoWidth + 80;
					int brickY = i*maoHeight + 50;
					int brickWidth = maoWidth;
					int brickHeight = maoHeight;
					
					Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
					Rectangle brickRect = rect;
					
					if(game.ball.getBounds().intersects(brickRect.getBounds())) {
						setBrickValue(0, i, j);
						game.ball.xa = -1;
						game.ball.ya = -1;
						System.out.println(game.ball);
						
					}
				}
			}
		}
		
		
	}

	public void draw(Graphics2D g) {
		for(int i=0; i < map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.white);
					g.fillRect(j*maoWidth + 80, i*maoHeight+50, maoWidth, maoHeight);
					
					g.setStroke(new BasicStroke(1));
					g.setColor(Color.black);
					g.drawRect(j*maoWidth + 80, i*maoHeight+50, maoWidth, maoHeight);
			}
		}
	}
}
	public void setBrickValue(int value, int row, int col) {
		map[row][col]=value;
	}
}