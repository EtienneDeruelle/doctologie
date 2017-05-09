package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.lightcouch.CouchDbClient;

import connection.ConnectionCouchDB;
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



public class MainTest {
	
	private static MainWindow window ;
	
	public static void main(String[] args) throws Exception {
		//SQLiteRequest.requestByIdDisease(14);
		
		
		 System.out.println("Entrez votre requete :");
		 String queryString = null;
		 BufferedReader in = null;
		 in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		 String line = queryString != null ? queryString : in.readLine();
		    
		    
		//window = new MainWindow();
		IndexFilesATC IndexATC ;
		IndexFilesObo IndexObo ;
		IndexFilesOmim IndexOmim ;
		IndexFilesStitch IndexStitch ;
		
		SearchFilesATC SearchATC = null  ;
		SearchFilesObo SearchObo = null ;
		SearchFilesOmim SearchOmim = null ;
		SearchFilesStitch SearchStitch = null ;
		
		//SearchOmim.main2("tyrosine");
		
		//SearchOmim.main2(line);
		//SearchObo.main2(line);
		//SearchATC.main2(line);
		SearchStitch.main2(line);
		
		System.out.println("/////////////" + SearchObo.getResultlist().size() );
		
		for(int i = 1; i <= SearchObo.getResultlist().size()-1; i++)
		{
			//System.out.println(SearchObo.getResultlist().get(i).get(0) );
			System.out.println(SearchObo.getResultlist().get(i) );
			
		}
		
		
		for(int i = 1; i <= SearchOmim.getResultlist().size()-1; i++)
		{
			//System.out.println(SearchObo.getResultlist().get(i).get(0) );
			System.out.println(SearchOmim.getResultlist().get(i).get(0) );
			
		}
		
		for(int i = 1; i <= SearchATC.getResultlist().size()-1; i++)
		{
			//System.out.println(SearchObo.getResultlist().get(i).get(0) );
			System.out.println(SearchATC.getResultlist().get(i).get(0) );
			
		}
		
		for(int i = 1; i <= SearchStitch.getResultlist().size()-1; i++)
		{
			//System.out.println(SearchObo.getResultlist().get(i).get(0) );
			System.out.println(SearchStitch.getResultlist().get(i).get(0) );
			
		}
		
		//System.out.println(SearchOmim.getHits().toString());
	}

}
