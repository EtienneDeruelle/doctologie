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

/** Index all text files under a directory.
 * <p>
 * This is a command-line application demonstrating simple Lucene indexing.
 * Run it with no command-line arguments for usage information.
 */
public class IndexFilesATC {
	   
	   private IndexFilesATC() {}
	 
	   /** Index all text files under a directory.
	 * @throws IOException */
	   public static void main2(String[] args) throws IOException {
	    
	     String indexPath = "indexATC";
	     String dbPath = "./kegg3.keg";//"./drugbank.txt";

	    
	 
	     final File dbFile = new File(dbPath);
	     if (!dbFile.exists()) {
	       System.out.println("the db file '" +dbFile.getCanonicalPath()+ "' does not exist or is not readable, please check the path");
	       System.exit(1);
	     }
	     
	     Date start = new Date();
	     try {
	       System.out.println("Indexing to directory '" + indexPath + "'...");
	 
	       Directory dir = FSDirectory.open(Paths.get(indexPath));
	       Analyzer analyzer = new StandardAnalyzer();
	       IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
	 
	       iwc.setOpenMode(OpenMode.CREATE);
	 
	       IndexWriter writer = new IndexWriter(dir, iwc);
	       indexDoc(writer, dbFile);

	       writer.close();
	 
	       Date end = new Date();
	       System.out.println(end.getTime() - start.getTime() + " total milliseconds");
	 
	     } catch (IOException e) {
	       System.out.println(" caught a " + e.getClass() +
	        "\n with message: " + e.getMessage());
	     }
	   }
	 


/**
* Indexes the given file using the given writer, or if a directory is given,
* recurses over files and directories found under the given directory.
* 
* NOTE: This method indexes one document per input file.  This is slow.  For good
* throughput, put multiple documents into your input file(s).  An example of this is
* in the benchmark module, which can create "line doc" files, one document per line,
* using the
* <a href="../../../../../contrib-benchmark/org/apache/lucene/benchmark/byTask/tasks/WriteLineDocTask.html"
* >WriteLineDocTask</a>.
*  
* @param writer Writer to the index where the given file/dir info will be stored
* @param path The file to index, or the directory to recurse into to find files to index
* @throws IOException If there is a low-level I/O error

/** Indexes a single document */
	   static void indexDoc(IndexWriter writer, File file) throws IOException {
 
   
   InputStream stream = new FileInputStream(file);
   InputStreamReader ipsr = new InputStreamReader(stream);
   BufferedReader br = new BufferedReader(ipsr);
   String line = null;
   Document doc = null;
   
   while((line=br.readLine())!=null){


	   if((line.startsWith("E"))){
           doc = new Document();
           String id = "";
           id=line.substring(9, 17);
           System.out.println(id);
           doc.add(new TextField("id", id, Field.Store.YES));
           
           String name = "";
		   name=line.substring(17);
		   System.out.println(name);
		   //line.substring(0,line.length()-15);
           doc.add(new TextField("name", name, Field.Store.YES));
           writer.addDocument(doc);
       }
       
       if(line.startsWith("F")){
    	   doc = new Document();
           String id = "";
           id=line.substring(11, 17);
           System.out.println(id);
           doc.add(new TextField("id", id, Field.Store.YES));
           
           String name = "";
		   name=line.substring(19);
		   System.out.println(name);
		   //line.substring(0,line.length()-15);
           doc.add(new TextField("name", name, Field.Store.YES));
           writer.addDocument(doc);
         
       }
     
   }
 
 
}
}