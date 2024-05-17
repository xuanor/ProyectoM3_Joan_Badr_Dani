
import java.util.ArrayList;


public class Battle implements Variables{
	// ***VARIABLES***
	
	// Para almacenar la flota de nuestro planeta
	private ArrayList<MilitaryUnit>[] planetArmy; 
	// Para almacenar la flota enemiga
	private ArrayList<MilitaryUnit>[] enemyArmy;
	// Fila 1 nuestro ejercito, fila 2 ejercito enemigo
	private ArrayList[][] armies = new ArrayList[2][];
	// Donde guardamos todo el desarrollo de la batalla paso a paso
	private String battleDevelopment;
	
	//	COSTE de metal de los ejercitos iniciales
	//	[[metal][deuterio],[metal][deuterio]] ,
	//	el 0 es mi ejercito el 1 los enemigos
	private int[][] initialCostFleet;
	
	// n inical de soldados x ejercito
	private int initialNumberUnitsPlanet, initialNumberUnitsEnemy;
	
	// Residuos generados en la batalla [metal, deuterio].***
	private int[] wasteMetalDeuterium;
	
	// Muertes x ejercicto
	private int[] enemyDrops, planetDrops = new int[7];
	
	// Array 2x3 perdidas de los 2 recursos
	// Fila 1 recursos de mi ejercito
	// Fila 2 recursos del otro ejercito 
	// recursos ponderados(con su valor) de los dos ejercitos
	
	// Calcular dienero de cada muerto despues de una batalla
	private int[][] resourcesLooses;
	
	// Array 2x7 
	// cada fila representa a un ejercito (0 y 1) 
	// cada columna representa un tipo de soldado y su cantidad incial (0-7)
	private int[][] initialArmies = new int[2][];
	
	// Tipos de unidades que hay ?? sin uso?
	private int[] actualNumberUnitsPlanet, actualNumberUnitsEnemy;

	// ***METODOS***
	public int getInitialNumberUnitsPlanet() {
		return initialNumberUnitsPlanet;
	}

	public void setInitialNumberUnitsPlanet(int initialNumberUnitsPlanet) {
		this.initialNumberUnitsPlanet = initialNumberUnitsPlanet;
		
	}

	public int getInitialNumberUnitsEnemy() {
		return initialNumberUnitsEnemy;
	}

	public void setInitialNumberUnitsEnemy(int initialNumberUnitsEnemy) {
		this.initialNumberUnitsEnemy = initialNumberUnitsEnemy;
		
	}

	public int[] getActualNumberUnitsPlanet() {
		return actualNumberUnitsPlanet;
	}

	public void setActualNumberUnitsPlanet(int[] actualNumberUnitsPlanet) {
		this.actualNumberUnitsPlanet = actualNumberUnitsPlanet;
	}

	public int[] getActualNumberUnitsEnemy() {
		return actualNumberUnitsEnemy;
	}

	public void setActualNumberUnitsEnemy(int[] actualNumberUnitsEnemy) {
		this.actualNumberUnitsEnemy = actualNumberUnitsEnemy;
	}
	
	// Devuelvo las % de escojer cada unidad de cada ejercito
	private int[] getChanceUnits(ArrayList<MilitaryUnit>[] army) {

		int[] chanceMyArmy = new int[7];
		
		if (!(army[4] == null)) {
			chanceMyArmy = CHANCE_ATTACK_ENEMY_UNITS;
			
		}
		else {
			// Calcular que porcentaje representa cada unidad en el army
			//100*(Cantidad de cazadores ligeros ) / (total de unidades) = 9000/200 = 45 %  (getInitialArmies()[0][i])
			
			for (int i= 0; i< chanceMyArmy.length; i++) {
				int percent = (int)(100*(armies[0][i].size()) / getInitialNumberUnitsPlanet());
				chanceMyArmy[i] = percent;
//				System.out.print(chanceMyArmy[i] + " * ");
			}
		}
		return chanceMyArmy;
	}
	
	
	//resumen, battles será el número de batallas que hayamos acumulado
	public String getBattleReport(int battles) {
		return "";
	}
	
	public ArrayList<MilitaryUnit>[] getPlanetArmy() {
		return planetArmy;
	}

