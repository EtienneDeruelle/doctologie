package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchSider {
	
		public static ArrayList<String> getIdStitchByIdSign(String sign){
			Connection co = ConnectionMySQL.getConnectionMySQL();
			ArrayList<String> listIdStitch = new ArrayList<String>();
			try {
				Statement stmt = co.createStatement();
				ResultSet res = stmt.executeQuery("SELECT DISTINCT stitch_compound_id FROM meddra_all_indications WHERE concept_name LIKE '%"+sign+"%';");
				while(res.next()){
					listIdStitch.add(res.getString(1));
				}
				res.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listIdStitch;
		}

}
