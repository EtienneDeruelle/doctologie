package connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lightcouch.CouchDbClient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SearchCouchDB {
	
	
	/**
	 * Go search into Orphadata the diseases by the signs
	 * @param signs is a list of signs
	 * @return the list of disease
	 */
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
	
	
}
