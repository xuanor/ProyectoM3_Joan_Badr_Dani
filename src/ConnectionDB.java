import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	public static void main(String[] args) {
		//System.out.println("Probando");
		//String urlDatos = "jdbc:oracle:thin:@192.168.56.101:1521/orcl";
		String urlDatos =  "jdbc:oracle:thin:@localhost:1521/orcl";
		String usuario = "ogame";
		String pass = "ogame";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
			if (conn != null) {
				System.out.println("Connected with connection");
			}
			
//			String query = "SELECT * FROM user_credentials";
//
//			
//			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			
//			ResultSet rs = stmnt.executeQuery(query);
//			
//			while(rs.next()) {
//			System.out.println("ID = " + rs.getInt(1) + ", Password = " + rs.getString(2) + ", Name = " + rs.getString(3));
//			}
//			
			
            // Preparar la inserción de un nuevo registro
//            String insertQuery = "INSERT INTO user_credentials (user_id, user_password, user_name) VALUES (?, ?, ?)";
//            PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
//            insertStatement.setInt(1, 65);
//            insertStatement.setString(2, "Contra1");
//            insertStatement.setString(3, "danielin");
//            insertStatement.executeUpdate();
            
			// TABLAS
			// UserCredentials
			// Planet stats
				// Battle stats
					// Planet battle defense
					// Planet battle army
					// Enemy battle army
				// Battle log
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Conexion no realizada");
			e.printStackTrace();
		}
	}
	
//	public ResultSet metodoPull() {
//		ResultSet rs = 
//		return 
//	}
	
	public void metodoPush() {
		
	}
}