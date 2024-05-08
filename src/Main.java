import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		// ** A HACER **
			// Crear varios planetas
			// Crear ejercito por planeta con stats inicales
			// Cada X tiempo aumentan nuestros recursos 
			// Cada 3 min reciviremos un ataque con su respectiva batalla ( Gardaremos registro ultimas 5)
			// Una vez creado todo tendremos menu (con o sin GUI) para controlar nuestro planeta
			
			// Para crear mi defensa (ArrayList<MilitaryUnit> planetArmy;)
			// utilizaremos const CHANCE_ATTACK_PLANET_UNITS	
			// int[][] initialArmies??
			// rellnando <int[] actualNumberUnitsPlanet> y <int initialNumberUnitsPlanet>
		
		
			// Prueba de ejecucion automatica
			TimerTask task1 = new TimerTask() {
				public void run(){
					System.out.println("Hola mundo");
				}
			};
			
			TimerTask task2 = new TimerTask() {
				public void run(){
				System.out.println("Bienvenido");
				}
			};
			
			Timer timer = new Timer();
			timer.schedule(task1, 10000, 5000);
			timer.schedule(task2, 8000, 3000);
			

	}

	public void createEnemyArmy() {
		// Num aleatorio del 0.0 al 10.0
		// Usar variable const CHANCE_ATTACK_ENEMY_UNITS
//		Para crear el ejército enemigo, dispondremos de unos recursos iniciales, que conforme vayan
//		sucediendo batallas, serán mayores .
//		Iremos creando unidades enemigas aleatoriamente pero con las siguientes probabilidades:
//			● Cazador ligero 35%
//			● Cazador pesado 25%
//			● Nave de Batalla 20%
//			● Acorazado 20%.
//		
//		Mientras tengamos suficientes recursos para crear la unidad con menor coste, es decir, cazador
//		ligero, iremos creando unidades aleatoriamente según las probabilidades anteriores
	}
	
	public void ViewThreat() {
		// Ver la nueva amenaza 
//		NEW THREAT COMING
//		Ligth Hunter 16
//		Heavy Hunter 12
//		Battle Ship 1
//		Armored Ship 1
	}
}
