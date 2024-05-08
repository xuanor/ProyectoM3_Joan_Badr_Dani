import java.util.ArrayList;

public class Battle {
	// ***VARIABLES***
	
	// Para almacenar la flota de nuestro planeta
	ArrayList<MilitaryUnit> planetArmy; 
	// Para almacenar la flota enemiga
	ArrayList<MilitaryUnit> enemyArmy;
	// Fila 1 nuestro ejercito, fila 2 ejercito enemigo
	ArrayList[][] armies;
	// Donde guardamos todo el desarrollo de la batalla paso a paso
	String battleDevelopment;
	
	//	COSTE de metal de los ejercitos iniciales
	//	[[metal][deuterio],[metal][deuterio]] ,
	//	el 0 es mi ejercito el 1 los enemigos
	int[][] initialCostFleet;
	
	// n inical de soldados x ejercito
	int initialNumberUnitsPlanet, initialNumberUnitsEnemy;
	
	// Residuos generados en la batalla [metal, deuterio].
	int[] wasteMetalDeuterium;
	
	// Muertes x ejercicto
	int[] enemyDrops, planetDrops;
	
	// Array 2x3 perdidas de los 2 recursos
	// Fila 1 recursos de mi ejercito
	// Fila 2 recursos del otro ejercito 
	// recursos ponderados(con su valor) de los dos ejercitos
	int[][] resourcesLooses;
	
	// Array 2x7 
	// cada fila representa a un ejercito (0 y 1) 
	// cada columna representa un tipo de soldado y su cantidad incial (0-7)
	int[][] initialArmies;
	
	// Tipos de unidades que hay
	int[] actualNumberUnitsPlanet, actualNumberUnitsEnemy;
	
	// ***METODOS***
	
	//resumen, battles será el número de batallas que hayamos acumulado
	public String getBattleReport(int battles) {
		return "";
	}
	
	//  Mostrar batalla paso a paso.
	public String getBattleDevelopment() {
		return "";
	} 
	
	// Para inicializar el array initialArmies y poder calcular los reportes.
	public void initInitialArmies() {

	} 
	// Para generar el array de pérdidas.
	public void updateResourcesLooses() {
		
	} 
	
	// Para calcular costes de las flotas.
	public void fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		
	}
	
	// Para calcular el número de unidades iniciales de cada flota
	public void initialFleetNumber(ArrayList<MilitaryUnit>[] army) {
		
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
	// Que nos servirán para escoger el grupo atacante tanto del planeta...
	public int getPlanetGroupAttacker() {
		return 0;
	}
	//... como de la flota enemiga.
	public int getEnemyGroupAttacker() {
		return 0;
	}
	
	//  Restablecer los blindajes de nuestro ejército.
	public void resetArmyArmor() {
		
	}
	
}
