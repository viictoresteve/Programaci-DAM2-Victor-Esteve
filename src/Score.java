import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

class Score {
		public static final int PLAYER_LIVES = 5;
		private static final String FONT = "Courier New";
		public static final int COUNT_BLOCKS_X = 12;
		public static final int COUNT_BLOCKS_Y = 3;
		public static final int SCREEN_WIDTH = 900;
		public static final int SCREEN_HEIGHT = 800;
		
		public Game game;
		
		int score = 0;
		boolean win = false;
		String text = "";

		Font font;

		Score(Game game) {
			this.game = game;
			font = new Font(FONT, Font.PLAIN, 12);
			text = "Welcome to Arkanoid Java version";
		}

		void increaseScore() {
			score++;
			if (score == (COUNT_BLOCKS_X * COUNT_BLOCKS_Y)) {
				win = true;
				text = "You have won! \nYour score was: " + score
						+ "\n\nPress Enter to restart";
			} else {
				updateScoreboard();
			}
		}


		void updateScoreboard() {
			text = "Score: " + score + "  Lives: " + game.lives;
		}

		void draw(Graphics g) {
			if (win || game.gameOver == true) {
				font = font.deriveFont(50f);
				FontMetrics fontMetrics = g.getFontMetrics(font);
				g.setColor(Color.BLACK);
				g.setFont(font);
				int titleHeight = fontMetrics.getHeight();
				int lineNumber = 1;
				for (String line : text.split("\n")) {
					int titleLen = fontMetrics.stringWidth(line);
					g.drawString(line, (SCREEN_WIDTH / 2) - (titleLen / 2),
							(SCREEN_HEIGHT / 4) + (titleHeight * lineNumber));
					lineNumber++;

				}
			} else {
				font = font.deriveFont(34f);
				FontMetrics fontMetrics = g.getFontMetrics(font);
				g.setColor(Color.BLACK);
				g.setFont(font);
				int titleLen = fontMetrics.stringWidth(text);
				int titleHeight = fontMetrics.getHeight();
				g.drawString(text, (SCREEN_WIDTH / 2) - (titleLen / 2),
						titleHeight + 5);

			}
		}

	}