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

}
