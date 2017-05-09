package index;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */







import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/** Index all text files under a directory.
 * <p>
 * This is a command-line application demonstrating simple Lucene indexing.
 * Run it with no command-line arguments for usage information.
 */
public class IndexFilesStitch2 {
	   
	   private IndexFilesStitch2() {}
	 
	   /** Index all text files under a directory.
	 * @throws IOException 
	 * @throws BiffException 
	 * @throws IndexOutOfBoundsException */
	   public static void main(String[] args) throws IOException, IndexOutOfBoundsException, BiffException {
	    
	     String indexPath = "indexStitch";
	     //String dbPath = "./chemical_sources.xls";//"./drugbank.txt";
	     String dbPath = "./chemical.sources.v5.0a.xls";//"./drugbank.txt";

	     Sheet contentSheet = Workbook.getWorkbook(new File( dbPath)).getSheet(0);
	 
	     String currentColumn = "";
	       Directory dir = FSDirectory.open(Paths.get(indexPath));
	       Analyzer analyzer = new StandardAnalyzer();
	       IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
	       IndexWriter writer = new IndexWriter(dir, iwc);
	        for (int i = 0; i < contentSheet.getColumns(); i++) {
	            Cell[] xlCells = contentSheet.getColumn(i);
	            currentColumn = xlCells[0].getContents();
	            //System.out.println(currentColumn);
	            StringBuffer sb = new StringBuffer();
	            
	            for (int j = 1; j < xlCells.length; j++) {
	                sb.append(xlCells[j].getContents() + " ");
	                
	            }
	            addDoc(writer, sb.toString(), currentColumn);


	        }
	        writer.close();
	    }

	   private static void addDoc(IndexWriter w, String value, String fieldName)
	            throws IOException {
	        Document doc = new Document();
	        //System.out.println(fieldName);
	        //System.out.println(value);
	        doc.add(new TextField(fieldName, value, Field.Store.YES));
	        System.out.println(fieldName+value);
	        w.addDocument(doc);
	    }


}