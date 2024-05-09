import java.util.ArrayList;
import java.util.Scanner;
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
			
			 
			Planet mainPlanet = new Planet(0,
					0,
					METAL_BASE_ENEMY_ARMY, 
					DEUTERIUM_BASE_ENEMY_ARMY,
					UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
					UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
			
			// Me crea mi ejercito y se lo añade al planeta
			createMyArmyInit(mainPlanet);
			
			
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
			
			mainPlanet.printStats();
			
			try {
				mainPlanet.newBattleShip(10);
			}catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			
			mainPlanet.printStats();
//			Battle b = new Battle();
			ArrayList[][] army = {mainPlanet.getArmy(), createEnemyArmy()};
			b.setArmies(army);
//			ViewThreat(b);
			
			
			
	}
	
	public static void createMyArmyInit(Planet myPlanet) {
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
		
		Clases_ataque cAtack = new Clases_ataque();
		// Flota
		ArrayList<MilitaryUnit> arrayLigthHunter = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_LIGHT_HUNTER; i++) {
			arrayLigthHunter.add(cAtack.new LigthHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
		}
		ArrayList<MilitaryUnit> arrayHeavyHunter = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_HEAVY_HUNTER; i++) {
			arrayHeavyHunter.add(cAtack.new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
		}
		ArrayList<MilitaryUnit> arrayBattleShip = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_BATTLE_SHIP; i++) {
			arrayBattleShip.add(cAtack.new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
		}
		
		ArrayList<MilitaryUnit> arrayArmoredShip = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_ARMORED_SHIP; i++) {
			arrayArmoredShip.add(cAtack.new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
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
	}

	public static ArrayList<MilitaryUnit>[]  createEnemyArmy() {
		
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
		Clases_ataque cAtack = new Clases_ataque();
		ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[7];
		//*** UNIDADES DE BASE EN MI EJERCITO ***
		int BASE_UNIT_LIGHT_HUNTER = 0;
		int BASE_UNIT_HEAVY_HUNTER = 0;
		int BASE_UNIT_BATTLE_SHIP = 0;
		int BASE_UNIT_ARMORED_SHIP = 0;

		
		// Para no gastar el metal al iniciar partida
		int dinero = METAL_BASE_ENEMY_ARMY;
		
		// Mientras haya reservas de Metal  puedes gastar
		
		while ( dinero > (METAL_BASE_ENEMY_ARMY) ) {
			
			// Mientras puedas comprar la tropa más barata continua
			if (dinero > METAL_COST_LIGTHHUNTER) {
			
				float num = (float)(Math.random() * 10);
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
					
				}
				
			}
			
		}
//		System.out.println("metal = " + dinero);
		
		// Añadir plus de tecnologia por cada creacion de ejercito
		
		// Flota
		ArrayList<MilitaryUnit> arrayLigthHunter = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_LIGHT_HUNTER; i++) {
			arrayLigthHunter.add(cAtack.new LigthHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
		}
		ArrayList<MilitaryUnit> arrayHeavyHunter = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_HEAVY_HUNTER; i++) {
			arrayHeavyHunter.add(cAtack.new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
		}
		ArrayList<MilitaryUnit> arrayBattleShip = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_BATTLE_SHIP; i++) {
			arrayBattleShip.add(cAtack.new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
		}
		
		ArrayList<MilitaryUnit> arrayArmoredShip = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < BASE_UNIT_ARMORED_SHIP; i++) {
			arrayArmoredShip.add(cAtack.new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
		}
		
		enemyArmy[0] = arrayLigthHunter;
		enemyArmy[1] = arrayHeavyHunter;
		enemyArmy[2] = arrayBattleShip;
		enemyArmy[3] = arrayArmoredShip;
		
		//System.out.println("Longitud flota enemiga = " + enemyArmy.length);
		return enemyArmy;
	}
	
	public static void ViewThreat(Battle b) {
		
		// Me llaman desde la opc 5 del menu
		// Miro la army actual del ejercito enemigo desde un objeto Battle
		
		ArrayList<MilitaryUnit>[] enemyArray = b.getEnemyArmy();
		
		String datos = String.format("\nNEW THREAT COMING\n"
				   + "\nLigth Hunter%12d\n"
				   + "\nHeavy Hunter%12d\n"
				   + "\nBattle Ship%13d\n"
				   + "\nArmored Ship%12d\n"
				   +"\n",
				   enemyArray[0].size(), 
				   enemyArray[1].size(),
				   enemyArray[2].size(),
				   enemyArray[3].size());
		System.out.println(datos);
	}
	
	public static int askAmount() {
		Scanner sc = new Scanner(System.in);
		boolean amountOk = false;
		int amount = -1;
		
		do {
			System.out.println("Amount of Units\nAmount: >");
			try {
				amount = sc.nextInt();
				amountOk = true;
			}
			catch (Exception e) {
				System.out.println("Invalid Option");
				sc.nextLine();
			}
		}while(!amountOk);
		
		return amount;
	}

	
	public static void mainMenu(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		// Instanciamos la batalla
		Battle b = new Battle();
		// Set ejercitos en la battle
		ArrayList[][] army = {mainPlanet.getArmy(), createEnemyArmy()};
		b.setArmies(army);
		boolean attackComing = false;
		
		String mainMenu = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "0)Exit\n";
		
		String mainMenuAttack = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "5)View Thread Coming\n" + "0)Exit\n";
		
		// Bucle del menu 1
		int option = -1;
		while (option != 0) {
			if (attackComing) {
			System.out.println("\n" + mainMenuAttack);
			}else {
				System.out.println("\n" + mainMenu);
			}
			
			System.out.println("-->Option: ");

			try {
				option = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid Option");
				option = -1;
				sc.nextLine();
			}
			
			switch (option) {
			case 0:
				System.out.println("See you later!");
				break;
			
			case 1:
				System.out.println("Aqui van las Estadisticas del planeta");
				mainPlanet.printStats();
				break;
			
			case 2:
				System.out.println("Aqui va el menu de construcciones");
				subMenuBuilds(mainPlanet);
				break;
			
			case 3:
				System.out.println("Aqui va el menu de mejorar tecnologias");
				break;
				
			case 4:
				System.out.println("Aqui va el reporte de las batallas");
				break;
				
			case 5:
				if(attackComing) {
				System.out.println("Aqui va el reporte del ataque");
				ViewThreat(b);
				attackComing = false;
				}else {
					System.out.println("Option out of range");
				}
				break;

//			case 6:
//				attackComing = true;
//				System.out.println("Se ha cambiado el attackComing a true");
//				break;	
			default:
				System.out.println("Option out of range");
				sc.nextLine();
			}
		}
		
	}


	public static void subMenuBuilds(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		String menuBuildings = "Building Menu\n" + "1)Build Troops\n" + "2)Build Defenses\n" + "3)Go back";
		
		int option = -1;
		while (option != 3) {
			System.out.println("\n" + menuBuildings);
			
			System.out.println("-->Option: ");
			try {
				option = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid Option");
				option = -1;
			}
			
			switch(option) {
				
				case 1:
					subMenuBuildsTroops(mainPlanet);
					break;
				
				case 2:
					subMenuBuildsDefenses(mainPlanet);
					break;
				case 3:
					System.out.println("Going to the Main menu");
					break;
				
				default:
					System.out.println("Option not in range");
					sc.nextLine();
			}
		}
	}
	
	
	public static void subMenuBuildsTroops(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		String menuBuildTroops = "Menu Build Troops\n" + "1)Build Light Hunter\n" + "2)Build Heavy Hunter\n" 
				+ "3)Build Battle Ship\n" + "4)Build ArmoredShip\n" + "5)Go Back";
		
		int option = -1;
		int amount = -1;
		while (option != 5) {
			System.out.println("\n" + menuBuildTroops);
			
			System.out.println("-->Option: ");
			try {
				option = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid Option");
				option = -1;
			}
			
			switch(option) {
				case 1:
					amount = askAmount();
					try {
					mainPlanet.newLightHunter(amount);
					}catch (ResourceException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					amount = askAmount();
					try {
						mainPlanet.newHeavyHunter(amount);
					}catch (ResourceException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					amount = askAmount();

					try {
						mainPlanet.newBattleShip(amount);
					}catch (ResourceException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 4:
					amount = askAmount();
					try {
						mainPlanet.newArmoredShip(amount);
					}catch (ResourceException e) {
						System.out.println(e.getMessage());
					}
					break;
			
				case 5:
					System.out.println("Going Back");
					break;
				
				default:
					System.out.println("Option not in range");
					sc.nextLine();
					
			}
		}
	}
	
	
	public static void subMenuBuildsDefenses(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		String menuBuildDefenses = "Menu Build Defenses\n" + "1)Build Missile Launcher\n" + "2)Build Ion Cannon\n" 
				+ "3)Build Plasma Cannon\n" + "4)Go Back";
		
		int option = -1;
		int amount = -1;
		while (option != 4) {
			System.out.println("\n" + menuBuildDefenses);
			
			System.out.println("-->Option: ");
			try {
				option = sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid Option");
				option = -1;
			}
			
			switch(option) {
				case 1:
					amount = askAmount();
					// INSERTAR METODO DE CREAR Missile Launcher
					break;
					
				case 2:
					amount = askAmount();
					// INSERTAR METODO DE CREAR Ion Cannon
					break;
					
				case 3:
					amount = askAmount();
					// INSERTAR METODO DE CREAR Plasma Cannon
					break;
					
				case 4:
					System.out.println("Going Back");
					break;
					
				default:
					System.out.println("Option not in range");
					sc.nextLine();
					
			}
		}
}

}