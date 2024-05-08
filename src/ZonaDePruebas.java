import java.util.ArrayList;

public class ZonaDePruebas {

	public static void main(String[] args) {
		
		int metal = 8000;
		int deuterium = 12500;
		int LightHunter = 8;
		int HeavyHunter = 9;
		int BattleShip = 10;
		int ArmoredShip = 11;
		

//		String ordenado = String.format("|%-11s | %4s| %8s | %7s", metal, deuterium, LightHunter, HeavyHunter);
//		
//		System.out.println("Metal = " + metal + "\n" + "Deuterium = " + deuterium + "\n" + "FLEET" +
//		"\n" + "LightHunter = " + LightHunter + "\n" + "HeavyHunter = " + HeavyHunter);
//	}
		
        String ordenado = String.format(
        						   " MATERIALS \n\n"
        						 + " Metal%19d \n"
        						 + " Deuterium%15d \n\n"
        						 + " FLEET \n\n"
        						 + " LightHunter%13d \n"
        						 + " HeavyHunter%13d \n"
        						 + " BattleShip%14d \n"
        						 + " ArmoredShip%13d", 
                metal, deuterium, LightHunter, HeavyHunter, BattleShip, ArmoredShip);
		
		// Imprime el resultado del String.format
		System.out.println(ordenado);
	
	
//	for (int i = 0; i < army.length; i++) {
//	     System.out.println(army[i]);
//	}

}
}



