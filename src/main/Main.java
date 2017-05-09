package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.lightcouch.CouchDbClient;

import connection.ConnectionCouchDB;
import connection.ConnectionMySQL;
import connection.SearchCouchDB;
import connection.SearchHPO_Annotation;
import connection.SearchSider;
import display.MainWindow;

/*
import connection.ConnectionSQLite;
import sqlite.SQLiteRequest;
*/



public class Main {
	
	private static MainWindow window ;
	
	public static void main(String[] args) throws IOException {
		//SQLiteRequest.requestByIdDisease(14);
		
		// test avec couchDB
		System.out.println(" on a passé la connection");
		CouchDbClient co = ConnectionCouchDB.getConnectionCouchDB();
		ArrayList<String> signs = new ArrayList<>();
		signs.add("dry eyes");
		signs.add("Xerophthalmia");
		SearchCouchDB.getDiseaseBySign(signs);
		co.shutdown();
		window = new MainWindow();
		
	}

}
