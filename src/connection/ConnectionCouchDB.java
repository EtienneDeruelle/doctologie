package connection;

import org.lightcouch.CouchDbClient;

public class ConnectionCouchDB {
	
	private static CouchDbClient connectionCouchDb=null;
	
	private ConnectionCouchDB(){
		
	}
	
	public static CouchDbClient getConnectionCouchDB(){
		
		if(connectionCouchDb == null){ // http://couchdb.telecomnancy.univ-lorraine.fr/orphadatabase/
			System.out.println("on est dans la fonction connection si connection null avant de se connecter");
			CouchDbClient connectionCouchDb = new CouchDbClient("orphadatabase", false, "http", "couchdb.telecomnancy.univ-lorraine.fr", 0, "martins24u", "CouchDB2A");
			System.out.println("on est dans la fonction connection si connection null");
			return connectionCouchDb;
		}else{
			System.out.println("on est dans la fonction connection si connection pas null");
			return connectionCouchDb;
		}
		
	}
	

}
