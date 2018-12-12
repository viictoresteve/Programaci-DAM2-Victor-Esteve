public class Aeronau {
	String model;
	String fabricant;
	int capacitat;
	String matricula;
	boolean motors = false;
	boolean trenAterrizaje;
	double velocitatTotal;
	double alsada=0;
	double rumb;
	int x, y;
	boolean aparcat=false;
	controlAeri control = new controlAeri();

	public Aeronau(String model, String fabricant, int capacitat, String matricula, int x, int y) {
		model = this.model;
		fabricant = this.fabricant;
		capacitat = this.capacitat;
		matricula = this.matricula;
		x = this.x;
		y = this.y;

	}


	public Aeronau() {
	}

	public void encendreMotors() {
		if(motors == false)
			motors = true;
		else {
			System.out.println("Els motors ja estaven encesos");
		}
	}
	public void apagarMotors() {
		if(motors == true) {
			motors = false;
		}
		else {
			System.out.println("Els motors ja estaven apagats");
		}
	}

	public void velocitat(double velocitat) {
		System.out.println(velocitatTotal);
		if(velocitatTotal > 1) {
			aparcat = false;
		}
		velocitatTotal += velocitat;

	}

	public void trenAterratge() {
		trenAterrizaje = !trenAterrizaje;

	}

	public void alcada(double alsada){

		this.alsada += alsada;
		if(this.alsada > 0) {
			System.out.println("L'alçada no pot ser mes petita que 0");
			this.alsada = 0;
		} 
	}

	public void rumb(double rumb) {
		if(rumb >= 0 && rumb <= 360) {
			this.rumb += rumb;
		}else {
			System.out.println("El rumb ha d'estar entre 0 i 360 graus!");
		}
	}

	public boolean aparcat() {
		if(velocitatTotal > 20) {
			System.out.println("No pots aparcar l'avio, vas a mes de 20km/h");
			aparcat = false;
			return false;
		}else if(this.alsada != 0) {
			System.out.println("No pots aparcar l'avio, no estas al terra.");
			return false;
		}else if(velocitatTotal > 1) {
			aparcat = false;
			return false;	
		}else {
			aparcat = true;
			return true;
		}

	}


	public char retornarEstatAvio() {
		return 0;

	}

	public String retornaInfo() {
		String tren;
		String motor;
		if(trenAterrizaje == false) {
			tren = "pujat";
		}else {
			tren="baixat";
		}
		if(motors == false) {
			motor="Ences";
		}else {
			motor="Apagat";
		}
		{String dades="";
		dades = "Marca: " + fabricant;
		dades += "\nMatricula es: " + matricula;
		dades += "\nModel es: " + model;
		dades += "\nx: " + x;
		dades += "\ny: " + y;
		dades += "\nalçada: " + alsada + "m";
		dades += "\nvelocitat: " + velocitatTotal + "km/h";
		dades += "\ntren: " + tren;
		dades += "\nmotors: " + motor;

		return dades;
		}
	}

	//Getters i Setters
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getFabricant() {
		return fabricant;
	}


	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}


	public int getCapacitat() {
		return capacitat;
	}


	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void valueToPrint(int posicion) {
		int i=0;
		while (i < 9) {
			
			
		}
	}


}
