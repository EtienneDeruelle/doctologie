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
		
		MainSearch.searchDiseaseBySign("urine");
		
		
		window = new MainWindow();
		
	}

}
