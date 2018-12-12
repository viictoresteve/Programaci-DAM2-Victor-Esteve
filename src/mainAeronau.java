import java.util.Scanner;

public class mainAeronau {
	Scanner lector = new Scanner(System.in);
	controlAeri control = new controlAeri();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainAeronau main = new mainAeronau();
		main.menu();
	}

	public void menu() {

		System.out.println("1.- Donar d�alta avi� al sistema\r\n" + "2.- Gestionar un dels avions\r\n"
				+ "3.- Manteniment de l�espai aeri\r\n" + "4.- Informaci� de l�espai aeri");
		int choice = lector.nextInt();
		switch (choice) {
		case 1:
			controlAeri();
			break;
		case 2:
			if(control.howManyAvio != 0) {
				System.out.println("Inserti la matricula de l'avio que vulgui gestionar: ");
				String matricula = lector.next();
				gestioAvio(matricula);
				manteniment();
				mostrarInfo();
			}else {
				System.out.println("No hi ha cap avio per gestionar.");
			}

			break;

		case 3:
			manteniment();
			break;
		case 4:
			mostrarInfo();
			break;
		}
		menu();
	}

	public void controlAeri() {
		control.principal();

	}

	public void gestioAvio(String matricula) {		
		int i = 0;
		Aeronau avio = new Aeronau();
		boolean trobat = false;
		while(i<control.howManyAvio && trobat == false) {
			if(control.espaiAeri[i].getMatricula().equals(matricula)) {
				trobat = true;
				avio = control.espaiAeri[i];

				i++;

				System.out.println("a.- Encendre Motor.\r\n" + "b.- Apagar Motor.\r\n" + "c.- Accelerar.\r\n"
						+ "d.- Frenar.\r\n" + "e.- Agafar al�ada.\r\n" + "f.- Baixar al�ada.\r\n"
						+ "g.- Pujar /Baixar tren aterratge.\r\n" + "h.- Establir rumb\r\n" + "i.- Posicionar X,Y\r\n"
						+ "j.- Aparcar\r\n" + "K.- Finalitzar operativa avio seleccionat");

				String choice = lector.next();
				while(!choice.equals("k")) {
					switch(choice) {
					case "a": avio.encendreMotors(); break;
					case "b": avio.apagarMotors(); break;
					case "c": System.out.println("Quant vols accelerar? ");
					double accel = lector.nextDouble();
					if(accel<0) {System.out.println("Aixo es frenar!");}
					else {
						avio.velocitat(accel);
					}
					break;
					case "d": System.out.println("Quant vols frenar? ");
					double fren = lector.nextDouble();
					if(fren>0) {System.out.println("Aixo es accelerar!");}
					else {
						avio.velocitat(fren);
					}
					break;
					case "e": System.out.println("Quant vols pujar? ");
					int pujada = lector.nextInt();
					avio.alcada(pujada);
					break;
					case "f": System.out.println("Quant vols baixar? ");
					int baixada = lector.nextInt();
					avio.alcada(baixada);
					break;
					case "g":
						avio.trenAterratge();
						break;
					case "h": System.out.println("Estableix un rumb: ");
					int rumb = lector.nextInt();
					avio.rumb(rumb);
					break;
					case "i": System.out.println("Posiciona X: ");
					int x = lector.nextInt();
					avio.x = x;
					System.out.println("Posiciona Y: ");
					int y = lector.nextInt();
					avio.y = y;
					break;
					case "j": avio.aparcat();
					break;
					case "k": break;
					}
					System.out.println("a.- Encendre Motor.\r\n" + "b.- Apagar Motor.\r\n" + "c.- Accelerar.\r\n"
							+ "d.- Frenar.\r\n" + "e.- Agafar al�ada.\r\n" + "f.- Baixar al�ada.\r\n"
							+ "g.- Pujar /Baixar tren aterratge.\r\n" + "h.- Establir rumb\r\n" + "i.- Posicionar X,Y\r\n"
							+ "j.- Aparcar\r\n" + "K.- Finalitzar operativa avio seleccionat");

					choice = lector.next();
				}
			}else {
				System.out.println("Aquest avio no existeix!");
				break;

			}
		}


	}

	public void manteniment() {
		int eliminats=0;
		int i = 0;

		if(control.howManyAvio == 0) {
			System.out.println("No hi ha avions");
		}else {
			while(i<control.howManyAvio) {
				System.out.println(control.espaiAeri[i].aparcat());
				if(control.espaiAeri[i].aparcat() == true) {
					control.espaiAeri[i] = null;
					eliminats++;
				}
				i++;
			}
			System.out.println("S'han eliminat " + eliminats + " avions perque estaven aparcats.");
			control.howManyAvio = control.howManyAvio - eliminats;
		}

	}


	public void mostrarInfo(){
		for(int i=0;i<control.howManyAvio;i++)
		{
			if (control.espaiAeri[i]!=null)
			{ System.out.println(control.espaiAeri[i].retornaInfo());

			}
		}
		detectarPerills();


	}

	public void detectarPerills() {
		for(int i=0;i<control.howManyAvio;i++)
		{
			if (control.espaiAeri[i]!=null)
			{ 
				int j=i+1;
				while(j<control.howManyAvio) {
					if((((control.espaiAeri[i].x - control.espaiAeri[j].x ) < 50) && ((control.espaiAeri[i].alsada - control.espaiAeri[j].alsada) < 500)) ) {
						System.out.println("L'avio "+ control.espaiAeri[i].matricula + 
								" esta massa aprop de l'avio " + control.espaiAeri[j].matricula);
					} 
					j++;
				};

			}
		}


	}

	public Aeronau retornaAvio(String matricula){
		for(int i=0; i<5; i++) {
			if(control.espaiAeri[i].matricula == matricula) {
				Aeronau avio = control.espaiAeri[i];
				return avio;
			}
		}
		return null;

	}




}