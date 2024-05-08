import java.util.ArrayList;


public class Planet {
	int technologyDefense;
	int technologyAtack;
	int metal;
	int deuterium;
	int upgradeDefenseTechnologyDeuteriumCost;
	int upgradeAttackTechnologyDeuteriumCost;
	ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	
	// Constructor
	public Planet(int technologyDefense, int technologyAtack, int metal, int deuterium,
		int upgradeDefenseTechnologyDeuteriumCost, int upgradeAttackTechnologyDeuteriumCost) {

		super();
		this.technologyDefense = technologyDefense;
		this.technologyAtack = technologyAtack;
		this.metal = metal;
		this.deuterium = deuterium;
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}

		

	// Getters and setters
	public int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public int getTechnologyAtack() {
		return technologyAtack;
	}

	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getDeuterium() {
		return deuterium;
	}

	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}

	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}

	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}

	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}

	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}

	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}

	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}
	
	// Mas metodos
	public void upgradeTechnologyDefense() {
		
	}

	public void upgradeTechnologyAttack() {
		
	}
	
	public void newLightHunter(int n) {
		
	}
	
	public void newHeavyHunter(int n) {
		
	}
	
	public void newBattleShip(int n) {
		
	}
	
	public void newArmoredShip(int n) {
		
	}
	
	public void newMissileLauncher(int n) {
		
	}
	
	public void newIonCannon(int n) {
		
	}
	
	public void newPlasmaCannon(int n) {
		
	}
	
	public void printStats() {
		
	    int cantidadLight = 0;
	    int cantidadHeavy = 0;
	    int cantidadBattle = 0;
	    int cantidadArmored = 0;
	    int cantidadMissile = 0;
	    int cantidadIon = 0;
	    int cantidadPlasma = 0;
		
		for (int i = 0; i < army.length; i++) {
		     cantidadLight = army[0].size();
		     cantidadHeavy = army[1].size();
		     cantidadBattle = army[2].size();
		     cantidadArmored = army[3].size();
		     cantidadMissile = army[4].size();
		     cantidadIon = army[5].size();
		     cantidadPlasma = army[6].size();
		}
		
	    String stats = String.format("Planet Stats:\n"
	    						   + "\nTECHNOLOGY\n"
	    						   + "\nAtack Technology%14d\n"
	    						   + "Defense Technology%12d\n"
	    						   + "\nDEFENSES\n"
	    						   + "\nMissile Launcher%14d\n"
	    						   + "Ion Cannon%20d\n"
	    						   + "Plasma Cannon%17d\n"
	    						   + "\nFLEET\n"
	    						   + "\nLight Hunter%18d\n"
	    						   + "Heavy Hunter%18d\n"
	    						   + "Battle Ship%19d\n"
	    						   + "Armored Ship%18d\n"
	    						   + "\nRESOURCES\n"
	    						   + "\nMetal%25d\n"
	    						   + "Deuterium%21d",
technologyAtack, technologyDefense, cantidadMissile, cantidadIon, cantidadPlasma, cantidadLight, 
cantidadHeavy, cantidadBattle, cantidadArmored, metal, deuterium);

	        // Imprime las estadísticas
	        System.out.println(stats);
	}	
	
}
	
