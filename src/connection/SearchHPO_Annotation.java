package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchHPO_Annotation {
	
	// à tester
	public static ArrayList<String> getIdSignByIdDisease(String idDisease){
		Connection co = ConnectionSQLite.getConnectionSQLite();
		ArrayList<String> listIdSign = new ArrayList<String>();
		try {
			Statement stmt = co.createStatement();
			ResultSet res = stmt.executeQuery("SELECT disease_id FROM phenotype_annotation WHERE disease_id='"+idDisease+"';");
			while(res.next()){
				listIdSign.add(res.getString(0));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listIdSign;
	}
	
	//à tester
	public static ArrayList<String> getIdDiseaseByIdSign(String idSign){
		Connection co = ConnectionSQLite.getConnectionSQLite();
		ArrayList<String> listIdDisease = new ArrayList<String>();
		try {
			Statement stmt = co.createStatement();
			ResultSet res = stmt.executeQuery("SELECT sign_id FROM phenotype_annotation WHERE sign_id='"+idSign+"';");
			while(res.next()){
				listIdDisease.add(res.getString(0));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listIdDisease;
	}


}