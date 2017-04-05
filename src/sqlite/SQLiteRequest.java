package sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionSQLite;

public class SQLiteRequest {
	
	public static ArrayList<Integer> requestByIdSign(String diseaseIdSearch){
		ArrayList<Integer> listIdDisease = new ArrayList<Integer>(); 
		try {
			Connection co = ConnectionSQLite.getConnectionSQLite();
			Statement stmt = co.createStatement();
			String requete = "SELECT disease_id FROM phenotype_annotation WHERE disease_id='"+diseaseIdSearch+"'";
			ResultSet res = stmt.executeQuery(requete);
			while(res.next()){
				Integer diseaseId = res.getInt("disease_id");
				listIdDisease.add(diseaseId);
			}
		} catch (SQLException e) {
			System.out.println("error statement requestByIdSign");
			e.printStackTrace();
		}
		return listIdDisease;
	}
	
	public static ArrayList<String> requestByIdDisease(int signIdSearch){
		ArrayList<String> listIdSign = new ArrayList<String>();
		try {
			Connection co = ConnectionSQLite.getConnectionSQLite();
			Statement stmt = co.createStatement();
			String requete = "SELECT sign_id FROM phenotype_annotation WHERE disease_id='"+signIdSearch+"'";
			ResultSet res = stmt.executeQuery(requete);
			while(res.next()){
				String signId = res.getString("sign_id");
				listIdSign.add(signId);
			}
			
		} catch (SQLException e) {
			System.out.println("error statement requestByIdDisease");
			e.printStackTrace();
		}
		return listIdSign;
	}

}
