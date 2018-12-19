package irfinal;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import Classes.*;
import Classes.Query;
import IndexingLucene.MyIndexReader;
import PseudoRFSearch.*;
import SearchLucene.*;

public class HW4Main {
	
//	static Query aQuery;

	public static void main(String[] args) throws Exception {
		
//		ExtractQuery queries = new ExtractQuery();
//		
//		while (queries.hasNext()) {
////			aQuery = queries.next();
//			queries.
//			
//		}
		
		List<Document> biology = new ArrayList<Document>();
		List<Document> music = new ArrayList<Document>();
		List<Document> politics = new ArrayList<Document>();
		List<Document> psychology = new ArrayList<Document>();

		HW4Main hw4 = new HW4Main();
		biology = hw4.biology();
		music = hw4.music();
		politics = hw4.politics();
		psychology = hw4.psychology();

//		if (biology != null) {
//			int rank = 1;
//			for (Document result : biology) {
//				System.out.println(  " " + result.docno() +" "+ rank);
//				rank++;
//			}
//		}
//		if (music != null) {
//			int rank = 1;
//			for (Document result : music) {
//				System.out.println(  " " + result.docno() +" "+ rank);
//				rank++;
//			}
//		}
		if (politics != null) {
			int rank = 1;
			for (Document result : politics) {
				
				System.out.println(  " " + result.docno() +" "+ rank);
				rank++;
			}
		}
//		if (psychology != null) {
//			int rank = 1;
//			for (Document result : psychology) {
//				System.out.println(  " " + result.docno() +" "+ rank);
//				rank++;
//			}
//		}
	}
	
	public List<Document> biology() throws Exception {
		
//		BufferedReader inputStream = null;
//		Map<String, String> map=new HashMap<>();
//	
//		try {
//			inputStream = new BufferedReader(new FileReader(Path.DataBookDir));
//			String line;
//			while ((line = inputStream.readLine()) != null) {
//				String key=line;
////			System.out.println(key);
//				String text=inputStream.readLine();
////			System.out.println(text);
////      	strBuffer.append(line);
////      	System.out.println(line);
//				map.put(key,text);
//
//
//      	                	
////          System.out.println(Arrays.toString(strBuffer.toString().split("\\s")));
//			}
//		}finally {
//			if (inputStream != null) {
//				inputStream.close();
//			}
//		}
		
		
		
		
		// Open index, initialize the pseudo relevance feedback retrieval model,and extract queries
		MyIndexReader ixreader = new MyIndexReader();
		PseudoRFRetrievalModel PRFSearchModel = new PseudoRFRetrievalModel(ixreader);
		List<Document> results = new ArrayList<Document>();
		ExtractQuery queries = new ExtractQuery();



//		Query aQuery = queries.next();
		
		
		// begin search
//		long startTime = System.currentTimeMillis();
		while (queries.hasNext()) {
			Query aQuery = queries.next();
			if(aQuery.GetTopicId().equals("biology")){
				results = PRFSearchModel.RetrieveQuery(aQuery, 25, 100, 0.4);}
				
//			if (results != null) {
//				int rank = 1;
//				for (Document result : results) {
//					System.out.println(aQuery.GetTopicId() + " " + result.docno() +" "+ rank);
//					rank++;
//				}
//			}
		}
//		long endTime = System.currentTimeMillis(); 
		
		// output running time
//		System.out.println("\n\n4 queries search time: " + (endTime - startTime) / 60000.0 + " min");
		ixreader.close();
		return results;
	}
	
	public List<Document> music() throws Exception {

		MyIndexReader ixreader = new MyIndexReader();
		PseudoRFRetrievalModel PRFSearchModel = new PseudoRFRetrievalModel(ixreader);
		List<Document> results = new ArrayList<Document>();
		ExtractQuery queries = new ExtractQuery();

		while (queries.hasNext()) {
			Query aQuery = queries.next();
			if(aQuery.GetTopicId().equals("music")){
				results = PRFSearchModel.RetrieveQuery(aQuery, 25, 100, 0.4);
			}
		}
		ixreader.close();
		return results;
	}
	
	public List<Document> politics() throws Exception {

		MyIndexReader ixreader = new MyIndexReader();
		PseudoRFRetrievalModel PRFSearchModel = new PseudoRFRetrievalModel(ixreader);
		List<Document> results = new ArrayList<Document>();
		ExtractQuery queries = new ExtractQuery();

		while (queries.hasNext()) {
			Query aQuery = queries.next();
			if(aQuery.GetTopicId().equals("politics")){
				results = PRFSearchModel.RetrieveQuery(aQuery, 25, 100, 0.4);
//				if(results != null);
			}
		}
		ixreader.close();
		return results;
	}
	
	public List<Document> psychology() throws Exception {

		MyIndexReader ixreader = new MyIndexReader();
		PseudoRFRetrievalModel PRFSearchModel = new PseudoRFRetrievalModel(ixreader);
		List<Document> results = new ArrayList<Document>();
		ExtractQuery queries = new ExtractQuery();

		while (queries.hasNext()) {
			Query aQuery = queries.next();
			if(aQuery.GetTopicId().equals("psychology")){
				results = PRFSearchModel.RetrieveQuery(aQuery, 25, 100, 0.4);
			}
		}
		ixreader.close();
		return results;
	}
	
}
