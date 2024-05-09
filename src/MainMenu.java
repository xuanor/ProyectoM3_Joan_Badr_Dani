import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu implements Variables{
	
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
		//System.out.println("Longitud = " + mainArmy.length);
	}
	public static void main(String[] args) {
		
		Planet mainPlanet = new Planet(0,
				0,
				METAL_BASE_ENEMY_ARMY, 
				DEUTERIUM_BASE_ENEMY_ARMY,
				UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
				UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
		
		createMyArmyInit(mainPlanet);
		
		Battle b = new Battle();
		ArrayList[][] army = {mainPlanet.getArmy(), createEnemyArmy()};
		b.setArmies(army);	
		
		mainMenu(mainPlanet, b);
		
	}
	
	public static void mainMenu(Planet mainPlanet, Battle b) {
		Scanner sc = new Scanner(System.in);
		boolean attackComing = true;
		
		String mainMenu = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "0)Exit\n";
		
		String mainMenuAttack = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "5)View Thread Coming\n" + "0)Exit\n";
		
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
				subMenuBuilds();
				break;
			
			case 3:
				System.out.println("Aqui va el menu de mejorar tecnologias");
				subMenuUpgradeTechnology(mainPlanet.technologyDefense, mainPlanet.technologyAtack, mainPlanet.deuterium, mainPlanet.upgradeDefenseTechnologyDeuteriumCost, mainPlanet.upgradeAttackTechnologyDeuteriumCost);
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
					System.out.println("Option not in range");
					sc.nextLine();
				}
				break;
				
			default:
				System.out.println("Option not in range");
				sc.nextLine();

			}
		}
		
	}

	// SUB MENU DE CONSTRUCCIONES
	public static void subMenuBuilds() {
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
					subMenuBuildsTroops();
					break;
				
				case 2:
					subMenuBuildsDefenses();
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

	// SUB MENU DE CREACION DE UNIDADES DE COMBATE
	public static void subMenuBuildsTroops() {
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
					// INSERTAR METODO DE CREAR Light Hunters
					break;
					
				case 2:
					amount = askAmount();
					// INSERTAR METODO DE CREAR Heavy Hunters
					break;
					
				case 3:
					amount = askAmount();
					// INSERTAR METODO DE CREAR Battle Ships
					break;
					
				case 4:
					amount = askAmount();
					// INSERTAR METODO DE CREAR Armored Ships
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
	
	// SUB MENU DE CREACION DE UNIDADES DE DEFENSA
	public static void subMenuBuildsDefenses() {
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

	// SUB MENU DE MEJORA DE TECNOLOGIAS
	public static void subMenuUpgradeTechnology(int defenseTechnology, int attackTechnology, int deuterium, int nextDefenseUpgradeCost, int nextAttackUpgradeCost) {
		Scanner sc = new Scanner(System.in);
		
		String infoTechnology = String.format("Upgrade Technology\n"
											+ "Actual Defense Technology:%14d\n"
											+ "Actual Attack Technology:%15d\n\n", 
											defenseTechnology, attackTechnology);
		
		String options = "1)Upgrade Defense Technology. Cost: "+ nextDefenseUpgradeCost + " Deuterium" + "\n" 
					   + "2)Upgrade Defense Technology. Cost: "+ nextAttackUpgradeCost + " Deuterium" + "\n"
					   + "3)Go Back\n\n";
		
		String deuteriumResources = "Deuterium Resources = " + deuterium;
		
		int option = -1;
		
		String menuBuildUpgradeTechnology = infoTechnology + options + deuteriumResources;
		
		while (option != 3) {
			System.out.println("\n" + menuBuildUpgradeTechnology + "\n-->Option");
			try {
				option = sc.nextInt();
			} 
			catch (Exception e) {
				System.out.println("Invalid Option");
				option = -1;
			}
			
			switch(option) {
				case 1:
					System.out.println();
					// AQUI VA EL METODO DE INCREMENTAR EL NIVEL DE TECNOLOGIA DE DEFENSA
					break;
				
				case 2:
					System.out.println();
					// AQUI VA EL METODO DE INCREMENTAR EL NIVEL DE TECNOLOGIA DE ATAQUE
					break;
					
				case 3:
					System.out.println("Going back");
					break;
					
				default:
					System.out.println("Option not in range");
					sc.nextLine();
			}
		}
	}
	
	// CREACION DE EJERCITO ENEMIGO
	public static ArrayList[] createEnemyArmy() {
		
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
//		int BASE_UNIT_MISSILE_LOUNCHER = 0;
//		int BASE_UNIT_ION_CANNON = 0;
//		int BASE_UNIT_PLASMA_CANNON = 0;
		
		// Para no gastar el metal al inciiar partida
		int dinero = METAL_BASE_ENEMY_ARMY;
		
		// Mientras las reservas de Metal esten x encima del 20% puedes gastar  o 50.000 (REVISAR*)
		
		while ( dinero > (METAL_BASE_ENEMY_ARMY*0.20) ) {
			
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
				
				
				// Defensas ( enemigo tiene??**)
//				else if (num > 10.0 && num <= 11.0) {
//					BASE_UNIT_MISSILE_LOUNCHER += 1;
//					dinero -= METAL_COST_MISSILELAUNCHER;
//					
//				}else if (num > 11.0 && num <= 12.0) {
//					BASE_UNIT_ION_CANNON += 1;
//					dinero -= METAL_COST_IONCANNON;
//					
//				}else if (num > 12.0 && num <= 13.0) {
//					BASE_UNIT_PLASMA_CANNON += 1;
//					dinero -= METAL_COST_PLASMACANNON;
//				}
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
		// Defensas
//		Clases_defensa d = new Clases_defensa();
//		
//		ArrayList<MilitaryUnit> arrayMissileLouncher = new ArrayList<MilitaryUnit>();
//		for (int i = 0; i < BASE_UNIT_MISSILE_LOUNCHER; i++) {
//			arrayMissileLouncher.add(d.new MissileLauncher(ARMOR_MISSILELAUNCHER, BASE_DAMAGE_MISSILELAUNCHER));
//		}
//		ArrayList<MilitaryUnit> arrayIonCannon = new ArrayList<MilitaryUnit>();
//		for (int i = 0; i < BASE_UNIT_ION_CANNON; i++) {
//			arrayIonCannon.add(d.new IonCannon(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
//		}
//		ArrayList<MilitaryUnit> arrayPlasmaCannon = new ArrayList<MilitaryUnit>();
//		for (int i = 0; i < BASE_UNIT_PLASMA_CANNON; i++) {
//			arrayPlasmaCannon.add(d.new PlasmaCannon(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
//		}
		
		enemyArmy[0] = arrayLigthHunter;
		enemyArmy[1] = arrayHeavyHunter;
		enemyArmy[2] = arrayBattleShip;
		enemyArmy[3] = arrayArmoredShip;
		
//		enemyArmy[4] = arrayMissileLouncher;
//		enemyArmy[5] = arrayIonCannon;
//		enemyArmy[6] = arrayPlasmaCannon;
		
		return enemyArmy;
	}
	
	// VER EL TAMAÑO DEL EJERCITO RIVAL
	public static void ViewThreat(Battle b) {
		// Ver la nueva amenaza 
//		NEW THREAT COMING
//		Ligth Hunter 16
//		Heavy Hunter 12
//		Battle Ship 1
//		Armored Ship 1
		
		
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
	
	// PREGUNTAR CANTIDAD DE TROPAS/DEFENSAS QUE SE QUIERE CREAR
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


}


