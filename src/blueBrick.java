import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Timer;

public class blueBrick extends Brick {
Game game;
	public blueBrick(int x, int y, Game game) {
		super(x, y, game);
		this.game = game;
		super.vidas = 1;
		
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics2D g2d, Color color) {
		super.paint(g2d, Color.blue);
	}
	public void doYou() {
		game.speed = 3;
		vidas--;
		
		
	}
	

}
