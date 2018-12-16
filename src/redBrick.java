import java.awt.Color;
import java.awt.Graphics2D;

public class redBrick extends Brick{

	public redBrick(int x, int y, Game game) {
		super(x, y, game);
		super.vidas = 2;
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics2D g2d, Color color) {
		super.paint(g2d, Color.red);
	}
	public void doYou() {
		vidas--;
		System.out.println(vidas);
	}

}
