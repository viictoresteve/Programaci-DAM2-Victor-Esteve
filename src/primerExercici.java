import java.util.Scanner;

public class primerExercici {
	static final int TAMANYX = 10;
	static final int TAMANYY = 30;
	private char adminTable[][] = new char[TAMANYX][TAMANYY];
	private char userTable[][]= new char[TAMANYX][TAMANYY];
	private int positionx = 0;
	private int positiony = 15;
	Scanner lector = new Scanner(System.in);
	private int lives = 5;
	private int pickaxe = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primerExercici programa = new primerExercici();
		programa.inici();
	}
	
	public void inici() {
		adminTable = emptyTable();
		userTable = emptyTable();

		adminTable=fillTable();
		userTable=jugador();
		showTable(userTable);
		while(lives >= 0) {
			reminder();
			path();
//			saltar(20);
			showTable(userTable);
		}


}
	
	void reminder() {
		saltar(2);
		System.out.println("Lives remaining: " + lives);
		if(pickaxe > 0) {
			System.out.println("Pickaxes left: " + pickaxe + " pickaxes");
		}
		
	}
	
	public char[][] fillTable() {
		int winX = (int) (Math.random()*9);
		int winY = (int) (Math.random()*29);
		walls();
		bombs();
		pickaxe();
		adminTable[winX][winY] = 'S';
		return adminTable;
		
		
	}
	
	public char[][] walls(){
		int wallsy;
		int wallsx;
		for(int wallsCount=0;wallsCount<20;wallsCount++) {
			wallsy = (int) (Math.random()*29);
			wallsx = (int) (Math.random()*9);
			adminTable[wallsx][wallsy] = '#';
		}

		
		return adminTable;
	}
	public char[][] bombs(){
		int bombsX = (int) (Math.random()*9);
		int bombsY = (int) (Math.random()*29);
		
		for(int bombsCount=0;bombsCount<5;bombsCount++) {
			bombsY = (int) (Math.random()*29);
			bombsX = (int) (Math.random()*9);
			adminTable[bombsX][bombsY] = '@';
		}
		return adminTable;
	}
	
	public char [][] pickaxe() {
		int pickaxeX = (int) (Math.random()*9);
		int pickaxeY = (int) (Math.random()*29);
		
		for(int pickaxeCount=0;pickaxeCount<2;pickaxeCount++) {
			pickaxeY = (int) (Math.random()*29);
			pickaxeX = (int) (Math.random()*9);
			adminTable[pickaxeX][pickaxeY] = '?';
		}
		return adminTable;
	}
	
	public void path() {
		char path;
		char destroy;
		System.out.println("Where do you want to move? W to go forward, A to go left, S to go downward, d to go right.");
		path = lector.next().charAt(0);
		userTable[positionx][positiony] = ' ';
		switch(path) {
		case 'w': positionx++;
		if(adminTable[positionx][positiony] == '#') {
			if(pickaxe>0) {
				System.out.println("You found a wall, but you got a pickaxe. Do you want to destroy it? (Y/N)");
				destroy = lector.next().charAt(0);
				if(destroy == 'Y' || destroy == 'y') {
					pickaxe--;
					System.out.println("You broke the wall!");
					userTable[positionx][positiony] = '*';
					break;
				}else if(destroy == 'N' || destroy == 'n') {
					userTable[positionx][positiony] = '#';
					positionx--;
					userTable[positionx][positiony] = '*';
					break;
				}else {
					System.out.println("You didn't enter Y or N so you lost a life, the pickaxe and didn't break the wall! >:D");
					lives--;
					pickaxe--;
					userTable[positionx][positiony] = '#';
					positionx--;
					userTable[positionx][positiony] = '*';
					break;
					
				}

			}
			System.out.println("You found a wall! You go back to your position");
			userTable[positionx][positiony] = '#';
			positionx--;
			userTable[positionx][positiony] = '*';
		
		}else if(adminTable[positionx][positiony] == '@') {
			userTable[positionx][positiony] = '@';
			lives--;
			System.out.println("BOOM! Lives left: " + lives);
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == '?') {
			System.out.println("WOW! You found a pickaxe! You can go through walls now!");
			pickaxe++;			
			userTable[positionx][positiony] = '*';
		}else if(adminTable[positionx][positiony] == 'S') {
			System.out.println("Congratulations!!! You've found the exit! You won!");
		}else {
			userTable[positionx][positiony] = '*';
		}
		break;
		
		case 'a': positiony--;
		if(adminTable[positionx][positiony] == '#') {
			if(pickaxe>0) {
				System.out.println("You found a wall, but you got a pickaxe. Do you want to destroy it? (Y/N)");
				destroy = lector.next().charAt(0);
				if(destroy == 'Y' || destroy == 'y') {
					pickaxe--;
					System.out.println("You broke the wall!");
					userTable[positionx][positiony] = '*';
					break;
				}else if(destroy == 'N' || destroy == 'n') {
					userTable[positionx][positiony] = '#';
					positiony++;
					userTable[positionx][positiony] = '*';
					break;
				}else {
					System.out.println("You didn't enter Y or N so you lost a life, the pickaxe and didn't break the wall! >:D");
					lives--;
					pickaxe--;
					userTable[positionx][positiony] = '#';
					positiony++;
					userTable[positionx][positiony] = '*';
					break;
					
				}

			}
			System.out.println("You found a wall! You go back to your position");
			userTable[positionx][positiony] = '#';
			positiony++;
			userTable[positionx][positiony] = '*';
		
		}else if(adminTable[positionx][positiony] == '@') {
			userTable[positionx][positiony] = '@';
			lives--;
			System.out.println("BOOM! Lives left: " + lives);
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == '?') {
			System.out.println("WOW! You found a pickaxe! You can go through walls now!");
			pickaxe++;			
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == 'S') {
			System.out.println("Congratulations!!! You've found the exit! You won!");
		}else {
			userTable[positionx][positiony] = '*';
		}
		break;
		
		
		case 's': positionx--;
		if(adminTable[positionx][positiony] == '#') {
			if(pickaxe>0) {
				System.out.println("You found a wall, but you got a pickaxe. Do you want to destroy it? (Y/N)");
				destroy = lector.next().charAt(0);
				if(destroy == 'Y' || destroy == 'y') {
					pickaxe--;
					System.out.println("You broke the wall!");
					userTable[positionx][positiony] = '*';
					break;
				}else if(destroy == 'N' || destroy == 'n') {
					userTable[positionx][positiony] = '#';
					positionx++;
					userTable[positionx][positiony] = '*';
					break;
				}else {
					System.out.println("You didn't enter Y or N so you lost a life, the pickaxe and didn't break the wall! >:D");
					lives--;
					pickaxe--;
					userTable[positionx][positiony] = '#';
					positionx++;
					userTable[positionx][positiony] = '*';
					break;
					
				}

			}
			System.out.println("You found a wall! You go back to your position");
			userTable[positionx][positiony] = '#';
			positionx++;
			userTable[positionx][positiony] = '*';
		
		}else if(adminTable[positionx][positiony] == '@') {
			userTable[positionx][positiony] = '@';
			lives--;
			System.out.println("BOOM! Lives left: " + lives);
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == '?') {
			System.out.println("WOW! You found a pickaxe! You can go through walls now!");
			pickaxe++;			
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == 'S') {
				System.out.println("Congratulations!!! You've found the exit! You won!");
			
		}else {
			userTable[positionx][positiony] = '*';
		}
		break;
		
		case 'd': positiony++;
		if(adminTable[positionx][positiony] == '#') {
			if(pickaxe>0) {
				System.out.println("You found a wall, but you got a pickaxe. Do you want to destroy it? (Y/N)");
				destroy = lector.next().charAt(0);
				if(destroy == 'Y' || destroy == 'y') {
					pickaxe--;
					System.out.println("You broke the wall!");
					userTable[positionx][positiony] = '*';
					break;
				}else if(destroy == 'N' || destroy == 'n') {
					userTable[positionx][positiony] = '#';
					positiony--;
					userTable[positionx][positiony] = '*';
					break;
				}else {
					System.out.println("You didn't enter Y or N so you lost a life, the pickaxe and didn't break the wall! >:D");
					lives--;
					pickaxe--;
					userTable[positionx][positiony] = '#';
					positiony--;
					userTable[positionx][positiony] = '*';
					break;
					
				}

			}
			System.out.println("You found a wall! You go back to your position");
			userTable[positionx][positiony] = '#';
			positiony--;
			userTable[positionx][positiony] = '*';
		
		}else if(adminTable[positionx][positiony] == '@') {
			userTable[positionx][positiony] = '@';
			lives--;
			System.out.println("BOOM! Lives left: " + lives);
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == '?') {
			System.out.println("WOW! You found a pickaxe! You can go through walls now!");
			pickaxe++;			
			userTable[positionx][positiony] = '*'; 
		}else if(adminTable[positionx][positiony] == 'S') {
			System.out.println("Congratulations!!! You've found the exit! You won!");
			
		}else {
			userTable[positionx][positiony] = '*';
		}
		break;
		}
				
	}

	
	public void player() {
		
	}
	
	public char[][] jugador() {
		System.out.println("Hello! Welcome to the labyrinth. Rules will be explained down below. Thanks for playing.");
		userTable[0][15] = '*';
		return userTable;
	}
	
	private void showTable(char table[][]) {
		//Creo un string per una fila i el completo amb | per cada columna, quan acaba la fila, la mostro
		for(int x=0; x<TAMANYX;x++) {
			for(int y=0; y<TAMANYY;y++) {
				System.out.print(table[x][y] + "|");
			}
			System.out.println();
		}
	}
	class cCoordenada{
		//Creem una classe cCoordenada per poder retornar 2 valors a l'hora en una objecte
		public int fila;
		public int columna;
	}
	
	public char[][] emptyTable() {
		//Generem una taula buida i la retornem
		char genericTable[][]=new char[TAMANYX][TAMANYY];

		for(int x=0; x<TAMANYX;x++) {
			for(int y=0; y<TAMANYY;y++) {
				genericTable[x][y]=0;
			}
		}
		return genericTable;
	}
	private void saltar(int linies) {
		for (int i=1; i<=linies;i++) {
			System.out.println("");
		}
		
	}
}
