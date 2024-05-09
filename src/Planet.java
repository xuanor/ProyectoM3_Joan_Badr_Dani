import java.util.ArrayList;


public class Planet implements Variables{
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
	public void upgradeTechnologyDefense(int coste) {
		if (this.deuterium - coste > 0) {
			this.technologyDefense += 1;
			this.deuterium -= coste;
		}
	}

	public void upgradeTechnologyAttack(int coste) {
		if (this.deuterium - coste > 0) {
			this.technologyAtack += 1;
			this.deuterium -= coste;
		}
	}
	
	// Nuevas flotas de ataque
	public void newLightHunter(int n) {
		for (int i = 0; i<n; i++) {
			// Formula de nivel de tecnologia para las stats
			int armor;
			int atack;
			// 1000 + (2*5)1000/100 = 1100
			armor = ARMOR_LIGTHHUNTER + 
					(this.technologyDefense * PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY)
					*ARMOR_LIGTHHUNTER/100;
			atack = BASE_DAMAGE_LIGTHHUNTER + 
					(this.technologyAtack * PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY)
					*BASE_DAMAGE_LIGTHHUNTER/100;
			// Continuar *****
//			this.army[0].add(new Ship().new LightHunter());
		}
		
	}
	
	public void newHeavyHunter(int n) {
		
	}
	
	public void newBattleShip(int n) {
		
	}
	
	public void newArmoredShip(int n) {
		
	}
	// Nueva defensas
	public void newMissileLauncher(int n) {
		
	}
	
	public void newIonCannon(int n) {
		
	}
	
	public void newPlasmaCannon(int n) {
		
	}
	
	public void printStats() {
		
	    int cantidadLight = this.army[0].size();
	    int cantidadHeavy = this.army[1].size();
	    int cantidadBattle = this.army[2].size();
	    int cantidadArmored = this.army[3].size();
	    int cantidadMissile = 0;
		int cantidadIon = 0;
		int cantidadPlasma =0;
	    if (!(army[4] == null)) {
		    cantidadMissile = this.army[4].size();
		    cantidadIon = this.army[5].size();
		    cantidadPlasma = this.army[6].size();
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
this.technologyAtack, this.technologyDefense, cantidadMissile, cantidadIon, cantidadPlasma, cantidadLight, 
cantidadHeavy, cantidadBattle, cantidadArmored, this.metal, this.deuterium);

	        // Imprime las estadísticas
	        System.out.println(stats);
	}	
	
}
	
