package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchHPO_Annotation {
	
	
	/**
	 * Search into HPO_annotations the id of signs possible for the id disease in param
	 * @param idDisease is the id of the disease that we search the id of the signs possible
	 * @return the id of the signs possible
	 */
	public static ArrayList<String> getIdSignByIdDisease(String idDisease){
		Connection co = ConnectionSQLite.getConnectionSQLite();
		ArrayList<String> listIdSign = new ArrayList<String>();
		try {
			Statement stmt = co.createStatement();
			ResultSet res = stmt.executeQuery("SELECT DISTINCT sign_id FROM phenotype_annotation WHERE disease_id='"+idDisease+"';");
			while(res.next()){
				listIdSign.add(res.getString(1));
			}
			res.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listIdSign;
	}
	
	/**
	 * Search the id diseases possible for the id sign in param
	 * @param idSign is the id of sign that we search the id diseases possible
	 * @return the list of the id diseases possible
	 */
	public static ArrayList<String> getIdDiseaseByIdSign(String idSign){
		Connection co = ConnectionSQLite.getConnectionSQLite();
		ArrayList<String> listIdDisease = null;
		listIdDisease= new ArrayList<String>();
		try {
			Statement stmt = co.createStatement();
			ResultSet res = null;
			res = stmt.executeQuery("SELECT DISTINCT disease_id FROM phenotype_annotation WHERE sign_id='"+idSign+"';");
			while(res.next()){
				listIdDisease.add(res.getString(1));
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
