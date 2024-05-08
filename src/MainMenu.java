import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean attackComing = false;
		
		String mainMenu = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "0)Exit\n";
		
		String mainMenuAttack = "Main Menu\n" + "1)View Planet Stats\n" + "2)Build\n" + "3)Upgrade Technology\n"
				+ "4)View Battle Reports\n" + "5)View Thread Coming\n" + "0)Exit\n";
		
		int option = -1;
		while (option != 0) {
			if (attackComing) {
			System.out.println(mainMenuAttack);
			}else {
				System.out.println(mainMenu);
			}
			
			System.out.println("-->Option: ");
			option = sc.nextInt();
			
			switch (option) {
			case 0:
				System.out.println("See you later!");
				break;
			
			case 1:
				System.out.println("Aqui van las Estadisticas del planeta");
				break;
			
			case 2:
				System.out.println("Aqui va el menu de construcciones");
				break;
			
			case 3:
				System.out.println("Aqui va el menu de mejorar tecnologias");
				break;
				
			case 4:
				System.out.println("Aqui va el reporte de las batallas");
				break;
				
			case 5:
				if(attackComing) {
				System.out.println("Aqui va el reporte del ataque");
				attackComing = false;
				}
				break;

			case 6:
				attackComing = true;
				System.out.println("Se ha cambiado el attackComing a true");
				break;
			}
		}
	}
}