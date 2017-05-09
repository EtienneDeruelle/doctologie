package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.tools.DiagnosticCollector;

import org.lightcouch.CouchDbClient;

import connection.ConnectionCouchDB;
import connection.ConnectionMySQL;
import connection.SearchCouchDB;
import connection.SearchHPO_Annotation;
import connection.SearchSider;
import display.DiseaseWindow;
import display.MainWindow;

/*
import connection.ConnectionSQLite;
import sqlite.SQLiteRequest;
*/



public class Main {
	
	private static MainWindow window ;
	private static DiseaseWindow window2 ;
	
	public static void main(String[] args) throws IOException {
		//SQLiteRequest.requestByIdDisease(14);
		
		//MainSearch.searchDiseaseBySign("urine");
		
		
		//window = new MainWindow();
		window2 = new DiseaseWindow();
		window2.setVisible(true);
	}

}
