package main;

import org.lightcouch.CouchDbClient;

import connection.ConnectionCouchDB;



public class Main {

	public static void main(String[] args) {
		CouchDbClient co = ConnectionCouchDB.getConnectionCouchDB();

	}

}
