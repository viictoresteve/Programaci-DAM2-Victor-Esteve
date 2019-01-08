import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static final double BLOCK_WIDTH = 60.0;
	public static final double BLOCK_HEIGHT = 20.0;

	public int lives = 3;
	public int speed = 0;

	public boolean gameOver;

	public static final int COUNT_BLOCKS_X = 11;
	public static final int COUNT_BLOCKS_Y = 4;

	public Ball ball = new Ball(this);

	public Racquet racquet = new Racquet(this);
	private List<Brick> maons = new ArrayList<Brick>();
	public Score scoreboard = new Score(this);

	public int countDown;
	public Timer timer = new Timer();

	public boolean isTimerActive = true;

	public Game() {
		int width = 70, height = 30;
		int i = 0, j = 0, x = 20, y = 80;
		while (i < 3) {
			while (j < 12) {
				int random = 1 + (int) (Math.random() * ((3 - 1) + 1));
				switch (random) {
				case 1:
					maons.add(new blueBrick(x, y, this));
					break;
				case 2:
					maons.add(new greenBrick(x, y, this));
					break;
				case 3:
					maons.add(new redBrick(x, y, this));
					break;
				}
				x += width;

				j++;
			}
			x = 20;
			j = 0;

			i++;
			y += height;
		}

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e, speed);
			}
		});
		setFocusable(true);
	}

	private void move() {
		ball.move();
		racquet.move();
	}

	private void checkEachBrick() {
		for (Brick mao : maons) {
			mao.doYou();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Color color = Color.white;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		scoreboard.draw(g2d);

		for (Brick mao : maons) {
			// int random = 1 + (int)(Math.random()*((3-1)+1));
			// if(random == 1) {
			// mao.draw(g2d, Color.blue);
			//
			// } else if (random == 2) {
			mao.paint(g2d, color);
			// } else {
			// mao.draw(g2d, Color.red);
			// }
		}

	}

	public void checkBricks() {
		List<Brick> auxMaons = new ArrayList<Brick>();

		for (Iterator<Brick> it = maons.iterator(); it.hasNext();) {
			Brick brick = it.next();
			if (brick.collission()) {
				if (brick.getVidas() == 0) {
					brick.doYou();
					it.remove();
					scoreboard.increaseScore();
				} else if (brick.getVidas() == 1) {
					if (brick.isRed()) {
						it.remove();
						brick.doYou();
						auxMaons.add(brick);
					}
				}
			} else if (brick.isRed()) {
				if (brick.getVidas() == 1) {
					brick.doYou();
					it.remove();
					auxMaons.add(brick);
				} else if (brick.getVidas() == 0) {
					it.remove();
				}
			}
		}
		for (Iterator<Brick> it = auxMaons.iterator(); it.hasNext();) {
			Brick brick = it.next();
			maons.add(brick);
		}

	}

	public TimerTask setCountDownTask() {
		countDown = 10;

		TimerTask task = new TimerTask() {
			public void run() {
				countDown--;
				isTimerActive = true;
				System.out.println(countDown);
				if (countDown == 0) {
					isTimerActive = false;
					speed = 0;
					this.cancel();
				}
			}
		};

		return task;
	}

	public void gameOver() {
		gameOver = true;
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("ARKANOID");
		Game game = new Game();
		frame.add(game);
		frame.setSize(900, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.checkBricks();
			game.repaint();
			Thread.sleep(10);
		}
	}
}