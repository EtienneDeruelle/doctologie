package connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lightcouch.CouchDbClient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SearchCouchDB {
	
	
	public static ArrayList<String> getDiseaseBySign(ArrayList<String> signs){
		CouchDbClient co = ConnectionCouchDB.getConnectionCouchDB();
		ArrayList<String> selectedDiseases = new ArrayList<String>();
		String diseaseText = "";
		
		for( int i = 0 ; i<signs.size() ; i++ ){
			ArrayList<JsonObject> allDocs = (ArrayList<JsonObject>) co.view("clinicalsigns/GetDiseaseByClinicalSign").startKey(signs.get(0)).endKey(signs.get(0)+"z").query(JsonObject.class);
			for(JsonObject doc : allDocs){
				if(doc.toString().contains(signs.get(i).toString())){
					JsonElement je  = doc.get("value");
					JsonObject docDisease = je.getAsJsonObject();
					je = docDisease.get("disease");
					docDisease = je.getAsJsonObject();
					je = docDisease.get("Name");
					docDisease = je.getAsJsonObject();
					je = docDisease.get("text");
					diseaseText = je.getAsString();
					selectedDiseases.add(diseaseText);
				}
			}
			
		}

		co.shutdown();		
		return selectedDiseases;
		
	}
	
	public static void findDoc(CouchDbClient connectionCouchDb) throws IOException
	{
		
		System.out.println("all Docs");
		List<JsonObject> allDocs = connectionCouchDb.view("_all_docs").query(JsonObject.class);
		
		for (JsonObject doc : allDocs)
		{
			System.out.println(doc);
		}
	}
	
	
	/**
	 * InputStream in = connectionCouchDb.find("_design/diseases"); 
		// ..
		while(in.read()!=-1)
			System.out.println(in);
		in.close(); // close stream
	 */
	
}
