package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.lightcouch.CouchDbClient;

import connection.ConnectionCouchDB;
import connection.ConnectionSQLite;
import sqlite.SQLiteRequest;
import display.MainWindow;


public class Main {
	
	private static MainWindow window ;
	
	public static void main(String[] args) {
		SQLiteRequest.requestByIdDisease(14);
		
		window = new MainWindow();
		
	}

}
