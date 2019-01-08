import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class redBrick extends Brick{
	int ya = 0;
	Game game;

	public redBrick(int x, int y, Game game) {
		super(x, y, game);
		super.vidas = 3;
		this.game = game;
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics2D g2d, Color color) {
		super.paint(g2d, Color.red);
	}
	public void doYou() {

		if(vidas == 1) {
			if(y < game.getHeight()) {
				y =y+5;
				checkCollission();
			} else {
				vidas = 0;
			}
			
		}
	}
	
	public boolean isRed() {
		return true;
	}
	
	public void checkCollission() {
		if(game.racquet.getBounds().intersects(this.getBounds())) {
			game.gameOver();
		}
	}

}
