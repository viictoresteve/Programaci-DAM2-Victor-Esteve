
public class Zombie {
	int vidas = 3;
	int x, y;
	char type;

	public Zombie() {

	}

	public Zombie(int X, int Y) {
		this.x = X;
		this.y = Y;
	}

	public void gotHit() {
		vidas--;
	}

	public void Action() {

	}

	// getters i setters
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
