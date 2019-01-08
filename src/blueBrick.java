import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

public class blueBrick extends Brick {
Game game;
long t= System.currentTimeMillis();
long end = t+15000;
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
		if(vidas == 0) {
			if(game.isTimerActive) {
				game.countDown = 10;
			} else {
				game.timer.schedule(game.setCountDownTask(), 0, 1000);
			}
		   	 game.speed = 4;

		}
		

	}

		


	
}
