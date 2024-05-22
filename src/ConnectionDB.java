import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	private int[] planetStats;
	private ResultSet rs;
	
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
//            // Preparar la inserción de un nuevo registro
////            String insertQuery = "INSERT INTO user_credentials (user_id, user_password, user_name) VALUES (?, ?, ?)";
////            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
////            insertStatement.setInt(1, 65);
////            insertStatement.setString(2, "Contra1");
////            insertStatement.setString(3, "danielin");
////            insertStatement.executeUpdate();
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
//	}
	
	
	public int[] getPlanetStats() {
		return planetStats;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void setPlanetStats(int[] planetStats) {
		this.planetStats = planetStats;
	}
	
	// Metodo de conexion y selector de la accion que quiero (push/pull)
	public void conection( int opc, Planet p) {
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
				 metodoPull(conn);
				break;
			case 2:
				metodoPush(conn, getRs(), p);
				break;
//			case 3:
//				metodoPush
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
	
	public ResultSet metodoPull(Connection conn) {
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM planet_stats";
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmnt.executeQuery(query);	
			
			rs.next();
			int[] planetStats = {
					rs.getInt(4),rs.getInt(5),
					rs.getInt(6),rs.getInt(7),
					rs.getInt(8),rs.getInt(9),
					rs.getInt(10),rs.getInt(11),
					rs.getInt(12),rs.getInt(13),
					rs.getInt(14),rs.getInt(15)};
			
			this.setPlanetStats(planetStats);
			setRs(rs);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return rs;
	}
	

	public void metodoPush(Connection conn, ResultSet rs, Planet p) {
		int [] units = p.getNumberUnits();
		try {
		rs.absolute(1);
		// Actualizo la BBDD a traves de mi ResultSet
		rs.updateInt("resource_metal_amount", p.getMetal());
		rs.updateInt("resource_dauterion_amount", p.getDeuterium());
		rs.updateInt("resource_defense", p.getTechnologyDefense());
		rs.updateInt("resource_attack", p.getTechnologyAtack());
		rs.updateInt("missile_launcher_remaining", units[5]);
		rs.updateInt("ion_cannon_remaining", units[6]);
		rs.updateInt("plasma_cannon_remaining", units[0]);
		rs.updateInt("light_hunter_remaining", units[1]);
		rs.updateInt("heavy_hunter_remaining", units[2]);
		rs.updateInt("battle_ship_remaining", units[3]);
		rs.updateInt("armored_ship_remaining", units[4]);
		
		rs.updateRow();
		
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


}