import java.awt.Color;
import java.awt.Graphics2D;

public class blueBrick extends Brick {
int vidas = 1;
Game game;
	public blueBrick(int x, int y, Game game) {
		super(x, y, game);
		this.game = game;
		
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics2D g2d, Color color) {
		super.paint(g2d, Color.blue);
	}
	public void doYou() {
		game.racquet.xa += 2;
		vidas--;
		
		
	}

}
