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

import org.lightcouch.CouchDbClient;

import business.DiseasesCollection;
import connection.ConnectionCouchDB;
import connection.SearchCouchDB;
import connection.SearchHPO_Annotation;
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



public class MainSearch {
	
	public MainSearch() {}
	
	private static MainWindow window ;
	
	public static void main2(String request) throws Exception {
		
		
		SearchFilesATC SearchATC = null  ;
		SearchFilesObo SearchObo = null ;
		SearchFilesOmim SearchOmim = null ;
		SearchFilesStitch SearchStitch = null ;
		
		ArrayList<ArrayList<String>> ResultlistObo = new ArrayList<ArrayList<String>>();
		
		SearchObo.main2(request);
		ResultlistObo = SearchObo.getResultlist();
		
		System.out.println(ResultlistObo);
		//SearchOmim.main2(line);
		//SearchObo.main2(line);
		//SearchATC.main2(line);
		//SearchStitch.main2(line);
		
	}
	
	public static DiseasesCollection searchDiseaseBySign(String request){
		ArrayList<String> diseasesOrphadata = new ArrayList<String>();
		ArrayList<ArrayList<String>> diseasesHPO = new ArrayList<ArrayList<String>>();
		
		// Orphadata
		ArrayList<String> signs = new ArrayList<String>();
		String[] listSigns = request.split(";");
		for (int i = 0 ; i<listSigns.length ; i++){
			signs.add(listSigns[i]);
		}
		diseasesOrphadata = SearchCouchDB.getDiseaseBySign(signs);
		
		// HPO
		try {
			SearchFilesObo.main2(request);
			diseasesHPO = SearchFilesObo.getResultlist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> diseasesHPOClean = new ArrayList<String>();
		for(int i = 0 ; i < diseasesHPO.size() ; i++){
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
				SearchFilesOmim.main2(listIdDiseases.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
			listDiseases.addAll(SearchFilesOmim.getResultlist());
		}
		
		ArrayList<String> diseasesOmim = new ArrayList<String>();
		for(int i = 0 ; i< listDiseases.size() ; i++){
			diseasesOmim.add(listDiseases.get(i).get(0));
			
		}
		
		DiseasesCollection dc = new DiseasesCollection(diseasesOmim,diseasesOrphadata);
		return dc;
	}
	

}
