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
				
		List<JsonObject> allDocs = co.view("clinicalsigns/GetDiseaseByClinicalSign").query(JsonObject.class);		
		ArrayList<String> selectedDiseases = new ArrayList<String>();
		boolean disease = true;
		for (JsonObject doc : allDocs){
			disease = true;
			for(int j = 0 ; j<signs.size() ; j++){
				if(!doc.toString().contains(signs.get(j).toString())){
					disease=false;
					break;
				}
			}
			if(disease){
				JsonElement je  = doc.get("value");
				JsonObject docDisease = je.getAsJsonObject();
				je = docDisease.get("disease");
				docDisease = je.getAsJsonObject();
				je = docDisease.get("Name");
				docDisease = je.getAsJsonObject();
				je = docDisease.get("text");
				String diseaseText = je.getAsString();
				
				selectedDiseases.add(diseaseText);
				System.out.println(diseaseText);
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
