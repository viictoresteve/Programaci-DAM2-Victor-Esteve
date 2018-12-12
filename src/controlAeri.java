import java.util.Scanner;

public class controlAeri {
	public int capacitat = 5;
	public Aeronau[] espaiAeri = new Aeronau[5];
	public int howManyAvio = 0;
	Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		controlAeri controladora = new controlAeri();
		controladora.principal();
	}

	public void principal() {
		if(howManyAvio == 5) {
			System.out.println("No pots crear mes avions.");
		}else {

			
			Aeronau avio;
			String matricula = "";
			int capacitatAvio = 0;
			String fabricant = "";
			String model = "";
			int x, y;
			System.out.println("Quina matricula te l'avio?: ");
			matricula = lector.next();
			System.out.println("Quina capacitat tindrà l'avio:");
			capacitatAvio = lector.nextInt();
			System.out.println("Quin fabricant ha fet l'avio: ");
			fabricant = lector.next();
			System.out.println("Quin model es l'avio?: ");
			model = lector.next();
			System.out.println("Posicio X de l'avio: ");
			x = lector.nextInt();
			System.out.println("Posicio Y de l'avio: ");
			y = lector.nextInt();
			try {


				avio = new Aeronau(model, fabricant, capacitatAvio, matricula, x, y);
				avio.matricula = matricula;
				avio.capacitat = capacitatAvio;
				avio.fabricant = fabricant;
				avio.model = model;
				avio.x = x;
				avio.y = y;

				agregarAvio(avio);
				howManyAvio++;
				System.out.println("S'ha creat l'avio: " + avio);

			} catch (Exception e) {
				System.out.println("Algo va mal");
			}
		}

	}


	private void showTable(String table[]) {
		// Creo un string per una fila i el completo amb | per cada columna, quan acaba
		// la fila, la mostro
		for (int x = 0; x < 5; x++) {
			System.out.print(table[x]);

		}
	}

	public void agregarAvio(Aeronau avio)
	{   int posLliure=0;
	//Ficar a l'array aTemp!. On? PosicioLliure primera que hi hagi
	posLliure=buscarPosLliure();
	espaiAeri[posLliure]=avio;
	//aula[posLliure]= new Alumne(nom,matricula,edat);
	}

	private int buscarPosLliure() {
		int pos=-1;
		boolean trobat=false;
		int index=0;
		while(index<capacitat && trobat==false)
		{
			if(espaiAeri[index]==null) {
				trobat=true;
				pos=index;
			}
			else {
				index++;
			}
		}

		return pos;
	}

	public boolean borrarAvio(String matricula) {
		boolean ok=false;
		int posEsborrar=buscarAvioArray(matricula);
		if (posEsborrar>=0)
		{
			espaiAeri[posEsborrar]=null;
			ok=true;
		}
		return ok;
	}

	private int buscarAvioArray(String matricula) {
		int pos=-1;
		boolean trobat=false;
		int index=0;
		while(index<capacitat && trobat==false)
		{
			if(espaiAeri[index]!=null) {
				if(espaiAeri[index].getMatricula().equals(matricula)) {
					trobat=true;
					pos=index;
				}
				else
				{index++;}
			}
			else {
				index++;
			}
		}

		return pos;

	}

}