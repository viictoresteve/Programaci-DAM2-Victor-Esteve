import java.awt.Color;
import java.awt.Graphics2D;

public class redBrick extends Brick{
	int vidas = 2;

	public redBrick(int x, int y, Game game) {
		super(x, y, game);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics2D g2d, Color color) {
		super.paint(g2d, Color.red);
	}

}
