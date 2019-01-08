import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	private Game game;
	int x, y, vidas;
	protected boolean isHit = false;
	


	int maoWidth = 70;
	int maoHeight = 30;
	Rectangle rect;
	
	public Brick(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
		
		rect = new Rectangle(x, y, maoWidth, maoHeight);
		
		
		
	}

	
	public boolean collission() {
		if(game.ball.getBounds().intersects(rect.getBounds())) {
			if(game.ball.x < x ) {
				game.ball.xa = -4;
			} else if(game.ball.x > x) {
				game.ball.xa = 4;
			}
			if(game.ball.y < y) {
				game.ball.ya = -4;
			} else if(game.ball.y > y) {
				game.ball.ya = 4;
			}
			vidas--;

			return true;
		} else {
			return false;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, maoWidth, maoHeight);
	}


	public void paint(Graphics2D g2d, Color color) {
		
		g2d.setColor(color);
		g2d.fillRect(x, y, maoWidth, maoHeight);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.black);
		g2d.drawRect(x, y, maoWidth, maoHeight);		
	}

	public void doYou() {
		
	}
	
	public boolean isRed() {
		return false;
	}
	
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
		
}
