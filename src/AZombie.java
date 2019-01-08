
public class AZombie extends Zombie {
	int vidas = 3;
	int x, y;
	char type = 'A';
	Ciutat ciutat;

	public AZombie(int X, int Y, Ciutat ciutat) {
		this.x = X;
		this.y = Y;
		this.ciutat = ciutat;

	}

	public void gotHit() {
		if (((ciutat.missil.x + ciutat.missil.missilArea) < x) || ((ciutat.missil.y + ciutat.missil.missilArea) < y)) {
			System.out.println("Zombie tocado!");
			vidas--;
		}
	}

	public void Action() {
		for (Huma huma : ciutat.humanList) {
			if (((huma.x == x) || (huma.x == x + 1) || (huma.y == y) || (huma.y == y + 1))) {
				System.out.println("Huma infectat!");

			}
		}

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

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public Ciutat getCiutat() {
		return ciutat;
	}

	public void setCiutat(Ciutat ciutat) {
		this.ciutat = ciutat;
	}

}
