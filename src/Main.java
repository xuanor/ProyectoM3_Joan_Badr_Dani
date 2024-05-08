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
			
		
			 
			Planet mainPlanet = new Planet(0,
					0,
					METAL_BASE_ENEMY_ARMY, 
					DEUTERIUM_BASE_ENEMY_ARMY,
					UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
					UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
			
			// Me crea mi ejercito y se lo añade al planeta
			//createMyArmy(mainPlanet);
			
			Planet enemyPlanet = new Planet(0,
					0,
					METAL_BASE_ENEMY_ARMY, 
					DEUTERIUM_BASE_ENEMY_ARMY,
					UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
					UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
			
			// Me crea mi ejercito y se lo añade al planeta
			createEnemyArmy(enemyPlanet);
			
			
//			// Prueba de ejecucion automatica
//			TimerTask task1 = new TimerTask() {
//				public void run(){
//					System.out.println("Hola mundo");
//				}
//			};
//			
//			TimerTask task2 = new TimerTask() {
//				public void run(){
//				System.out.println("Bienvenido");
//				}
//			};
//			
//			Timer timer = new Timer();
//			timer.schedule(task1, 10000, 5000);
//			timer.schedule(task2, 8000, 3000);
			
			//mainPlanet.printStats();
			enemyPlanet.printStats();
			
	}
	public static void createMyArmy(Planet myPlanet) {
		ArrayList<MilitaryUnit>[] mainArmy = new ArrayList[7];
		
		//*** UNIDADES DE BASE EN MI EJERCITO ***
		final int BASE_UNIT_LIGHT_HUNTER = 15;
		final int BASE_UNIT_HEAVY_HUNTER = 5;
		final int BASE_UNIT_BATTLE_SHIP = 0;
		final int BASE_UNIT_ARMORED_SHIP = 1;
		final int BASE_UNIT_MISSILE_LOUNCHER = 10;
		final int BASE_UNIT_ION_CANNON = 2;
		final int BASE_UNIT_PLASMA_CANNON = 0;
		
//		Army[0] → arrayList de Ligth Hunter
//		Army[1] → arrayList de Heavy Hunter
//		Army[2] → arrayList de Battle Ship
//		Army[3] → arrayList de Armored Ship
//		Army[4] → arrayList de Missile Launcher
//		Army[5] → arrayList de Ion Cannon
//		Army[6] → arrayList de Plasma Cannon
		
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
		Clases_defensa d = new Clases_defensa();
		
		ArrayList<MilitaryUnit> arrayMissileLouncher = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_MISSILE_LOUNCHER; i++) {
			arrayMissileLouncher.add(d.new MissileLauncher(ARMOR_MISSILELAUNCHER, BASE_DAMAGE_MISSILELAUNCHER));
		}
		ArrayList<MilitaryUnit> arrayIonCannon = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_ION_CANNON; i++) {
			arrayIonCannon.add(d.new IonCannon(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
		}
		ArrayList<MilitaryUnit> arrayPlasmaCannon = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_PLASMA_CANNON; i++) {
			arrayPlasmaCannon.add(d.new PlasmaCannon(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
		}
		
		mainArmy[0] = arrayLigthHunter;
		mainArmy[1] = arrayHeavyHunter;
		mainArmy[2] = arrayBattleShip;
		mainArmy[3] = arrayArmoredShip;
		
		mainArmy[4] = arrayMissileLouncher;
		mainArmy[5] = arrayIonCannon;
		mainArmy[6] = arrayPlasmaCannon;
		
		myPlanet.setArmy(mainArmy);
		//System.out.println("Longitud = " + mainArmy.length);
	}

	public static void createEnemyArmy(Planet enemyPlanet) {
		
		
		
		// Num aleatorio del 0.0 al 10.0
		
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
		
		ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[7];
		//*** UNIDADES DE BASE EN MI EJERCITO ***
		int BASE_UNIT_LIGHT_HUNTER = 0;
		int BASE_UNIT_HEAVY_HUNTER = 0;
		int BASE_UNIT_BATTLE_SHIP = 0;
		int BASE_UNIT_ARMORED_SHIP = 0;
		int BASE_UNIT_MISSILE_LOUNCHER = 0;
		int BASE_UNIT_ION_CANNON = 0;
		int BASE_UNIT_PLASMA_CANNON = 0;
		
		// Para no gastar el metal al inciiar partida
		int dinero = enemyPlanet.metal;
		
		// Mientras las reservas de Metal esten x encima del 20% puedes gastar  o 50.000 (REVISAR*)
		
		while ( dinero > (METAL_BASE_ENEMY_ARMY*0.20) ) {
			
			// Mientras puedas comprar la tropa más barata continua
			if (dinero < METAL_COST_LIGTHHUNTER) {
			
				float num = (float)(Math.random() * 13);
				// Flota
				if (num <= 3.5) {
					BASE_UNIT_LIGHT_HUNTER += 1;
					dinero -= METAL_COST_LIGTHHUNTER;
					
				}else if (num > 3.5 && num <= 6.0) {
					BASE_UNIT_HEAVY_HUNTER += 1;
					dinero -= METAL_COST_HEAVYHUNTER;
				
				}else if (num > 6.0 && num <= 8.0) {
					BASE_UNIT_BATTLE_SHIP += 1;
					dinero -= METAL_COST_BATTLESHIP;
					
				}else if (num > 8.0 && num <= 10.0) {
					BASE_UNIT_ARMORED_SHIP += 1;
					dinero -= METAL_COST_ARMOREDSHIP;
					
				}// Defensas ( enemigo tiene??**)
				else if (num > 10.0 && num <= 11.0) {
					BASE_UNIT_MISSILE_LOUNCHER += 1;
					dinero -= METAL_COST_MISSILELAUNCHER;
					
				}else if (num > 11.0 && num <= 12.0) {
					BASE_UNIT_ION_CANNON += 1;
					dinero -= METAL_COST_IONCANNON;
					
				}else if (num > 12.0 && num <= 13.0) {
					BASE_UNIT_PLASMA_CANNON += 1;
					dinero -= METAL_COST_PLASMACANNON;
				}
			}

		}
//		System.out.println("metal = " + dinero);
		
		// Añadir plus de tecnologia por cada creacion de ejercito
		
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
		Clases_defensa d = new Clases_defensa();
		
		ArrayList<MilitaryUnit> arrayMissileLouncher = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_MISSILE_LOUNCHER; i++) {
			arrayMissileLouncher.add(d.new MissileLauncher(ARMOR_MISSILELAUNCHER, BASE_DAMAGE_MISSILELAUNCHER));
		}
		ArrayList<MilitaryUnit> arrayIonCannon = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_ION_CANNON; i++) {
			arrayIonCannon.add(d.new IonCannon(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
		}
		ArrayList<MilitaryUnit> arrayPlasmaCannon = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_PLASMA_CANNON; i++) {
			arrayPlasmaCannon.add(d.new PlasmaCannon(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
		}
		
		enemyArmy[0] = arrayLigthHunter;
		enemyArmy[1] = arrayHeavyHunter;
		enemyArmy[2] = arrayBattleShip;
		enemyArmy[3] = arrayArmoredShip;
		
		enemyArmy[4] = arrayMissileLouncher;
		enemyArmy[5] = arrayIonCannon;
		enemyArmy[6] = arrayPlasmaCannon;
		
		enemyPlanet.setArmy(enemyArmy);
		System.out.println("Longitud flota enemiga = " + enemyArmy.length);
		
	}
	
	public void ViewThreat() {
		// Ver la nueva amenaza 
//		NEW THREAT COMING
//		Ligth Hunter 16
//		Heavy Hunter 12
//		Battle Ship 1
//		Armored Ship 1
		
		
		// Me llaman desde la opc 5 del menu
		// Miro la army actual del ejercito enemigo desde un objeto Battle
		
		Battle b = new Battle();
		ArrayList<MilitaryUnit> enemyArray = b.getEnemyArmy();
		// ACABAR *******
		String datos = String.format("NEW THREAT COMING\n"
				   + "\nLigth Hunter%14d\n"
				   + "\nHeavy Hunter%12d\n"
				   + "\nBattle Ship%14d\n"
				   + "\nArmored Ship%14d\n",
				   )
	}
}
