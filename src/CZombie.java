
public class CZombie extends Zombie {
	int vidas = 3;
	int x;
	int y;
	char type = 'C';
	Ciutat ciutat;

	public CZombie(int X, int Y, Ciutat ciutat) {

	}

	public void gotHit() {
		System.out.println("Zombie lives: " + vidas);
		if (((ciutat.missil.x + 50) < x) || ((ciutat.missil.y + 50) < y)) {
			vidas = 0;
		}

	}

	public void Action() {
		for (Huma huma : ciutat.humanList) {
			if (((huma.x == x) || (huma.x == x + 1) || (huma.y == y) || (huma.y == y + 1))) {
				System.out.println("Huma infectat!");
				huma.vidas--;

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

	public Ciutat getCiutat() {
		return ciutat;
	}

	public void setCiutat(Ciutat ciutat) {
		this.ciutat = ciutat;
	}

}
