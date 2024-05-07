import java.util.ArrayList;

public class Battle {
	// Para almacenar la flota enemiga
	ArrayList<MilitaryUnit> planetArmy; 
	// Para almacenar la flota de nuestro planeta
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
	
}
