package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
	
	private static Connection co =null;
	
	public static Connection getConnectionSQLite(){
		if(co == null){
		    try {
		    	Class.forName("org.sqlite.JDBC");
				co = DriverManager.getConnection("jdbc:sqlite:SQLite/hpo_annotations.sqlite");
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
