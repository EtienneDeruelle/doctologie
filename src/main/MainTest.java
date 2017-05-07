package main;

import java.io.IOException;
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
		
		//window = new MainWindow();
		IndexFilesATC IndexATC ;
		IndexFilesObo IndexObo ;
		IndexFilesOmim IndexOmim ;
		IndexFilesStitch IndexStitch ;
		
		SearchFilesATC SearchATC ;
		SearchFilesObo SearchObo ;
		SearchFilesOmim SearchOmim = null ;
		SearchFilesStitch SearchStitch ;
		
		SearchOmim.main2("tyrosine");
		
		System.out.println("/////////////" + SearchOmim.getResultlist().size() );
		
		for(int i = 1; i <= SearchOmim.getResultlist().size()-1; i++)
		{
			System.out.println(SearchOmim.getResultlist().get(i).get(0) );
			
		}
		
		
		//System.out.println(SearchOmim.getHits().toString());
	}

}
