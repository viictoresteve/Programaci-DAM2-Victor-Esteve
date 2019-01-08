import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ciutat {
	public int TAMANYX = 10;
	public int TAMANYY = 10;

	public List<Zombie> zombieList = new ArrayList<Zombie>();
	public List<Huma> humanList = new ArrayList<Huma>();
	private char map[][] = new char[TAMANYX][TAMANYY];
	Missil missil;
	int contadorCicles = 0;
	Scanner lector = new Scanner(System.in);

	public Ciutat() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ciutat ciutat = new Ciutat();
		ciutat.menu();

	}

	public int menu() {
		System.out.println("Benvingut a Colapi City");
		System.out.println("Trii que vol que passi aquest torn: /n");
		System.out.println("1: Generar caos a dins de la ciutat.");
		System.out.println("2: Disparar 1 missil del tipus Z.");
		System.out.println("3: Evolucionar un cicle de temps.");
		System.out.println("4: Mostrar l'estat de la ciutat.");
		System.out.println("5: Sortir del programa.");
		int choice = lector.nextInt();
		switch (choice) {
		case 1:
			generarCaos();
			break;
		case 2:
			dispararMissil();
			break;
		case 3:
			evolucionar();
			break;
		case 4:
			mostrarEstat();
			break;
		// case 5: sortir(); break;
		}
		return choice;
	}

	public void generarCaos() {
		int contaHumans = 0, contaZombies = 0;
		int humans = 750, zombies = 10;
		int X;
		int Y;
		System.out.println("Quants humans voleu afegir? ");
		humans = lector.nextInt();
		System.out.println("Quants zombies voleu afegir? ");
		zombies = lector.nextInt();
		while (contaHumans < humans) {
			X = (int) (Math.random() * TAMANYX);
			Y = (int) (Math.random() * TAMANYY);
			map[X][Y] = 'H';
			humanList.add(new Huma(X, Y));
			contaHumans++;

		}

		while (contaZombies < zombies) {
			X = (int) (Math.random() * TAMANYX);
			Y = (int) (Math.random() * TAMANYY);
			System.out.println(X + " " + Y);
			zombieList.add(new AZombie(X, Y, this));
			contaZombies++;
			map[X][Y] = 'A';
		}
		menu();
	}

	public void dispararMissil() {
		int x, y;
		int howManyDied = 0;
		System.out.println("En quina posicio vols fer caure el missil? X i Y:");
		System.out.println("X: ");
		x = lector.nextInt();
		System.out.println("Y: ");
		y = lector.nextInt();
		missil = new Missil(x, y);

		for (Iterator<Zombie> it = zombieList.iterator(); it.hasNext();) {
			Zombie zombie = it.next();

			zombie.gotHit();
			System.out.println(zombie.getVidas());
			if (zombie.getVidas() == 0) {
				howManyDied++;
				it.remove();
			}

		}
		System.out.println("Zombies died: " + howManyDied);
		menu();
	}

	public void evolucionar() {
		List<Zombie> auxZombies = new ArrayList<Zombie>();
		auxZombies = zombieList;
		int x = 0, y = 0;
		contadorCicles++;
		if (contadorCicles % 5 == 0) {
			for (Zombie zombie : zombieList) {
				zombie.Action();
				auxZombies.add(zombie);
				System.out.println("Zombie: " + zombie);
				x = (int) (Math.random() * TAMANYX);
				y = (int) (Math.random() * TAMANYY);
				if (zombie instanceof AZombie) {
					for (Iterator<Zombie> it = zombieList.iterator(); it.hasNext();) {
						Zombie zombie1 = it.next();
						if (zombie1 == zombie) {
							it.remove();
							auxZombies.add(new BZombie(x, y, this));
						}

					}
				} else if (zombie instanceof BZombie) {
					for (Iterator<Zombie> it = zombieList.iterator(); it.hasNext();) {
						Zombie zombie1 = it.next();
						if (zombie1 == zombie) {
							it.remove();
							auxZombies.add(new CZombie(x, y, this));
						}
					}
				}
			}

		}
		zombieList = auxZombies;

		menu();

	}

	public void mostrarEstat() {
		for (Zombie zombie : zombieList) {
			System.out.println("ZombieX: " + zombie.getX());
			if (zombie.getVidas() == 2) {
				if (zombie instanceof AZombie) {
					map[zombie.getX()][zombie.getY()] = 'A';
				} else if (zombie instanceof BZombie) {
					map[zombie.getX()][zombie.getY()] = 'B';
				} else if (zombie instanceof CZombie) {
					map[zombie.getX()][zombie.getY()] = 'C';
				}

			} else if (zombie.getVidas() == 1) {
				if (zombie instanceof AZombie) {
					map[zombie.getX()][zombie.getY()] = 'a';
				} else if (zombie instanceof BZombie) {
					map[zombie.getX()][zombie.getY()] = 'b';
				} else if (zombie instanceof CZombie) {
					map[zombie.getX()][zombie.getY()] = 'c';
				}
			} else {
				map[zombie.x][zombie.y] = ' ';
			}

		}
		System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
		menu();

	}

	public void sortir() {
		System.exit(0);
	}

}
