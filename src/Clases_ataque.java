
public class Clases_ataque {
	

	public abstract class Ship implements MilitaryUnit, Variables{
		int armor;
		int initialArmor;
		int baseDamage;
		
		public Ship() {};// Añadir initial armour 
		
		public Ship(int armor, int baseDamage) {
			super();
			this.armor = armor;
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
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			// TODO Auto-generated method stub
			
		}
	
		
		public int getActualArmor() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getMetalCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getDeuteriumCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceGeneratinWaste() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceAttackAgain() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void resetArmor() {
			// TODO Auto-generated method stub
			
		}
		
	}
	class HeavyHunter extends Ship{
		
		
		public HeavyHunter() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		public HeavyHunter(int armor, int baseDamage) {
			super(armor, baseDamage);
		}
	
		
		public int attack() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			// TODO Auto-generated method stub
			
		}
	
		
		public int getActualArmor() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getMetalCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getDeuteriumCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceGeneratinWaste() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceAttackAgain() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void resetArmor() {
			// TODO Auto-generated method stub
			
		}
		
	}
	class BattleShip extends Ship{
	
		
		public BattleShip() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	
		public BattleShip(int armor, int baseDamage) {
			super(armor, baseDamage);
		}
	
	
		public int attack() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			// TODO Auto-generated method stub
			
		}
	
		
		public int getActualArmor() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getMetalCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getDeuteriumCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceGeneratinWaste() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceAttackAgain() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void resetArmor() {
			// TODO Auto-generated method stub
			
		}
		
	}
	class ArmoredShip extends Ship{
	
		
		public ArmoredShip() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	
		public ArmoredShip(int armor, int baseDamage) {
			super(armor, baseDamage);
		}
	
	
		public int attack() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void tekeDamage(int receivedDamage) {
			// TODO Auto-generated method stub
			
		}
	
		
		public int getActualArmor() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getMetalCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getDeuteriumCost() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceGeneratinWaste() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public int getChanceAttackAgain() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		
		public void resetArmor() {
			// TODO Auto-generated method stub
			
		}
	}
}
