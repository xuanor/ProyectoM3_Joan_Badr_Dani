import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu implements Variables{
	
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
	public static void main(String[] args) {
		
		Planet mainPlanet = new Planet(0,
				0,
				METAL_BASE_ENEMY_ARMY, 
				DEUTERIUM_BASE_ENEMY_ARMY,
				UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
				UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);
		
		createMyArmy(mainPlanet);
		
		mainMenu(mainPlanet);
		
	}
	public static void mainMenu(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		boolean attackComing = false;
		
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
				subMenuBuilds();
				break;
			
			case 3:
				System.out.println("Aqui va el menu de mejorar tecnologias");
				break;
				
			case 4:
				System.out.println("Aqui va el reporte de las batallas");
				break;
				
				
				// ESTO HAY QUE MODIFICARLO NO ESTA BIEN!
			case 5:
				if(attackComing) {
				System.out.println("Aqui va el reporte del ataque");
				attackComing = false;
				}
				break;

			case 6:
				attackComing = true;
				System.out.println("Se ha cambiado el attackComing a true");
				break;
			
			default:
				System.out.println("Option not in range");
				sc.nextLine();
			}
		}
		
	}

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
				sc.nextLine();
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
				sc.nextLine();
			}
			
			switch(option) {
				case 1:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
					// INSERTAR METODO DE CREAR Light Hunters
					break;
					
				case 2:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
					// INSERTAR METODO DE CREAR Heavy Hunters
					break;
					
				case 3:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
					// INSERTAR METODO DE CREAR Battle Ships
					break;
					
				case 4:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
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
				sc.nextLine();
			}
			
			switch(option) {
				case 1:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
					// INSERTAR METODO DE CREAR Missile Launcher
					break;
					
				case 2:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
					// INSERTAR METODO DE CREAR Ion Cannon
					break;
					
				case 3:
					System.out.println("Amount of Units\nAmount: >");
					amount = sc.nextInt();
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
