package main;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.tools.DiagnosticCollector;

import org.lightcouch.CouchDbClient;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.google.gson.JsonObject;

import connection.ConnectionCouchDB;
import connection.ConnectionMySQL;
import connection.SearchCouchDB;
import connection.SearchHPO_Annotation;
import connection.SearchSider;
import display.MainWindow;
import display.TopPanel;





public class Main {
	
	private static MainWindow window ;
	
	public static void main(String[] args) throws IOException {
		
		window = new MainWindow();

		TopPanel.getGBut().setBackground(new Color(50,205,50));
	}

}
