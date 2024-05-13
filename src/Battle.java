import java.util.ArrayList;

import javax.swing.plaf.synth.SynthStyleFactory;

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
	
	// Residuos generados en la batalla [metal, deuterio].
	private int[] wasteMetalDeuterium;
	
	// Muertes x ejercicto
	private int[] enemyDrops, planetDrops;
	
	// Array 2x3 perdidas de los 2 recursos
	// Fila 1 recursos de mi ejercito
	// Fila 2 recursos del otro ejercito 
	// recursos ponderados(con su valor) de los dos ejercitos
	
	// Calcular dienero de cada muerto despues de una batalla
	private int[][] resourcesLooses;
	
	// Array 2x7 
	// cada fila representa a un ejercito (0 y 1) 
	// cada columna representa un tipo de soldado y su cantidad incial (0-7)
	private int[][] initialArmies;
	
	// Tipos de unidades que hay
	private int[] actualNumberUnitsPlanet, actualNumberUnitsEnemy;
	
	// ***METODOS***
	
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

	//  Mostrar batalla paso a paso.
	public String getBattleDevelopment() {
		return "";
	} 
	
	// Para inicializar el array initialArmies y poder calcular los reportes. SIN USO ***
//	public void initInitialArmies() {
	 
	// Para generar el array de pérdidas.
	public void updateResourcesLooses() {
		//resourcesLooses
	} 
	
	// Para calcular costes de las flotas.
	public void fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		//initialCostFleet
	}
	
	// Para calcular unidades de cada flota ****
	public void initialFleetNumber() {
		// Calacular total de unidades
		//initialNumberUnitsPlanet
		int totalGrupo = 0;
		int totalUnidades = 0;
		initialArmies = new int[2][7];
		// Sumar total de tropas
		
		for (int i = 0; i < 2; i++) {	
			for (int j = 0;j < armies[i].length;j++) {
				// Por cada fila de la columna armies[i]
				if (!(armies[i][j] == null)) {
					totalGrupo += armies[i][j].size();
					initialArmies[i][j] = totalGrupo;
					totalUnidades += totalGrupo;
				}
			}
			if (i==0) {
				initialNumberUnitsPlanet = totalUnidades;
			}else {
				initialNumberUnitsEnemy = totalUnidades;
			}
		}
		//System.out.println("\nPLANETA= "+ initialNumberUnitsPlanet + "\nENEMIGOS= "+ initialNumberUnitsEnemy);

		//getGroupDefender
		//getPlanetGroupAttacker
		// getEnemyGroupAttacker
	} 
	
	// Para calcular los porcentajes de unidades que quedan respecto los ejércitos iniciales.
	public int remainderPercentageFleet(ArrayList<MilitaryUnit>[] army){
		return 0;
	}
	
	//	Para que dado un ejército, nos devuelva el grupo defensor, 
	//	0-3 en el caso de la flota enemiga, 0-6 en el caso del ejército de nuestro planeta.
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		return 0;
	}
	// Que nos servirán para escoger el GRUPO atacante (a que tropa ataca) tanto del planeta...
	public int getPlanetGroupAttacker() {
		return 0;
	}
	//... como de la flota enemiga.
	public int getEnemyGroupAttacker() {
		// Añadir check size aquiS
		boolean checkSize = false;
		int cont = 0;
		while (!checkSize) {
			int randomNum = (int)(Math.random()*100);			
			int sumTotal = 0;
			cont = 0;
			
			// Ecoger grupo atack
			for (int i = 0;i< CHANCE_ATTACK_ENEMY_UNITS.length;i++) {
				sumTotal += CHANCE_ATTACK_ENEMY_UNITS[i];
				
				if (sumTotal < randomNum) {
					cont += i;
				}
			}
		}
		return cont;
	}
	
	//  Restablecer los blindajes de nuestro ejército.
	public void resetArmyArmor() {
		
	}
	// MECANICA BATALLA pasar a class battle***
	public void batalla(){
		// El obj battle que he ido pasando desde mainMenu
		ArrayList<MilitaryUnit>[] mainArmy, enemyArmy;
		mainArmy = getPlanetArmy();
		enemyArmy = getEnemyArmy();
		this.initialFleetNumber();
		
		// --Escojer quien ataca primero--
		// Algoritmo para escojer atacante (variable chance_...)
		// Algoritmo para escojer defensor (variable chance_...)
		
		// ** ATACANTE **
		int [] chanceEnenmy = CHANCE_ATTACK_ENEMY_UNITS;
		int [] chanceMyArmy = CHANCE_ATTACK_PLANET_UNITS;
		boolean chanceAttack = false;
		boolean playBattle = false;
		boolean checkSize = false;
		// BATALLA
		// Escoget quien ataca primero
		// Luego llamas a un ataket o a otro en funcion de eso y el defender igual
		// de la poisicion que te devuelven escojes una tropa aleatoria
		// El atacante le va metiendo ostias al defensor hasta que no vueva a repetir
		// Despues volvemos a hacer lo mismo pero invirtiendo roles (defensor--> atacante y viceversa)
		// Cuando uno se muerte lo borramos y añadimos +1 al contador de muertes de se grupo (enemyDarps[indice grupo] += 1)
		// Despues de la batalla calculamos coste de perdidas por equipo...
		int empieza = (int)(Math.random()+1);
		while (playBattle) {
			// Aqui guardo el grupo att y el grupo def de cada jugada
			ArrayList<MilitaryUnit>[] attDef = new ArrayList[2];
			int randomNum = (int)(Math.random()*100);			
			int cont;
			// Empiza el enemigo
			if (empieza == 1) {
				while (!checkSize) {
					cont = getGroupDefender(planetArmy);
					//Comporbar que ese arraylist tiene tantas posiciones. 
					if (mainArmy[cont].size() > 0) {
						checkSize = true;
						// Añado grupo enemigo
						attDef[1] = mainArmy[cont];	
					}
				}
				checkSize = false;
				// Ecoger grupo atack
				while (!checkSize) {
					cont = getEnemyGroupAttacker();
					//Comporbar que ese arraylist tiene tantas posiciones. 
					if (enemyArmy[cont].size() > 0) {
						checkSize = true;
						// Añado grupo enemigo
						attDef[0] = enemyArmy[cont];
					}
				}
				
			} // Empiza mi planeta
			else {
				while (!checkSize) {
					cont = getGroupDefender(enemyArmy);
					//Comporbar que ese arraylist tiene tantas posiciones. 
					if (mainArmy[cont].size() > 0) {
						checkSize = true;
						// Añado grupo enemigo
						attDef[0] = enemyArmy[cont];	
					}
				}
				checkSize = false;
				// Ecoger grupo atack
				while (!checkSize) {
					cont = getPlanetGroupAttacker();
					//Comporbar que ese arraylist tiene tantas posiciones. 
					if (mainArmy[cont].size() > 0) {
						checkSize = true;
						// Añado grupo enemigo
						attDef[0] = mainArmy[cont];
						//chanceAttack = true;
					}
				}
			}
			
			
//			for (int i = 0;i< chanceEnenmy.length;i++) {
//				sumTotal += chanceEnenmy[i];
//				
//				if (sumTotal < randomNum) {
//					cont += i;
//				}
//			}//System.out.println("cont1 = "+ cont);
//			// ***
			
			
			checkSize = false;
			
			

//			sumTotal = 0;
//			for (int i= 0; i< mainArmy.length;i++) {
//				sumTotal += mainArmy[i].size();
//			
//			}
			// ** DEFENSOR ** !!!!
			// Actualizo los porcentajes en funcion de mis topas actuales
			// Calcular que porcentaje representa cada unidad en el army
			//100*(Cantidad de cazadores ligeros ) / (total de unidades) = 9000/200 = 45 %
			for (int i= 0; i< CHANCE_ATTACK_PLANET_UNITS.length; i++) {
				int percent = (int)(100*(mainArmy[i].size()) / (sumTotal));
				chanceMyArmy[i] = percent;
				//System.out.print(chanceMyArmy[i] + " ");
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
				
				
				//System.out.println("Contador " + (cont));
				if (mainArmy[cont].size() > 0) {	
				randomNum = (int)(Math.random()*(mainArmy[cont].size()));
					//System.out.println("RandomNum2 = "+ randomNum);
					attDef.add(mainArmy[cont].get(randomNum));
					// Enemigo nos ataca
					System.out.println(attDef.get(1));
				}
			
			// Atacante resta a defensa lo que tiene de poder de ataque
			// Hasta 0 o -0, que se eliminara
			// PELEA DE DOS
			int chanceWaste;
			while (attDef.get(1).getActualArmor() > 0 &&  attDef.get(0).getActualArmor() > 0) {
				// Respondemos al enemigo
				attDef.get(0).tekeDamage(attDef.get(1).attack());
				attDef.get(1).tekeDamage(attDef.get(0).attack());
				System.out.println("DEFENSOR = " + attDef.get(1).getActualArmor());
				System.out.println("ATACANTE = " + attDef.get(0).getActualArmor());
				if ( attDef.get(1).getActualArmor() <= 0 ) {
					// Lo elimino
					System.out.println("Ha ganado el Attacker");
					attDef.remove(attDef.get(1));
					
				}else if (attDef.get(0).getActualArmor() <= 0) {
					// Lo elimino
					System.out.println("Ha ganado el Defensor");
					chanceWaste = attDef.get(0).getChanceGeneratinWaste();
					// Si la sale true la probabilidad de dejar residuos
					if ((int)(Math.random()*100) < chanceWaste) {
						// Sumos los residuos de metal (70% de la tropa enemiga)
						wasteMetalDeuterium[0] = (attDef.get(1).getMetalCost() * PERCENTATGE_WASTE / 100);
						// Sumos los residuos de deuterio (70% de la tropa enemiga)
						wasteMetalDeuterium[1] = (attDef.get(1).getDeuteriumCost() * PERCENTATGE_WASTE / 100);
					}
					attDef.remove(attDef.get(0));
				}
			}
			
			// Antes de eliminarla, comprobaremos si genera residuos, la probabilidad de generar residuos está
			//definida en la interfaz Variables, por ejemplo, int CHANCE_GENERATNG_WASTE_LIGTHHUNTER = 55
			// Si generar_residuo = true entonces se recuepera un 70%  (PERCENTATGE_WASTE) del coste de la unidad
		}
		}
	}
}
