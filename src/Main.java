import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main implements Variables{

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
			
		
//			int technologyDefense, int technologyAtack, int metal, int deuterium,
//			int upgradeDefenseTechnologyDeuteriumCost, int upgradeAttackTechnologyDeuteriumCost,
//			ArrayList<MilitaryUnit>[] army
			ArrayList<MilitaryUnit>[] mainArmy = new ArrayList[7];
			
			//*** UNIDADES DE BASE EN MI EJERCITO ***
			final int BASE_UNIT_LIGHT_HUNTER = 15;
			final int BASE_UNIT_HEAVY_HUNTER = 5;
			final int BASE_UNIT_BATTLE_SHIP = 0;
			final int BASE_UNIT_ARMORED_SHIP = 1;
			final int BASE_UNIT_MISSILE_LOUNCHER = 10;
			final int BASE_UNIT_ION_CANNON = 2;
			final int BASE_UNIT_PLASMA_CANNON = 0;
			
//			Army[0] → arrayList de Ligth Hunter
//			Army[1] → arrayList de Heavy Hunter
//			Army[2] → arrayList de Battle Ship
//			Army[3] → arrayList de Armored Ship
//			Army[4] → arrayList de Missile Launcher
//			Army[5] → arrayList de Ion Cannon
//			Army[6] → arrayList de Plasma Cannon
			
			// Flota
			ArrayList<MilitaryUnit> arrayLigthHunter = new ArrayList<MilitaryUnit>();
			for (int i = 0; i < BASE_UNIT_LIGHT_HUNTER; i++) {
				arrayLigthHunter.add(new LigthHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
			}
			ArrayList<MilitaryUnit> arrayHeavyHunter = new ArrayList<MilitaryUnit>();
			for (int i = 0; i < BASE_UNIT_HEAVY_HUNTER; i++) {
				arrayHeavyHunter.add(new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
			}
			ArrayList<MilitaryUnit> arrayBattleShip = new ArrayList<MilitaryUnit>();
			for (int i = 0; i < BASE_UNIT_BATTLE_SHIP; i++) {
				arrayBattleShip.add(new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
			}
			
			ArrayList<MilitaryUnit> arrayArmoredShip = new ArrayList<MilitaryUnit>();
			for (int i = 0; i < BASE_UNIT_ARMORED_SHIP; i++) {
				arrayArmoredShip.add(new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
			}
			// Defensas
			Defense d = new Defense(BASE_UNIT_ARMORED_SHIP, BASE_UNIT_ION_CANNON, BASE_UNIT_PLASMA_CANNON)
			ArrayList<MilitaryUnit> arrayMissileLouncher = new ArrayList<MilitaryUnit>();
			for (int i = 0; i < BASE_UNIT_MISSILE_LOUNCHER; i++) {
				arrayMissileLouncher.add(new MisileLauncher(ARMOR_MISSILELAUNCHER, BASE_DAMAGE_MISSILELAUNCHER));
			}
			ArrayList<MilitaryUnit> arrayIonCannon = new ArrayList<MilitaryUnit>();
			for (int i = 0; i < BASE_UNIT_ION_CANNON; i++) {
				arrayIonCannon.add(new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
			}
			
			
			mainArmy[0] = arrayLigthHunter;
			
			Planet mainPlanet = new Planet(0,
					0,
					METAL_BASE_ENEMY_ARMY, 
					DEUTERIUM_BASE_ENEMY_ARMY,
					UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
					UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
			
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
