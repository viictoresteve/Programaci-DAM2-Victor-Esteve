import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	public static final int DIAMETER = 30;
	int x = 0;
	int y = 200;
	int xa = 4;
	int ya = 4;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = 4;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -4;
		if (y + ya < 0)
			ya = 4;
		if (y + ya > game.getHeight() - DIAMETER) {
			game.lives--;
			game.scoreboard.updateScoreboard();
			x=0;
			y=300;
			if(game.lives == 0) {
				game.gameOver();
				game.gameOver = true;
			}
		}
			
		
		if (collision()){
			ya = -4;
			y = game.racquet.getTopY() - DIAMETER;
		}
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}