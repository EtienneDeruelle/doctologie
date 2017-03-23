package connection;

import org.lightcouch.CouchDbClient;

public class ConnectionCouchDB {
	
	private static CouchDbClient connectionCouchDb=null;
	
	private ConnectionCouchDB(){
		
	}
	
	public static CouchDbClient getConnectionCouchDB(){
		
		if(connectionCouchDb == null){ // http://couchdb.telecomnancy.univ-lorraine.fr/orphadatabase/
			CouchDbClient connectionCouchDb = new CouchDbClient("orphadatabase", false, "http", "couchdb.telecomnancy.univ-lorraine.fr", 5984, "", "");
			return connectionCouchDb;
		}else{
			return connectionCouchDb;
		}
	}
	
	
	

}