	public void setPlanetArmy(ArrayList<MilitaryUnit>[] planetArmy) {
		this.planetArmy = planetArmy;
		this.armies[0] = planetArmy;
	}

	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}

	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
		this.armies[1] = enemyArmy;
	}

	public ArrayList[][] getArmies() {
		return armies;
	}

	public void setArmies(ArrayList[][] armies) {
		this.armies = armies;
		this.planetArmy = armies[0];
		this.enemyArmy = armies[1];
	}
	
	public int[][] getInitialArmies(){
		return initialArmies;
		
	}
	
	public void setInitialArmies(int[][] ints) {
		this.initialArmies = ints;
	}
	
	//  Mostrar batalla paso a paso.
	public int[] getEnemyDrops() {
		return enemyDrops;
	}

	public void setEnemyDrops(int[] ints) {
		this.enemyDrops = ints;
	}

	public int[] getPlanetDrops() {
		return planetDrops;
	}

	public void setPlanetDrops(int[] ints) {
		this.planetDrops = ints;
	}

	public String getBattleDevelopment() {
		return "";
	} 
	public void updateUnitDrops() {
		// tropas iniciales - tropas actuales
		int[] enemyDrops = new int[7];
		int[] planetDrops = new int[7];
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < getInitialArmies()[i].length; j ++) {
				
				if (i == 0) {
					planetDrops[j] = getInitialArmies()[i][j] - getArmies()[i][j].size();
					//System.out.println("\nPlanet drops = " + planetDrops[j] );
				}else {
					if (!(getArmies()[i][j] == null)) {
						enemyDrops[j] = getInitialArmies()[i][j] - getArmies()[i][j].size();
					}
					//System.out.println("\nEnemy drops = " + enemyDrops[j] );
				}
			}
		}
		
		setEnemyDrops(enemyDrops);
		setPlanetDrops(planetDrops);
	}
	 
	// Para generar el array de pérdidas.
	public void updateResourcesLooses() {
		
	} 
	
	// Para calcular costes de las flotas.*** Aqui
	public void fleetResourceCost(ArrayList<MilitaryUnit>[][] army) {
		
//		int[][] resourceLooses = new int[2][4];
//		int costeMetal = 0;
//		int costeDeuterio = 0;
//		int totalMetal = 0;
//		int totalDeuterio = 0;
//		int pos;
//		
//		// {perdidas metal planeta, perdidas deuterio planeta, perdidas metal planeta + 5* perdidas deuterio planeta}
//		if (army[4] == null) {
//			pos = 1;
//		}else {
//			pos = 0;
//		}
//		for (int j = 0; j < army[j].size(); j++) {
//			for (int i = 0; i < army[j].size(); i++) {
//				// Suma de cada unidad de un grupo
//				costeMetal += army[j].get(i).getDeuteriumCost();
//				costeDeuterio += army[j].get(i).getMetalCost();
//				//resourceLooses[pos];
//					
//			}// SUma de cada grupo
//			totalMetal += costeMetal;
//			totalDeuterio += costeDeuterio;
//		}
//		resourceLooses[pos][0] = totalMetal;
//		resourceLooses[pos][1] = totalDeuterio;
//		resourceLooses[pos][2] = totalMetal + (totalDeuterio * 5);
	}
	
	
	// Para calcular unidades de cada flota 
	public void initialFleetNumber() {
		// Calacular total de unidades
		
		//initialNumberUnitsPlanet
		int totalGrupo = 0;
		int totalUnidades = 0;
		// Sumar total de tropas
		ArrayList[][] armies = this.getArmies();
//		System.out.println("Longitud armies = " + armies.length);
		int[][] initUnits = new int[2][7];
		
		for (int i = 0; i < 2; i++) {	
			totalGrupo = 0;
			totalUnidades = 0;
			for (int j = 0; j < armies[i].length; j++) {
				// Por cada fila de la columna armies[i]
				if (!(armies[i][j] == null)) {
					totalGrupo += armies[i][j].size();
					initUnits[i][j] = totalGrupo;
					
				}
			}
			totalUnidades += totalGrupo;
			if (i==0) {
				this.initialNumberUnitsPlanet = totalUnidades;
			}else {
				this.initialNumberUnitsEnemy = totalUnidades;
			}
		}
		setInitialArmies(initUnits);
		//System.out.println("\nPLANETA= "+ initialNumberUnitsPlanet + "\nENEMIGOS= "+ initialNumberUnitsEnemy);

	} 
	
	// Para calcular los porcentajes de unidades que quedan respecto los ejércitos iniciales.
	public int remainderPercentageFleet(ArrayList<MilitaryUnit>[] army){
		int totalUnits = 0; 
		int resultado;
		for (ArrayList<MilitaryUnit> arrayList : army) {
			if (!(arrayList == null)){
				totalUnits += arrayList.size();
			}
			
		}
		// Calculo el porcentaje
		if (army[4] == null) {
			resultado = totalUnits*100/getInitialNumberUnitsEnemy();
		}else {
			resultado = totalUnits*100/getInitialNumberUnitsPlanet();
		}
		System.out.println("Porcentaje de ejercito = " + resultado);
		return resultado;
	}
	
	//	Para que dado un ejército, nos devuelva el grupo defensor, 
	//	0-3 en el caso de la flota enemiga, 0-6 en el caso del ejército de nuestro planeta.
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		// Calculo probabilidades
		 int[] chanceMyArmy = getChanceUnits(army);
	
		// Por ultimo escojeremos que unidad sera el defensor dentro de ese grupo
		// EJERCITO > UNIDADES > NAVE
		int cont = 0;
		boolean checkSize = false;
		
		while (!checkSize) {
			int randomNum = (int)(Math.random()*100);
			int sumTotal = 0;
			cont = -1;
			// Ecoger grupo def
			for (int i = 0; i< chanceMyArmy.length;i++) {
				sumTotal += chanceMyArmy[i];
				if (sumTotal < randomNum) {
					cont ++;
//					System.out.println("CONTADOR DEFENDER = " + cont);
				}else {
					break;
				}
			}
			if (cont == -1) {
				cont = 0;
			}
			
			if (!(army[cont] == null) && army[cont].size() > 0) {
				checkSize = true;
			}else {
				System.out.println("\nTropa de defensa erronea\n");
			}
		}
		return cont;
	}
	
	// Que nos servirán para escoger el GRUPO atacante (a que tropa ataca) tanto del planeta...
	public int getPlanetGroupAttacker() {

		// Añadir check size aquiS
		boolean checkSize = false;
		int cont = 0;
		
		while (!checkSize) {
			int randomNum = (int)(Math.random()*100);			
			int sumTotal = 0;
			cont = -1;
			
			// Ecoger grupo atack
			for (int i = 0;i< CHANCE_ATTACK_PLANET_UNITS.length;i++) {
				sumTotal += CHANCE_ATTACK_PLANET_UNITS[i];
				
				if (sumTotal < randomNum) {
					cont ++;
				}
			}
			
			if (cont == -1) {
				cont = 0;
			}
			//Comporbar que ese arraylist tiene tantas posiciones.
			//System.out.println("1 " + getPlanetArmy());
			if (getPlanetArmy()[cont].size() > 0) {
				checkSize = true;
			}else {
				System.out.println("\nTropa de ataque 1 erronea\n");
			}
			
		}
		return cont;
	}		
	
	//... como de la flota enemiga.
	public int getEnemyGroupAttacker() {
		// Añadir check size aquiS
		boolean checkSize = false;
		int cont = 0;
		
		while (!checkSize) {
			int randomNum = (int)(Math.random()*100);			
			int sumTotal = 0;
			cont = -1;
			
			// Ecoger grupo atack
			for (int i = 0;i< CHANCE_ATTACK_ENEMY_UNITS.length;i++) {
				sumTotal += CHANCE_ATTACK_ENEMY_UNITS[i];
				
				if (sumTotal < randomNum) {
					cont ++;
				}
			}
			
			if (cont == -1) {
				cont = 0;
			}else {
				System.out.println("\nTropa de ataque 2 erronea\n");
			}
			//Comporbar que ese arraylist tiene tantas posiciones. 
//			System.out.println("2 " + getEnemyArmy());
			if (getEnemyArmy()[cont].size() > 0) {
				checkSize = true;
			}
		}
		return cont;
	}

	//  Restablecer los blindajes de nuestro ejército.
	public void resetArmyArmor() {
		
	}
	
	public void batalla() {
		System.out.println("ESTIC A LA BATALLA");
		ArrayList<MilitaryUnit>[][] armies = this.armies;
		// Contar total de tropas iniciales
		initialFleetNumber();
		
		boolean chanceAttack = false;
		boolean playBattle = true;
		boolean checkSize = false;
		
		// BATALLA
		// Escoget quien ataca primero
		// Luego llamas a un ataket o a otro en funcion de eso y el defender igual
		// de la poisicion que te devuelven escojes una tropa aleatoria 
		// El atacante le va metiendo ostias al defensor hasta que no vueva a repetir
		// Despues volvemos a hacer lo mismo pero invirtiendo roles (defensor--> atacante y viceversa)
		// Cuando uno se muerte lo borramos y añadimos +1 al contador de muertes de se grupo (enemyDarps[indice grupo] += 1)
		// Despues de la batalla calculamos coste de perdidas por equipo...
		int empieza = (int)(Math.random()*2);
		int cont = 0;
		
		if (getInitialNumberUnitsPlanet() == 0) {
			System.out.println("\nNo tienes suficientes tropas para la batalla.\n GAME OVER\n");
			playBattle = false;
		}

		while (playBattle) {
			System.out.println("****EMPIEZA = " + empieza);
			// Aqui guardo el grupo att y el grupo def de cada jugada
			ArrayList<MilitaryUnit> attDef = new ArrayList<MilitaryUnit>();
						
			
			// Grupo def
			cont = getGroupDefender(armies[empieza%2]);
			// Añado grupo enemigo
			int randomNum = (int)(Math.random()*armies[empieza%2][cont].size());
			//System.out.println("SIZE DEL ARMY DEFENDER = " + armies[empieza%2][cont].size());
			attDef.add(armies[empieza%2][cont].get(randomNum));	

			// Grupo atack
			if (armies[empieza%2][4] == null) {
				cont = getEnemyGroupAttacker();
				randomNum = (int)(Math.random()*armies[1][cont].size());	
				attDef.add(armies[1][cont].get(randomNum));	
			}else {
				cont = getPlanetGroupAttacker();
				randomNum = (int)(Math.random()*armies[0][cont].size());	
				attDef.add(armies[0][cont].get(randomNum));	
	
			}
//			System.out.println("Antes de la pelea");
//			playBattle = false;
			// Atacante resta a defensa lo que tiene de poder de ataque
			// Hasta 0 o -0, que se eliminara
			// PELEA DE DOS
			int chanceWaste;
			boolean pelea = true;
			//playBattle = false;
			while (pelea) {
				System.out.println("Guantazo");
				//attDef.get(1).getActualArmor() > 0 &&  attDef.get(0).getActualArmor() > 0
				// El atacante le pega al defensor
				attDef.get(1).tekeDamage(attDef.get(0).attack());
				
				//Para ver un poquito
				System.out.println("DEFENSOR = " + attDef.get(1).getActualArmor());
				System.out.println("ATACANTE = " + attDef.get(0).getActualArmor());
				
				if (attDef.get(1).getActualArmor() <= 0 ) {
					// Lo elimino
					System.out.println("Tu tropa ha muerto");
					// Sumar +1 a las bajas **** hacer la resta luego
					//setPlanetDrops(getPlanetDrops()[cont]+1, cont);
					// Borrar tropa del grupo defensor
					attDef.remove(attDef.get(1));
					armies[empieza%2][cont].remove(randomNum);
					
					// Sincronizo la variable
					setArmies(armies);
//					System.out.println("ARMY 1 " + armies[0]);
//					System.out.println("ARMY 2 " + armies[1]);
					//Añado un nuevo defensor
					//System.out.println("3 " + armies[empieza%2]);
					cont = getGroupDefender(armies[empieza%2]);
					// Añado grupo enemigo
					randomNum = (int)(Math.random()*armies[empieza%2][cont].size());
					attDef.add(armies[empieza%2][cont].get(randomNum));	
				}
				// Mirar si vuleve a pegar
				int chance = attDef.get(0).getChanceAttackAgain();
				if ((int)(Math.random() *100 ) > chance) {
					pelea = false;
					System.out.println("No vuelve a atacar, nueva pelea");
				}
			}
			// Comprovar que tengo + del 20% de mis tropas
			if (remainderPercentageFleet(armies[0]) <= PERCENTATGE_LIMIT_BATTLE_UNITS 
					|| remainderPercentageFleet(armies[1]) <= PERCENTATGE_LIMIT_BATTLE_UNITS) {
				// Se acaba la batalla y se hace recuento
				System.out.println("Fin pelea, menos del 20%");
				playBattle = false;
			}
			
			
			// Cambia el turno***
			if (empieza == 1) {
				empieza = 0;
				
			}else {
				empieza = 1;
			}
				
		}
	System.out.println("**Ahora hare un recuento de los recursos**");
	
	// Calcular bajas
	updateResourcesLooses();
	//Calacular recursos totales para saber el GANADOR
	
	// Calcular los resiguos que se queda
	
	
//	//Meter en updateResourceLosses
//	attDef.get(0).getChanceGeneratinWaste();
//	// Si la sale true la probabilidad de dejar residuos
//	if ((int)(Math.random()*100) < chanceWaste) {
//		// Sumos los residuos de metal (70% de la tropa enemiga)
//		wasteMetalDeuterium[0] = (attDef.get(1).getMetalCost() * PERCENTATGE_WASTE / 100);
//		// Sumos los residuos de deuterio (70% de la tropa enemiga)
//		wasteMetalDeuterium[1] = (attDef.get(1).getDeuteriumCost() * PERCENTATGE_WASTE / 100);


	// Antes de eliminarla, comprobaremos si genera residuos, la probabilidad de generar residuos está
	//definida en la interfaz Variables, por ejemplo, int CHANCE_GENERATNG_WASTE_LIGTHHUNTER = 55
	// Si generar_residuo = true entonces se recuepera un 70%  (PERCENTATGE_WASTE) del coste de la unidad
	}
}

