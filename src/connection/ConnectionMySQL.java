package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	
private static Connection co =null;
private final static String login = "gmd-read" ;
private final static String mdp = "esial" ;

	/**
	 *  Make the connection with the database Sider
	 * @return MySQL database connection
	 */
	public static Connection getConnectionMySQL(){
		if(co == null){
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				co = DriverManager.getConnection("jdbc:mysql://neptune.telecomnancy.univ-lorraine.fr/gmd", login, mdp);
				System.out.println("connection sucessfully");
		    } catch (SQLException e) {
				System.out.println("error connection");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("error class not found");
				e.printStackTrace();
			}
		}
		return co;
	}
	
	public Connection getCo() {
		return co;
	}

	public void setCo(Connection co) {
		this.co = co;
	}
}
