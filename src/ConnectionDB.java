import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConnectionDB {
	private int user_id = -1;
	private ArrayList<int[]> arrayReasources;
	private ArrayList<String[]> arrayReportesBatalla;
	private ArrayList<int[]> arrayHeavytHunter;
	private ArrayList<int[]> arrayLightHunter;
	private ArrayList<int[]> arrayBattleShip;
	private ArrayList<int[]> arrayArmoredShip;
	private ArrayList<int[]> arrayMissileLouncher;
	private ArrayList<int[]> arrayIonCannon;
	private ArrayList<int[]> arrayPlasmaCannon;

	
//	public static void main(String[] args) {
//		ConnectionDB cdb = new ConnectionDB();
//		//System.out.println("Probando");
//		//String urlDatos = "jdbc:oracle:thin:@192.168.56.101:1521/orcl";
//		String urlDatos =  "jdbc:oracle:thin:@localhost:1521/orcl";
//		String usuario = "ogame";
//		String pass = "ogame";
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
//			if (conn != null) {
//				System.out.println("Connected with connection");
//			}
//			
//			String query = "SELECT * FROM planet_stats";
//			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = stmnt.executeQuery(query);
//			
//			
//			rs.next();
//			int[] planetStats = {rs.getInt(1),rs.getInt(2),
//					rs.getInt(4),rs.getInt(5),
//					rs.getInt(6),rs.getInt(7),
//					rs.getInt(8),rs.getInt(9),
//					rs.getInt(10),rs.getInt(11),
//					rs.getInt(12),rs.getInt(13),
//					rs.getInt(14),rs.getInt(15)};
//			
//			cdb.setPlanetStats(planetStats);
//			
////			for (int i : planetStats) {
////				System.out.println(i);
////			}
//						
//				
//			//System.out.println("ID = " + rs.getInt(1) + ", Password = " + rs.getString(2) + ", Name = " + rs.getString(3));
//			
//			
//             Preparar la inserción de un nuevo registro
//            String insertQuery = "INSERT INTO user_credentials (user_id, user_password, user_name) VALUES (?, ?, ?)";
//            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
//            insertStatement.setInt(1, 65);
//            insertStatement.setString(2, "Contra1");
//            insertStatement.setString(3, "danielin");
//            insertStatement.executeUpdate();
//            
//			// TABLAS
//			// UserCredentials
//			// Planet stats
//			// Battle
//					
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("Driver no cargado");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println("Conexion no realizada");
//			e.printStackTrace();
//		}
//		ConnectionDB cdb = new ConnectionDB();
//		cdb.conection(1, null);
//		// PULL
//		ArrayList planetStats = new ArrayList();
//		planetStats = cdb.getPlanetStats();
//		
//		//System.out.println(planetStats.size());
//		
//		
//	}
	
	
//	public ArrayList getPlanetStats() {
//		return planetStats;
//	}
//
//	
//
//	public void setPlanetStats(ArrayList planetStats) {
//		this.planetStats = planetStats;
//	}
	
	
	
	public ArrayList<int[]> getArrayReasources() {
		return arrayReasources;
	}
	
	
	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public ArrayList<String[]> getArrayReportesBatalla() {
		return arrayReportesBatalla;
	}


	public void setArrayReportesBatalla(ArrayList<String[]> arrayReportesBatalla) {
		this.arrayReportesBatalla = arrayReportesBatalla;
	}


	public ArrayList<int[]> getArrayLightHunter() {
		return arrayLightHunter;
	}

	public void setArrayLightHunter(ArrayList<int[]> arrayLightHunter) {
		this.arrayLightHunter = arrayLightHunter;
	}

	public void setArrayReasources(ArrayList<int[]> arrayReasources) {
		this.arrayReasources = arrayReasources;
	}

	public ArrayList<int[]> getArrayHeavytHunter() {
		return arrayHeavytHunter;
	}

	public void setArrayHeavytHunter(ArrayList<int[]> arrayHeavytHunter) {
		this.arrayHeavytHunter = arrayHeavytHunter;
	}

	public ArrayList<int[]> getArrayBattleShip() {
		return arrayBattleShip;
	}

	public void setArrayBattleShip(ArrayList<int[]> arrayBattleShip) {
		this.arrayBattleShip = arrayBattleShip;
	}

	public ArrayList<int[]> getArrayArmoredShip() {
		return arrayArmoredShip;
	}

	public void setArrayArmoredShip(ArrayList<int[]> arrayArmoredShip) {
		this.arrayArmoredShip = arrayArmoredShip;
	}

	public ArrayList<int[]> getArrayMissileLouncher() {
		return arrayMissileLouncher;
	}

	public void setArrayMissileLouncher(ArrayList<int[]> arrayMissileLouncher) {
		this.arrayMissileLouncher = arrayMissileLouncher;
	}

	public ArrayList<int[]> getArrayIonCannon() {
		return arrayIonCannon;
	}

	public void setArrayIonCannon(ArrayList<int[]> arrayIonCannon) {
		this.arrayIonCannon = arrayIonCannon;
	}

	public ArrayList<int[]> getArrayPlasmaCannon() {
		return arrayPlasmaCannon;
	}

	public void setArrayPlasmaCannon(ArrayList<int[]> arrayPlasmaCannon) {
		this.arrayPlasmaCannon = arrayPlasmaCannon;
	}

	// Metodo de conexion y selector de la accion que quiero (push/pull)
	public void conection( int opc, Planet p, Battle b, String usr, String pswd ) {
		String urlDatos =  "jdbc:oracle:thin:@localhost:1521/orcl";
		String usuario = "ogame";
		String pass = "ogame";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
			if (conn != null) {
				System.out.println("Connected with connection");
			}
			switch (opc) {
			case 1:
				login(conn, usr, pswd);
				break;
			case 2:
				metodoPull(conn);
				break;
				
			case 3:
				metodoPush(conn, p, b);
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Conexion no realizada");
			e.printStackTrace();
		}	
	}
	
	
	public void login(Connection conn, String usr, String pswd) {
		try {
			String query = "SELECT * FROM user_credentials";
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmnt.executeQuery(query);
			
			while (rs.next()) {
				if (rs.getString(1).equals(usr) && rs.getString(2).equals(pswd)) {
					setUser_id(rs.getInt(0));
					break;
				}
			}
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void metodoPull(Connection conn) {
		try {
					
			String query = "SELECT * FROM planet_stats WHEN USER_ID = " + getUser_id();
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmnt.executeQuery(query);	
			
			//{Metal, deuterio, techD, techA}
			ArrayList<int[]> arrayReasources = new ArrayList<int[]>();
			
			rs.next();
			arrayReasources.add(new int[] {rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7)});
			
			this.setArrayReasources(arrayReasources);
			
			//Battle Reports
			String query0 = "SELECT * FROM battle WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query0);	
			ArrayList<String[]> arrayReportesBatalla = new ArrayList<String[]>();
			
			while (rs.next()) {
				
				arrayReportesBatalla.add(new String[] {rs.getString(3),rs.getString(4)});
			}
			this.setArrayReportesBatalla(arrayReportesBatalla);
			
			//LighHunter
			String query1 = "SELECT * FROM light_hunter WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query1);	
			ArrayList<int[]> arrayLightHunter = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayLightHunter.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			this.setArrayLightHunter(arrayLightHunter);
			
			
//			System.out.println("\nSize =" + arrayLightHunter.size());
//			for (int[] is : arrayLightHunter) {
//				for (int i : is) {
//					System.out.println(i);
//				}
//			}
			
			//HeavyHunter
			String query2 = "SELECT * FROM heavy_hunter WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query2);	
			ArrayList<int[]> arrayHeavytHunter = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayHeavytHunter.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			this.setArrayHeavytHunter(arrayHeavytHunter);
			
			
			//BattleShip
			String query3 = "SELECT * FROM battle_ship WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query3);	
			ArrayList<int[]> arrayBattleShip = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayBattleShip.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			
			this.setArrayBattleShip(arrayBattleShip);
			
			//ArmoredShip
			String query4 = "SELECT * FROM armored_ship WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query4);	
			ArrayList<int[]> arrayArmoredShip = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayArmoredShip.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			
			this.setArrayArmoredShip(arrayArmoredShip);
			
			//MissileLouncher
			String query5 = "SELECT * FROM missile_launcher WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query5);	
			ArrayList<int[]> arrayMissileLouncher = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayMissileLouncher.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			
			this.setArrayMissileLouncher(arrayMissileLouncher);
			
			//IonCannon
			String query6 = "SELECT * FROM ion_cannon WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query6);	
			ArrayList<int[]> arrayIonCannon = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayIonCannon.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			
			this.setArrayIonCannon(arrayIonCannon);
			
			//PlasmaCannon
			String query7 = "SELECT * FROM plasma_cannon WHEN USER_ID = " + getUser_id();
			rs = stmnt.executeQuery(query7);	
			ArrayList<int[]> arrayPlasmaCannon = new ArrayList<int[]>();
			
			while (rs.next()) {
				
				arrayPlasmaCannon.add(new int[] {rs.getInt(2),rs.getInt(3)});
			}
			
			this.setArrayPlasmaCannon(arrayPlasmaCannon);
			
			// ArrayList que guarda cada grupo-unidad-stats
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void metodoPush(Connection conn, Planet p, Battle b) {

		try {
			//Recursos
			String update = "UPDATE planet_stats SET RESOURCE_METAL_AMOUNT = ?, RESOURCE_DAUTERION_AMOUNT = ?,"
					+ "RESOURCE_DEFENSE = ?, RESOURCE_ATTACK = ?"
					+ "WHERE  USER_ID = " + getUser_id();
			
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setInt(1, p.getMetal());
			ps.setInt(2, p.getDeuterium());
			ps.setInt(3, p.getTechnologyDefense());
			ps.setInt(4, p.getTechnologyAtack());
			ps.executeUpdate();
			
			// Reportes Batalla
			int cont = 1;
			String delete = "DELETE FROM battle WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO battle (planet_id, num_battles, battle_stats, battle_log)"
					 + "VALUES (?,?,?,?)";
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			
			ps = conn.prepareStatement(update);
			
			for (String[] infoBatalla : b.getBattleStats()) {
				
				ps.setInt(1,getUser_id());
				ps.setInt(2, cont);
				ps.setString(3, infoBatalla[0]);
				ps.setString(4, infoBatalla[1]);
				ps.executeUpdate();
				cont++;
			}
			
			// Light Hunters
			cont = 1;
			delete = "DELETE FROM light_hunter WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO light_hunter (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[0]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			// Heavy Hunters
			delete = "DELETE FROM heavy_hunter WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO heavy_hunter (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			cont = 1;			
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[1]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			
			// Battle Ship
			delete = "DELETE FROM battle_ship WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO battle_ship (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			cont = 1;	
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[2]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			// Armored Ship
			delete = "DELETE FROM armored_ship WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO armored_ship (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			cont = 1;	
			
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[3]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			// Missile Louncher
			delete = "DELETE FROM missile_launcher WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO missile_launcher (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			cont = 1;	
			
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[4]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			// Ion cannon
			delete = "DELETE FROM ion_cannon WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO ion_cannon (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
					
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			cont = 1;	
			
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[5]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			// Plasma cannon
			delete = "DELETE FROM plasma_cannon WHERE USER_ID = " + getUser_id();
			update = "INSERT INTO plasma_cannon (id, planet_id,armour,atack)"
					+ "VALUES (?,?,?,?)";
					
			
			// Borrar anteriores tropas
			ps = conn.prepareStatement(delete);
			ps.executeUpdate();
			cont = 1;	
			
			ps = conn.prepareStatement(update);
			
			for (MilitaryUnit unit : p.getArmy()[6]) {
				
				ps.setInt(1,cont);
				ps.setInt(2, getUser_id());
				ps.setInt(3, unit.getActualArmor());
				ps.setInt(4, unit.attack());
				ps.executeUpdate();
				cont++;
			}
			
			// Informe stats **
			// Informe log **
			
////		// Utilizar preparedStatemnet ***
////		rs.absolute(1);
////		// Actualizo la BBDD a traves de mi ResultSet
////		rs.updateInt("resource_metal_amount", p.getMetal());
////		rs.updateInt("resource_dauterion_amount", p.getDeuterium());
////		rs.updateInt("resource_defense", p.getTechnologyDefense());
////		rs.updateInt("resource_attack", p.getTechnologyAtack());
////		rs.updateInt("missile_launcher_remaining", units[5]);
////		rs.updateInt("ion_cannon_remaining", units[6]);
////		rs.updateInt("plasma_cannon_remaining", units[0]);
////		rs.updateInt("light_hunter_remaining", units[1]);
////		rs.updateInt("heavy_hunter_remaining", units[2]);
////		rs.updateInt("battle_ship_remaining", units[3]);
////		rs.updateInt("armored_ship_remaining", units[4]);
////		
////		rs.updateRow();
//		
//		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}


}