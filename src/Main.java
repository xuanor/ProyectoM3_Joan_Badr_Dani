import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main implements Variables{
	private boolean attackComing = false;
	
	String userMenu = "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::⠀\r\n"
			+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::: ⢠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "::'#######:::'######::::::'###::::'##::::'##:'########:⠀⣷⣶⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ ":'##.... ##:'##... ##::::'## ##::: ###::'###: ##.....:: ⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ ": ##:::: ##: ##:::..::::'##:. ##:: ####'####: ##:::::::⠀⣿⣿⣿⣿⣿⣿⣧⡀⠤⠤⣤⣤⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ ": ##:::: ##: ##::'####:'##:::. ##: ## ### ##: ######:::⠀⣿⣿⣿⣿⣿⣿⣿⣇⠀⣦⣤⣤⣄⣈⡉⠉⠛⠛⠷⢶⠄⢠⣴⣦⡀⠀⠀⠀⠀\r\n"
			+ ": ##:::: ##: ##::: ##:: #########: ##. #: ##: ##...:::: ⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠉⠉⠛⠛⠷⣦⣀⠀⠀⢻⣿⣿⣿⡀⠀⠀⠀\r\n"
			+ ": ##:::: ##: ##::: ##:: ##.... ##: ##:.:: ##: ##:::::::⠀⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⡆⠀⠀⠈⠉⠘⡇⠀⠀⠀\r\n"
			+ ":. #######::. ######::: ##:::: ##: ##:::: ##: ########:⠀⣿⣿⣿⣿⣿⣿⡟⠁⠀⠀⢀⠀⢀⣀⣠⣤⡴⠾⠋⠀⠀⠀⢀⣠⡾⠃⠀⠀⠀\r\n"
			+ "::.......::::......::::..:::::..::..:::::..::........::⠀⣿⣿⣿⣿⣿⣿⠶⠶⠶⠀⠿⠃⠘⠉⠉⠀⠀⢀⣀⣤⣴⠾⠛⠉⠀⠀⠀⠀⠀\r\n"
			+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::: ⣿⣿⣟⣉⣀⣀⣀⣀⣠⣤⣤⣤⣴⡶⠶⠿⠛⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::⠀⠛⠛⠋⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "                                                      ⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "                 .WELCOME TO THE SPACE ODYSSEY.                         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

			
	String dibujo2 = "                   \r\n\n"
			+ "                   ( )\r\n"
			+ "                    )\r\n"
			+ "                   ( )\r\n"
			+ "\r\n"
			+ "                  \\/ \\/\r\n"
			+ "                  |\\_/|\r\n"
			+ "                  '   '\r\n"
			+ "                  |. .|\r\n"
			+ "                  . o .\r\n"
			+ "                   |o|\r\n"
			+ "                   . .\r\n"
			+ "                    |\r\n"
			+ "               ____\r\n"
			+ "          .-'\"\"p 8o\"\"`-.\r\n"
			+ "       .-'8888P'Y.`Y[ ' `-.\r\n"
			+ "     ,']88888b.J8oo_      '`.\r\n"
			+ "   ,' ,88888888888[\"        Y`.\r\n"
			+ "  /   8888888888P            Y8\\\r\n"
			+ " /    Y8888888P'             ]88\\\r\n"
			+ ":     `Y88'   P              `888:\r\n"
			+ ":       Y8.oP '- >            Y88:\r\n"
			+ "|          `Yb  __             `'|\r\n"
			+ ":            `'d8888bo.          :\r\n"
			+ ":             d88888888ooo.      ;\r\n"
			+ " \\            Y88888888888P     /\r\n"
			+ "  \\            `Y88888888P     /\r\n"
			+ "   `.            d88888P'    ,'\r\n"
			+ "     `.          888PP'    ,'\r\n"
			+ "       `-.      d8P'    ,-'   \r\n"
			+ "          `-.,,_'__,,.-'";	
	
	
	String dibujo1 = "\n            `. ___\r\n"
			+ "                    __,' __`.                _..----....____\r\n"
			+ "        __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'\r\n"
			+ "  _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'\r\n"
			+ ",'________________                          \\`-._`-','\r\n"
			+ " `._              ```````````------...___   '-.._'-:\r\n"
			+ "    ```--.._      ,.                     ````--...__\\-.\r\n"
			+ "            `.--. `-`                       ____    |  |`\r\n"
			+ "              `. `.                       ,'`````.  ;  ;`\r\n"
			+ "                `._`.        __________   `.      \\'__/`\r\n"
			+ "                   `-:._____/______/___/____`.     \\  `\r\n"
			+ "                               |       `._    `.    \\\r\n"
			+ "                               `._________`-.   `.   `.___\r\n"
			+ "                                                  `------'`";
	
	public void setAttackComing(boolean flag) {
		this.attackComing = flag;
	}
	
	public boolean getAttackComing() {
		return this.attackComing;
	}
	
	public static void main(String[] args) {
		int[] DBreasources;
		// Instancio clase principal
		Main principal = new Main();
		//Cargar datos de la bbdd
		ConnectionDB cdb = new ConnectionDB();
		
		boolean start = principal.menuUser(cdb);
		
		// EMPIEZA EL JUEGO SI INTRODUCES UN USER VALIDO
		if (start) {
			cdb.conection(2, null, null, null, null);
			
			// PULL
			DBreasources = cdb.getArrayReasources().get(0);
			// Cargar array de Reportes de Batalla
			Battle b = new Battle();
			b.setBattleStats(cdb.getArrayReportesBatalla());
			
			// Cargar datos aqui
			Planet mainPlanet = new Planet(DBreasources[2],
					DBreasources[3],
					DBreasources[0], 
					DBreasources[1],
					UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST,
					UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST);	
			
			
			
			// Me crea mi ejercito y se lo añade al planeta
			principal.createMyArmyInit(mainPlanet, cdb);
			
			
			
			principal.mainMenu(mainPlanet, b);
			
			
			// PUSH
			cdb.conection(3, mainPlanet, b, null, null);
		}
		else {
			System.out.println("\nToo many tries, exit.");
		}
	}
	
	// MENU USUARIOS
	public boolean menuUser(ConnectionDB cdb ) {

		Scanner sc = new Scanner(System.in);
		boolean checkUsr = false;
		boolean result = false;
		
		
		// TENGO 5 INTENTOS
		for (int intento= 0; intento < 5; intento++) {
			System.out.println(userMenu);

			System.out.println("\n>>> USER: ");
			String user = sc.next();
			
			System.out.println("\n>>> PASS: ");
			String pswd = sc.next();
			// Check del usuario
			cdb.conection(1, null, null, user, pswd);
			
			if (cdb.getUser_id() == -1) {
				System.out.println("INCORRECT USER OR PASSWORD, " + (4-intento) + " TRIES LEFT, TRY AGAIN.");
				
			}
			// LOGIN CORRECTO, SALGO
			else {
				result = true;
				break;
			}
			sc.nextLine();
		}
		return result;
	}
	// CREO MI EJERCITO INICIAL

	public void createMyArmyInit(Planet myPlanet, ConnectionDB cdb) {
		ArrayList<MilitaryUnit>[] mainArmy = new ArrayList[7];
		
		//*** UNIDADES DE BASE EN MI EJERCITO ***
//		final int BASE_UNIT_LIGHT_HUNTER = 15;
//		final int BASE_UNIT_HEAVY_HUNTER = 5;
//		final int BASE_UNIT_BATTLE_SHIP = 0;
//		final int BASE_UNIT_ARMORED_SHIP = 1;
//		final int BASE_UNIT_MISSILE_LOUNCHER = 10;
//		final int BASE_UNIT_ION_CANNON = 2;
//		final int BASE_UNIT_PLASMA_CANNON = 0;
		
		ArrayList<int[]> statsHeavytHunter = cdb.getArrayLightHunter();
		ArrayList<int[]> statsLightHunter = cdb.getArrayHeavytHunter();
		ArrayList<int[]> statsBattleShip = cdb.getArrayBattleShip();
		ArrayList<int[]> statsArmoredShip = cdb.getArrayArmoredShip();
		ArrayList<int[]> statsMissileLouncher = cdb.getArrayMissileLouncher();
		ArrayList<int[]> statsIonCannon = cdb.getArrayIonCannon();
	    ArrayList<int[]> statsPlasmaCannon = cdb.getArrayPlasmaCannon();
	    
//	    System.out.println("Prueba = " +  statsHeavytHunter.size());
//	    
//		for (int[] i : statsHeavytHunter) {
//			for (int j : i) {
//				System.out.println(j);
//			}
//			
//		}
	    
		Clases_ataque cAtack = new Clases_ataque();
		// Flota
		ArrayList<MilitaryUnit> arrayLigthHunter = new ArrayList<MilitaryUnit>();
		// myPlanet.newLightHunter(1) hacer asi con nivel de tech ??
		for (int i = 0; i < statsLightHunter.size(); i++) {
			arrayLigthHunter.add(cAtack.new LigthHunter(statsLightHunter.get(i)[0], statsLightHunter.get(i)[1]));
		}
		ArrayList<MilitaryUnit> arrayHeavyHunter = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < statsHeavytHunter.size(); i++) {
			arrayHeavyHunter.add(cAtack.new HeavyHunter(statsHeavytHunter.get(i)[0], statsHeavytHunter.get(i)[1]));
		}
		ArrayList<MilitaryUnit> arrayBattleShip = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < statsBattleShip.size(); i++) {
			arrayBattleShip.add(cAtack.new BattleShip(statsBattleShip.get(i)[0], statsBattleShip.get(i)[1]));
		}
		
		ArrayList<MilitaryUnit> arrayArmoredShip = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < statsArmoredShip.size(); i++) {
			arrayArmoredShip.add(cAtack.new ArmoredShip(statsArmoredShip.get(i)[0], statsArmoredShip.get(i)[1]));
		}
		// Defensas
		Clases_defensa d = new Clases_defensa();
		
		ArrayList<MilitaryUnit> arrayMissileLouncher = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < statsMissileLouncher.size(); i++) {
			arrayMissileLouncher.add(d.new MissileLauncher(statsMissileLouncher.get(i)[0], statsMissileLouncher.get(i)[1]));
		}
		ArrayList<MilitaryUnit> arrayIonCannon = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < statsIonCannon.size(); i++) {
			arrayIonCannon.add(d.new IonCannon(statsIonCannon.get(i)[0], statsIonCannon.get(i)[1]));
		}
		ArrayList<MilitaryUnit> arrayPlasmaCannon = new ArrayList<MilitaryUnit>();
		for (int i = 0; i < statsPlasmaCannon.size(); i++) {
			arrayPlasmaCannon.add(d.new PlasmaCannon(statsPlasmaCannon.get(i)[0], statsPlasmaCannon.get(i)[1]));
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
	public  ArrayList<MilitaryUnit>[] createEnemyArmy() {
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
		
		// Mientras haya reservas de Metal  puedes gastar ** AÑADIR DEUTERIO
		
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
		//System.out.println("Longitud flota enemiga = " + enemyArmy[3].size());
		return enemyArmy;
	}
	
	// VER EL EJERCITO QUE TE AMENAZA
	public  void ViewThreat(ArrayList<MilitaryUnit>[] enemyArray) {
		
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

	
	// METODO DE APOYO PARA INTRODUCIR UN ENTERO
	public  int askAmount() {
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
	public  void mainMenu(Planet mainPlanet, Battle b) {
		boolean AtackFlag;
		// Instanciamos la batalla
		//Battle b = new Battle();
		
		// Set reportes de batalla BBDD
		
		// Set ejercitos en la battle
		b.setPlanetArmy(mainPlanet.getArmy());
		Timer timer = new Timer();
	    TimerTask taskThreat = new TimerTask() {
	    

	         public void run() {
	        	 System.out.println("\n\nNEW THREAD IS COMMING" + dibujo1);
	        	 // Creo el nuevo ejercito enemigo
	        	 ArrayList<MilitaryUnit>[] army = createEnemyArmy();
	        	 // Añades al obj batalla la army enemiga
	        	 b.setEnemyArmy(army);
	        	 setAttackComing(true);
	             //ViewThreat(army);

	         }

	    };
	    
	    TimerTask taskAtack = new TimerTask() {
		    

	         public void run() {
	        	 System.out.println("\n\nWE HAVE BEEN ATTACKED!!" + dibujo2);
	        	 b.batalla();
	        	 // Añado total a variable de planet para el push de BBDD
	        	 mainPlanet.setNumberUnits(b.getActualNumberUnitsPlanet());
	        	 // Le añado lo ganado a mis recursos (si no gano es(0,0))
//	        	 System.out.println(mainPlanet.getMetal());
//	        	 System.out.println(mainPlanet.getDeuterium());
	        	 mainPlanet.setMetal( mainPlanet.getMetal() + b.getWasteMetalDeuterium()[0]);
	        	 mainPlanet.setDeuterium(mainPlanet.getDeuterium() + b.getWasteMetalDeuterium()[1]);
//	        	 System.out.println(mainPlanet.getMetal());$
//	        	 System.out.println(mainPlanet.getDeuterium());$
//	        	 System.out.println("Ganancias añadidas !!");$
	         }

	    };
	    
	    TimerTask taskUpdateResources = new TimerTask() {
		    

	         public void run() {
	        	 //System.out.println("**Recursos aumentados**");
	        	 mainPlanet.setMetal((int)(mainPlanet.getMetal()*1.1));
	        	 mainPlanet.setDeuterium((int)(mainPlanet.getDeuterium()*1.1));
	         }

	    };

	    timer.schedule(taskThreat, 10000, 60000);
	    timer.schedule(taskAtack, 15000, 60000);
	    timer.schedule(taskUpdateResources, 60000, 60000);
		Scanner sc = new Scanner(System.in);
		
		String mainMenu = "\n********************************************************************\n"
				+ "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "0)Exit\n";
		
		String mainMenuAttack = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "5)View Thread Coming\n" + "0)Exit\n";
		
		// Bucle del menu 1
		int option = -1;
		while (option != 0) {
			
			if (this.attackComing) {
			System.out.println("\n" + mainMenuAttack);
			}else {
				System.out.println("\n" + mainMenu);
			}
			// No se muestra el menu nuevo si esta escuhando el scanner**
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
				// Apgo el timer
				timer.cancel();
				break;
			
			case 1:
				System.out.println("Aqui van las Estadisticas del planeta");
				mainPlanet.printStats();
				break;
			
			case 2:
				System.out.println("Aqui va el menu de construcciones");
				this.subMenuBuilds(mainPlanet);
				break;
			
			case 3:
				System.out.println("Aqui va el menu de mejorar tecnologias");
				this.subMenuUpgradeTechnology(mainPlanet);
				break;
				
			case 4:
				//System.out.println("Aqui va el reporte de las batallas");
				boolean checkOpc = false;
				boolean exit = false;
				
				int opc = -1;
				while (!checkOpc) {
					System.out.println("Option >  (Exit -1)");
					try {
						opc = sc.nextInt();
					}
					catch (Exception e) {
						System.out.println("Invalid Option");
					}
					if (opc == -1) {
						checkOpc = true;
						exit = true;
						
					}
					if (opc >= b.getBattleStats().size() || opc < 0) {
						System.out.println("Option out of range");
					}else {
						checkOpc = true;
					}
				}
				if (! exit) {
					// Si hay reportes
					//&& b.getBattleStats().size()+1 < 6  
					if (b.getBattleStats().size() > 0 ) {
						System.out.println(b.getBattleStats().get(opc)[0]);
					
						// Pregunta para ver el informe paso a paso
						boolean check = false;
					
					    while (! check ) {
					    	System.out.println("\nView Battle development?(S\\n)");
					    	String imp = sc.next().toUpperCase();
					    	if (imp.equals("S")) {
					    		check = true;
					    		System.out.println(b.getBattleStats().get(opc)[1]);
					    	}
					    	else if (imp.equals("N")) {
					    		check = true;
					    		System.out.println("No quieres ver el informe");
					    	
					    	}else {
					    		sc.nextLine();
					    		System.out.println("Only options (S\\n) are allowed");
					    	}
					    }
					}
					else {
						System.out.println("\nYou don't have any battle report available.");
					}
				}
				break;
				
			case 5:
				if(attackComing) {
				System.out.println("Aqui va el reporte del ataque");
				this.ViewThreat(b.getEnemyArmy());
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
		sc.close();
	}

	// SUB MENU DE CONSTRUCCIONES
	public void subMenuBuilds(Planet mainPlanet) {
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
					this.subMenuBuildsTroops(mainPlanet);
					break;
				
				case 2:
					this.subMenuBuildsDefenses(mainPlanet);
					break;
				case 3:
					System.out.println("Going to the Main menu");
					break;
				
				default:
					System.out.println("Option not in range");
					sc.nextLine(); 
			}
		}
		//sc.close();
	}
	
	// SUB MENU DE CREACION DE UNIDADES DE COMBATE
	public void subMenuBuildsTroops(Planet mainPlanet) {
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
		//sc.close();
	}
	
	// SUB MENU DE CREACION DE UNIDADES DE DEFENSA
	public void subMenuBuildsDefenses(Planet mainPlanet) {
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
		//sc.close();
}
	
	// SUB MENU DE MEJORA DE TECNOLOGIAS
	public void subMenuUpgradeTechnology(Planet mainPlanet) {
		Scanner sc = new Scanner(System.in);
		
		
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
			
			String deuteriumResources = "Deuterium Resources = " + mainPlanet.getDeuterium();
			String menuBuildUpgradeTechnology = infoTechnology + options + deuteriumResources ;
			
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
						System.out.println("\nDefense technology upgraded");
					}catch (ResourceException e) {
						e.getMessage();
					}
					break;
				
				case 2:
					try {
						mainPlanet.upgradeTechnologyAttack(costeUpAtt);
						System.out.println("\nAttack technology upgraded");
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
		//sc.close();
	}
	
	
}