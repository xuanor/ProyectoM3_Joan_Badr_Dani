
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
			
			//ViewThreat(createEnemyArmy());
			
			//mainPlanet.printStats();
			mainMenu(mainPlanet);
			
	}
	
	// CREO MI EJERCITO INICIAL
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

	// CREO EJRCITO ENEMIGA
	public static ArrayList<MilitaryUnit>[] createEnemyArmy() {
		// Camabiar metodo a boolean ???
		Battle b = new Battle();
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
		
		while ( dinero > (METAL_COST_LIGTHHUNTER) ) {
			
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
		
//		System.out.println("Hola " + BASE_UNIT_LIGHT_HUNTER + 
//				BASE_UNIT_HEAVY_HUNTER +
//				BASE_UNIT_BATTLE_SHIP +
//			BASE_UNIT_ARMORED_SHIP);
		enemyArmy[0] = arrayLigthHunter;
		enemyArmy[1] = arrayHeavyHunter;
		enemyArmy[2] = arrayBattleShip;
		enemyArmy[3] = arrayArmoredShip;
		
		b.setEnemyArmy(enemyArmy);
		System.out.println("Longitud flota enemiga = " + enemyArmy[3].size());
		return enemyArmy;
		//return b;
	}
	
	// VER EL EJERCITO QUE TE AMENAZA
	public static void ViewThreat(ArrayList<MilitaryUnit>[] enemyArray) {
		
		// Me llaman desde la opc 5 del menu
		// Miro la army actual del ejercito enemigo desde un objeto Battle
//		ArrayList<MilitaryUnit>[] enemyArray = new ArrayList[7];
//		enemyArray = b.getEnemyArmy();
		
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
	
	
	public static void amenazaAutomatica(Battle b) {
		
//		boolean AtackFlag;
		Timer timer = new Timer();
	    TimerTask taskThreat = new TimerTask() {
	    

	         public void run() {
	        	 System.out.println("··· Nueva amenaza ···");
	        	 // Creo el nuevo ejercito enemigo
	        	 ArrayList<MilitaryUnit>[] army = createEnemyArmy();
	        	 // Añades al obj batalla la army enemiga
	        	 b.setEnemyArmy(army);
	             ViewThreat(army);

	         }

	    };
	    
	    TimerTask taskAtack = new TimerTask() {
		    

	         public void run() {
	        	 System.out.println("··· Te acaban de atacar ···");
	        	 // Continuar ***
	        	 batalla(b);
	         }

	    };

	    timer.schedule(taskThreat, 9000, 100000);
	    timer.schedule(taskAtack, 10000, 8000);
	   
	}
	
	// METODO DE APOYO PARA INTRODUCIR UN ENTERO
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
	
	// MENU PRINCIPAL
	public static void mainMenu(Planet mainPlanet) {
		boolean attackComing = false;
		Scanner sc = new Scanner(System.in);
		// Instanciamos la batalla
		Battle b = new Battle();
		// Set ejercitos en la battle
		//ArrayList[][] army = {mainPlanet.getArmy(), createEnemyArmy()};
		b.setPlanetArmy(mainPlanet.getArmy());
		
		// Activa los avisos de amenaza
		amenazaAutomatica(b);
		
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
				subMenuUpgradeTechnology(mainPlanet);
				break;
				
			case 4:
				System.out.println("Aqui va el reporte de las batallas");
				// CONTINUAR **
				break;
				
			case 5:
				if(attackComing) {
				System.out.println("Aqui va el reporte del ataque");
				//ViewThreat(b);
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

	// SUB MENU DE CONSTRUCCIONES
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
	
	// SUB MENU DE CREACION DE UNIDADES DE COMBATE
	public static void subMenuBuildsTroops(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		String menuBuildTroops = "Menu Build Troops\n" + "1)Build Light Hunter\n" + "2)Build Heavy Hunter\n" 
				+ "3)Build Battle Ship\n" + "4)Build ArmoredShip\n" + "5)Go Back";
		
		int amount;
		int option = -1;
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
					}catch (BuildException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					amount = askAmount();
					try {
						mainPlanet.newHeavyHunter(amount);
					}catch (BuildException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					amount = askAmount();

					try {
						mainPlanet.newBattleShip(amount);
					}catch (BuildException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 4:
					amount = askAmount();
					try {
						mainPlanet.newArmoredShip(amount);
					}catch (BuildException e) {
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
	
	// SUB MENU DE CREACION DE UNIDADES DE DEFENSA
	public static void subMenuBuildsDefenses(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		String menuBuildDefenses = "Menu Build Defenses\n" + "1)Build Missile Launcher\n" + "2)Build Ion Cannon\n" 
				+ "3)Build Plasma Cannon\n" + "4)Go Back";
		
		int amount;
		int option = -1;
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
					try {
					mainPlanet.newMissileLauncher(amount);
					}catch (BuildException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 2:
					amount = askAmount();
					try {
					mainPlanet.newIonCannon(amount);
					}catch (BuildException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					amount = askAmount();
					try {
					mainPlanet.newPlasmaCannon(amount);
					}catch (BuildException e) {
						System.out.println(e.getMessage());
					}
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
	public static void subMenuUpgradeTechnology(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		String infoTechnology = String.format("Upgrade Technology\n"
											+ "Actual Defense Technology:%14d\n"
											+ "Actual Attack Technology:%15d\n\n", 
											mainPlanet.technologyDefense, mainPlanet.technologyAtack);
		
		String options = "1)Upgrade Defense Technology. Cost: "
		+ mainPlanet.upgradeDefenseTechnologyDeuteriumCost 
		+ " Deuterium\n"
	    + "2)Upgrade Defense Technology. Cost: "
		+ mainPlanet.upgradeDefenseTechnologyDeuteriumCost 
		+ " Deuterium\n"
	    + "3)Go Back\n\n";
		
		String deuteriumResources = "Deuterium Resources = " + mainPlanet.deuterium;
		String menuBuildUpgradeTechnology = infoTechnology + options + deuteriumResources;
		
		// Calculo de lo que aumenta el coste de subir de nivel la def tech 
		//(** Mirar de ponerlo en una varible en otro lado **) CONTINUAR!!
		int costeUpDef = UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
		for (int i = 0; i < mainPlanet.technologyDefense; i++) {
			
			costeUpDef += (costeUpDef * (UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST / 100));
		}
		
		// Calculo de lo que aumenta el coste de subir de nivel la attack tech
		int costeUpAtt = UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
		for (int i = 0; i < mainPlanet.technologyAtack; i++) {
			
			costeUpAtt += (costeUpAtt * (UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST / 100));
		}
		
		int option = -1;
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
					try {
						mainPlanet.upgradeTechnologyDefense(costeUpDef);
					}catch (ResourceException e) {
						e.getMessage();
					}
					break;
				
				case 2:
					try {
						mainPlanet.upgradeTechnologyAttack(costeUpAtt);
					}catch (ResourceException e) {
						e.getMessage();
					}
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
	
	// MECANICA BATALLA
	public static void batalla(Battle b) {
		// El obj battle que he ido pasando desde mainMenu
		ArrayList<MilitaryUnit>[] mainArmy, enemyArmy;
		mainArmy = b.getPlanetArmy();
		enemyArmy = b.getEnemyArmy();
		
		// --Escojer quien ataca primero--
		// Algoritmo para escojer atacante (variable chance_...)
		// Algoritmo para escojer defensor (variable chance_...)
		
		// ** ATACANTE **
		int [] chanceEnenmy = CHANCE_ATTACK_ENEMY_UNITS;
		int [] chanceMyArmy = CHANCE_ATTACK_PLANET_UNITS;
		boolean chanceAttack = false;
		boolean playBattle = true;
		while (playBattle) {
			// Aqui guardo el att y el def de cada jugada
			ArrayList<MilitaryUnit> attDef= new ArrayList<MilitaryUnit>();
			int randomNum = (int)(Math.random()*100);
			int sumTotal = 0;
			int cont = 0;
			
			// Ecoger grupo atack
			for (int i = 0;i< chanceEnenmy.length;i++) {
				sumTotal += chanceEnenmy[i];
				
				if (sumTotal < randomNum) {
					cont += i;
				}
			}System.out.println("cont1 = "+ cont);
			// ***
			//cont = chanceEnenmy.length-1 - cont;
			
			if (enemyArmy[cont].size() > 0) {
				randomNum = (int)(Math.random()*(enemyArmy[cont].size()));
				//Comporbar que ese arraylist tiene tantas posiciones. **
				attDef.add(enemyArmy[cont].get(randomNum));
				System.out.println("RandomNum1 = "+randomNum);
				//System.out.println(attDef.get(0));
				chanceAttack = true;
			}	
			
			// Si el primer calculo fue bien continuar sino, se repetira el bucle
			if (chanceAttack) {
				sumTotal = 0;
				for (int i= 0; i< mainArmy.length;i++) {
					sumTotal += mainArmy[i].size();
				
					}
				// ** DEFENSOR ** !!!!
				// Actualizo los porcentajes en funcion de mis topas actuales
				// Calcular que porcentaje representa cada unidad en el army
				//100*(Cantidad de cazadores ligeros ) / (total de unidades) = 9000/200 = 45 %
				for (int i= 0; i< CHANCE_ATTACK_PLANET_UNITS.length; i++) {
					int percent = (int)(100*(mainArmy[i].size()) / (sumTotal));
					chanceMyArmy[i] = percent;
					System.out.print(chanceMyArmy[i] + " ");
				}
				
				// Por ultimo escojeremos que unidad sera el defensor dentro de ese grupo
				// EJERCITO > UNIDADES > NAVE
				randomNum = (int)(Math.random()*100);
				cont = 0;
				// Ecoger grupo def
				for (int i = 0; i< chanceMyArmy.length;i++) {
					sumTotal += chanceMyArmy[i];
					if (sumTotal < randomNum) {
						cont += i;
					}
				}
				
				System.out.println("Contador " + (cont));
				if (mainArmy[cont].size() > 0) {	
				randomNum = (int)(Math.random()*(mainArmy[cont].size()));
					System.out.println("RandomNum2 = "+ randomNum);
					attDef.add(mainArmy[cont].get(randomNum));
					// Enemigo nos ataca
					System.out.println(attDef.get(1));
				}
			
			// Atacante resta a defensa lo que tiene de poder de ataque
			// Hasta 0 o -0, que se eliminara
			while (attDef.get(1).getActualArmor() > 0 &&  attDef.get(0).getActualArmor() > 0) {
				// Respondemos al enemigo
				attDef.get(0).tekeDamage(attDef.get(1).attack());
				attDef.get(1).tekeDamage(attDef.get(0).attack());
				if ( attDef.get(1).getActualArmor() <= 0 ||  attDef.get(0).getActualArmor() <= 0) {
					System.out.println("===game finished===");
					playBattle = false;
				}
			}
			
			// Antes de eliminarla, comprobaremos si genera residuos, la probabilidad de generar residuos está
			//definida en la interfaz Variables, por ejemplo, int CHANCE_GENERATNG_WASTE_LIGTHHUNTER = 55
			// Si generar_residuo = true entonces se recuepera un 70%  (PERCENTATGE_WASTE) del coste de la unidad
		}
		}
	}
}