
public class prueba {

	public static void main(String[] args) {
		
		String header = String.format("%-12s %12s %12s %12s %12s", "Army", "planet", "Units", "Drops", "Initial");
        String separator = "------------------------------------------------------------";
        String lightHunter = String.format("%12s %12s %12s %12s %12s", "Ligth Hunter", "11", "8", "Ligth Hunter", "19 17");
        String heavyHunter = String.format("%-12s %-12s %-12s %-12s %-12s", "Heavy Hunter", "3", "1", "Heavy Hunter", "7 5");
        String battleShip = String.format("%-12s %-12s %-12s %-12s %-12s", "Battle Ship", "1", "0", "Battle Ship", "1 1");
        String armoredShip = String.format("%-12s %-12s %-12s %-12s %-12s", "Armored Ship", "1", "0", "Armored Ship", "1 0");
        String missileLauncher = String.format("%-12s %-12s", "Missile Launcher", "11 9");
        String ionCannon = String.format("%-12s %-12s", "Ion Cannon", "1 1");
        String plasmaCannon = String.format("%-12s %-12s", "Plasma Cannon", "1 0");
        
        System.out.println(header);
        System.out.println(separator);
        System.out.println(lightHunter);
        System.out.println(heavyHunter);
        System.out.println(battleShip);
        System.out.println(armoredShip);
        System.out.println(missileLauncher);
        System.out.println(ionCannon);
        System.out.println(plasmaCannon);
	}
	

}
