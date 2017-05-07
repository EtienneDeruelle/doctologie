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


public class Main {
<<<<<<< HEAD

	public static void main(String[] args) {
		
		
=======
	
	private static MainWindow window ;
	
	public static void main(String[] args) throws IOException {
		//SQLiteRequest.requestByIdDisease(14);
>>>>>>> 292f03d9f5fed9f59dc5d7b751858bf127cf51cb
		
		window = new MainWindow();
		
	}

}
