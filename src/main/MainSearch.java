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
		
		diseasesOrphadata.clear();
		// Orphadata
		ArrayList<String> signs = new ArrayList<String>();
		
		String[] listSigns = null;
		listSigns = request.split(";");
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
		ArrayList<String> diseasesOmimClean = new ArrayList<String>();
		ArrayList<String> diseasesOrphadataClean = new ArrayList<String>();
		
		for(int i = 0; i<diseasesOmim.size(); i++)
		{
			if(!diseasesOmimClean.contains(diseasesOmim.get(i)))
				diseasesOmimClean.add(diseasesOmim.get(i));
		}
		for(int i = 0; i<diseasesOrphadata.size(); i++)
		{
			if(!diseasesOrphadataClean.contains(diseasesOrphadata.get(i)))
				diseasesOrphadataClean.add(diseasesOrphadata.get(i));
		}
		//List<String> sublistOmim = diseasesOmimClean.subList(1, diseasesOmimClean.size()); Collections.sort(sublistOmim);
		//List<String> sublistOrpha = diseasesOrphadataClean.subList(1, diseasesOrphadataClean.size()); Collections.sort(sublistOrpha);
		DiseasesCollection dc = new DiseasesCollection(diseasesOmimClean,diseasesOrphadataClean);
		return dc;
	}
	
	public static ArrayList<String> searchDrugBySign(String request){
		
		// Sider
		ArrayList<String> idStitch = new ArrayList<String>(); // structure pour transformer request en tableau de String
		String[] listSigns = request.split(";"); // on separe avec le separateur ";"
		for (int i = 0 ; i<listSigns.length ; i++){ // on boucle pour sur chaque symptomes afin d'en retirer les id de chaque symtpome
			idStitch.addAll(SearchSider.getIdStitchByIdSign(listSigns[i])); // on va chercher les id associer aux symptomes
		}// peut etre des redondance dans idStitch
				
		//Stitch
		String request2 = "";
		for( int i = 0 ; i < idStitch.size() ; i++){ // il faut retransformer pour obtenir une request dans la fonction pour aller chercher les id
			request2=request2+idStitch.get(i)+" "; // on ajoute les idsymptomes dans une chaine de caractere separe par des espaces
		}
		ArrayList<ArrayList<String>> listIdATC = new ArrayList<ArrayList<String>>();
		try {
			SearchFilesStitch.main2(request2);// on va chercher les idATC dans Stitch
			listIdATC = SearchFilesStitch.getResultlist(); // on les recupere dans une variable
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ATC
		String request3 = "";
		for( int i = 0 ; i < listIdATC.size() ; i++){ // il faut retransformer pour obtenir une request dans la fonction pour aller chercher les noms de medicaments
			request3=request3+listIdATC.get(i).get(0)+" "; // on ajoute les idATC dans une chaine de caractere separe par des espaces
		}
		ArrayList<ArrayList<String>> listDrug = new ArrayList<ArrayList<String>>();
		try {
			SearchFilesATC.main2(request3);// on va chercher les medoc dans ATC
			listDrug = SearchFilesStitch.getResultlist(); // on les recupere dans une variable
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// on prepare le tableau de medoc pour le return
		ArrayList<String> drugs = new ArrayList<String>();
		for(int i = 0 ; i < listDrug.size() ; i++){// on recupere tout les nom de medicament pour les mettre dans un meme tableau
			drugs.add(listDrug.get(i).get(1));
		}
		
		return drugs;
	}
	

}
