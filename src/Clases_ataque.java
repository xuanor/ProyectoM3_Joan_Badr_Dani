import Clases_ataque.HeavyHunter;

public class Clases_ataque {
	

	public abstract class Ship implements MilitaryUnit, Variables{
		int armor;
		int initialArmor;
		int baseDamage;
		
		public Ship() {};// Añadir initial armour 
		
		public Ship(int initialArmor, int baseDamage) {
			// Añadir pluses desde el constructor no en metodos de planeta***
			super();
			this.initialArmor = initialArmor;
			this.armor = initialArmor;
			this.baseDamage = baseDamage;
		}
		
	}
	
	class LigthHunter extends Ship {
		
		public LigthHunter(){
			super();
		}
		
		public LigthHunter(int armor, int baseDamage) {
			super(armor, baseDamage);
	
		}
	
		
		public int attack() {
			// Plus tech??
			return this.baseDamage;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			armor -= receivedDamage;
			
		}
	
		
		public int getActualArmor() {
			return this.armor;
		}
	
		
		public int getMetalCost() {
			return METAL_COST_LIGTHHUNTER;
		}
	
		
		public int getDeuteriumCost() {
			return DEUTERIUM_COST_LIGTHHUNTER;
		}
	
		
		public int getChanceGeneratinWaste() {
			return CHANCE_GENERATNG_WASTE_LIGTHHUNTER;
		}
	
		
		public int getChanceAttackAgain() {
			
			return CHANCE_ATTACK_AGAIN_LIGTHHUNTER;
		}
	
		
		public void resetArmor() {
			this.armor = this.initialArmor;
			
		}

		
		public String getUnitName() {	
			return UNIT_NAMES[0];
		}
		
	}
	class HeavyHunter extends Ship{
		
		
		public HeavyHunter() {
			super();
		}
	
		public HeavyHunter(int armor, int baseDamage) {
			super(armor, baseDamage);
			
//			// Formula de nivel de tecnologia para las stats
//			armor = ARMOR_HEAVYHUNTER + 
//					(this. * PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY)
//					*ARMOR_HEAVYHUNTER/100;
//			atack = BASE_DAMAGE_HEAVYHUNTER + 
//					(this.technologyAtack * PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY)
//					*BASE_DAMAGE_HEAVYHUNTER/100;
//			
//			for (int i = 0; i<n; i++) {
//				if (i == n-1) {
//					System.out.println("Se han creado "+ n + " Heavy hunter/s.");
//				}
//				if ((this.metal - METAL_COST_HEAVYHUNTER) > 0 && (this.deuterium - DEUTERIUM_COST_HEAVYHUNTER) > 0) {
//					this.army[1].add(cAtack.new HeavyHunter(armor, atack));
//					this.metal -= METAL_COST_HEAVYHUNTER;
//					this.deuterium -= DEUTERIUM_COST_HEAVYHUNTER;
//				}else {
//					System.out.println("\nDon't hace enough resources.");
//					throw new BuildException("Solo se han creado "+ i + " Heavy hunter/s.\n");	
//				}	
//			}
		}
	
		
		public int attack() {
			return this.baseDamage;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			armor -= receivedDamage;
			
		}
	
		
		public int getActualArmor() {
			return this.armor;
		}
	
		
		public int getMetalCost() {
			return METAL_COST_HEAVYHUNTER;
		}
	
		
		public int getDeuteriumCost() {
			return DEUTERIUM_COST_HEAVYHUNTER;
		}
	
		
		public int getChanceGeneratinWaste() {
			return CHANCE_GENERATNG_WASTE_HEAVYHUNTER;
		}
	
		
		public int getChanceAttackAgain() {
			
			return CHANCE_ATTACK_AGAIN_HEAVYHUNTER;
		}
	
		
		public void resetArmor() {
			this.armor = this.initialArmor;
			
		}
		public String getUnitName() {	
			return UNIT_NAMES[1];
		}
		
		
	}
	class BattleShip extends Ship{
	
		
		public BattleShip() {
			super();
		}
	
	
		public BattleShip(int armor, int baseDamage) {
			super(armor, baseDamage);
		}
	
	
		public int attack() {
			return this.baseDamage;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			armor -= receivedDamage;
			
		}
	
		
		public int getActualArmor() {
			return this.armor;
		}
	
		
		public int getMetalCost() {
			return METAL_COST_BATTLESHIP;
		}
	
		
		public int getDeuteriumCost() {
			return DEUTERIUM_COST_BATTLESHIP;
		}
	
		
		public int getChanceGeneratinWaste() {
			return CHANCE_GENERATNG_WASTE_BATTLESHIP;
		}
	
		
		public int getChanceAttackAgain() {
			
			return CHANCE_ATTACK_AGAIN_BATTLESHIP;
		}
	
		
		public void resetArmor() {
			this.armor = this.initialArmor;
			
		}
		public String getUnitName() {	
			return UNIT_NAMES[2];
		}
		
	}
	class ArmoredShip extends Ship{
	
		
		public ArmoredShip() {
			super();
		}
	
	
		public ArmoredShip(int armor, int baseDamage) {
			super(armor, baseDamage);
		}
	
	
		public int attack() {
			return this.baseDamage;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			armor -= receivedDamage;
			
		}
	
		
		public int getActualArmor() {
			return this.armor;
		}
	
		
		public int getMetalCost() {
			return METAL_COST_ARMOREDSHIP;
		}
	
		
		public int getDeuteriumCost() {
			return DEUTERIUM_COST_ARMOREDSHIP;
		}
	
		
		public int getChanceGeneratinWaste() {
			return CHANCE_GENERATNG_WASTE_ARMOREDSHIP;
		}
	
		
		public int getChanceAttackAgain() {
			
			return CHANCE_ATTACK_AGAIN_ARMOREDSHIP;
		}
	
		
		public void resetArmor() {
			this.armor = this.initialArmor;
			
		}
		
		public String getUnitName() {	
			return UNIT_NAMES[3];
		}
		
	}
}
