package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lightcouch.CouchDbClient;

import business.DiseasesCollection;
import connection.ConnectionCouchDB;
import connection.SearchCouchDB;
import connection.SearchHPO_Annotation;
import connection.SearchSider;
/*
import connection.ConnectionSQLite;
import sqlite.SQLiteRequest;
*/
import display.MainWindow;
import index.IndexFilesATC;
import index.IndexFilesObo;
import index.IndexFilesOmim;
import index.IndexFilesStitch;
import index.SearchFilesATC;
import index.SearchFilesObo;
import index.SearchFilesOmim;
import index.SearchFilesStitch;


/**
 * This class allows to start the search on the different bases
 * 
 * @author utilisateur
 *
 */
public class MainSearch {
	
	/**
	 *  Constructor of the class MainSearch
	 */
	public MainSearch() {}
	
	private static MainWindow window ;
	
	/**
	 * This class allows to launch a search for diseases with symptoms
	 * 
	 * @param request
	 * @return a collection of rare and genetic diseases
	 */
	public static DiseasesCollection searchDiseaseBySign(String request){
		ArrayList<String> diseasesOrphadata = new ArrayList<String>();
		ArrayList<ArrayList<String>> diseasesHPO = new ArrayList<ArrayList<String>>();
		
		diseasesOrphadata.clear();
		// Orphadata
		ArrayList<String> signs = new ArrayList<String>();
		
		String[] listSigns = null;
		listSigns = request.split(";");//Allows to take all the synonyms that the user to enter
		for (int i = 0 ; i<listSigns.length ; i++){
			signs.add(listSigns[i]);
		}
		diseasesOrphadata = SearchCouchDB.getDiseaseBySign(signs);
		
		// HPO
		try {
			SearchFilesObo.main2(request);//Allows to make a search in the files of Obo
			diseasesHPO = SearchFilesObo.getResultlist();//Retrieves the data from Obo
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> diseasesHPOClean = new ArrayList<String>();
		for(int i = 0 ; i < diseasesHPO.size() ; i++){
			//System.out.println(diseasesHPO);
			//Removing duplicates
			if(!diseasesHPOClean.contains(diseasesHPO.get(i).get(0))){
				diseasesHPOClean.add(diseasesHPO.get(i).get(0));
			}
		}

		// HPO_annotations
		ArrayList<String> listIdDiseases = new ArrayList<String>();
		
		for(int i = 0 ; i < diseasesHPOClean.size() ; i++){
			listIdDiseases.addAll(SearchHPO_Annotation.getIdDiseaseByIdSign("HP:"+diseasesHPOClean.get(i)));
		}

		// OMIM
		ArrayList<ArrayList<String>> listDiseases = new ArrayList<ArrayList<String>>();
		for(int i = 0 ; i<listIdDiseases.size() ; i++){
			try {
				SearchFilesOmim.main2(listIdDiseases.get(i));//Allows to make a search in the files of Omim
			} catch (Exception e) {
				e.printStackTrace();
			}
			listDiseases.addAll(SearchFilesOmim.getResultlist());//	Retrieves the result of the search by Omim
		}
		
		ArrayList<String> diseasesOmim = new ArrayList<String>();
		for(int i = 0 ; i< listDiseases.size() ; i++){
			diseasesOmim.add(listDiseases.get(i).get(0));//Fill the Omim Diseases Chart
		}
		ArrayList<String> diseasesOmimClean = new ArrayList<String>();
		ArrayList<String> diseasesOrphadataClean = new ArrayList<String>();
		
		//This loop allows to remove the redundancies of the results found in Omim
		for(int i = 0; i<diseasesOmim.size(); i++)
		{
			if(!diseasesOmimClean.contains(diseasesOmim.get(i)))
				diseasesOmimClean.add(diseasesOmim.get(i));
		}
		//This loop allows to remove the redundancies of the results found in Orphadatabase
		for(int i = 0; i<diseasesOrphadata.size(); i++)
		{
			if(!diseasesOrphadataClean.contains(diseasesOrphadata.get(i)))
				diseasesOrphadataClean.add(diseasesOrphadata.get(i));
		}
		
		DiseasesCollection dc = new DiseasesCollection(diseasesOmimClean,diseasesOrphadataClean);
		return dc;
	}
	
	/**
	 * This class allows to launch a search for drug with symptoms
	 * 
	 * @param request
	 * @return returns medications
	 */
	public static ArrayList<String> searchDrugBySign(String request){
		
		// Sider
		ArrayList<String> idStitch = new ArrayList<String>(); // Structure to transform request into a String array
		String[] listSigns = request.split(";"); // We separate with the separator ";"
		for (int i = 0 ; i<listSigns.length ; i++){ // We loop for on each symptom in order to remove the id of each symtpome
			idStitch.addAll(SearchSider.getIdStitchByIdSign(listSigns[i])); // We will look for id to associate symptoms
		}
		
		
		//Stitch
		String request2 = "";
		for( int i = 0 ; i < idStitch.size() ; i++){ // it is necessary to re-transform to obtain a request in the function to fetch the id
			request2=request2+idStitch.get(i).substring(4)+" "; // We add the idsymptoms in a character string separated by spaces
		}
		ArrayList<ArrayList<String>> listIdATC = new ArrayList<ArrayList<String>>();
		try {
			SearchFilesStitch.main2(request2);// We will look for idATC in Stitch
			listIdATC = SearchFilesStitch.getResultlist(); // They are recovered into a variable
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ATC
		String request3 = "";
		for( int i = 0 ; i < listIdATC.size() ; i++){ // It is necessary to re-transform to obtain a request in the function to fetch the names of drugs
			request3=request3+listIdATC.get(i).get(1)+" "; // We add the idATC in a string of characters separated by spaces
			if(!listIdATC.get(i).get(1).equals(listIdATC.get(i).get(2))){
				request3=request3+listIdATC.get(i).get(2)+" ";
			}
		}
		for( int i = 0 ; i < listIdATC.size() ; i++){ // It is necessary to re-transform to obtain a request in the function to fetch the names of drugs
			request3=request3+listIdATC.get(i).get(2)+" "; // We add the idATC into a string of characters separated by spaces
		}
		ArrayList<ArrayList<String>> listDrug = new ArrayList<ArrayList<String>>();
		try {
			SearchFilesATC.main2(request3);// We will look for the drugs in ATC
			listDrug = SearchFilesATC.getResultlist(); // They are recovered in a variable
		} catch (Exception e) {
			e.printStackTrace();
		}
		// We prepare the table of drugs for the return
		ArrayList<String> drugs = new ArrayList<String>();
		for(int i = 0 ; i < listDrug.size() ; i++){// We recover all the name of drugs to put them in a same table
			drugs.add(listDrug.get(i).get(1));
		}
		
		return drugs;
	}
	

}
