
public class Defense implements MilitaryUnit, Variables{

	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	public Defense(int armor, int initialArmor, int baseDamage) {
		super();
		this.armor = armor;
		this.initialArmor = initialArmor;
		this.baseDamage = baseDamage;
	}
	
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getInitialArmor() {
		return initialArmor;
	}
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	
}

class MisileLauncher extends Defense {

	public MisileLauncher(int armor, int initialArmor, int baseDamage) {
		super(armor, initialArmor, baseDamage);
	}
	
}

class IonCannon extends Defense {

	public IonCannon(int armor, int initialArmor, int baseDamage) {
		super(armor, initialArmor, baseDamage);
		
	}
	
}

class PlasmaCannon extends Defense {

	public PlasmaCannon(int armor, int initialArmor, int baseDamage) {
		super(armor, initialArmor, baseDamage);
		
	}
	
}
