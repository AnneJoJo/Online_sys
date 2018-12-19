package PseudoRFSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import Classes.Document;
import Classes.Query;
import IndexingLucene.MyIndexReader;
import IndexingLucene.PreProcessedCorpusReader;
import SearchLucene.QueryRetrievalModel;

public class PseudoRFRetrievalModel {

	MyIndexReader ixreader;
	PreProcessedCorpusReader corpus;
	int totalnum = 0;
    private Map<Integer, Double> scoremap;
	
	public PseudoRFRetrievalModel(MyIndexReader ixreader) throws IOException
	{
		this.ixreader=ixreader;
		corpus = new PreProcessedCorpusReader();
		Map<String, String> doc = null;
		while ((doc = corpus.nextDocument()) != null) {
			String docno = doc.keySet().iterator().next();
			String content = doc.get(docno);
			totalnum = totalnum + content.length();
		}
	}
	
	/**
	 * Search for the topic with pseudo relevance feedback in 2017 spring assignment 4. 
	 * The returned results (retrieved documents) should be ranked by the score (from the most relevant to the least).
	 * 
	 * @param aQuery The query to be searched for.
	 * @param TopN The maximum number of returned document
	 * @param TopK The count of feedback documents
	 * @param alpha parameter of relevance feedback model
	 * @return TopN most relevant document, in List structure
	 */
	public List<Document> RetrieveQuery( Query aQuery, int TopN, int TopK, double alpha) throws Exception {	
		// this method will return the retrieval result of the given Query, and this result is enhanced with pseudo relevance feedback
		// (1) you should first use the original retrieval model to get TopK documents, which will be regarded as feedback documents
		// (2) implement GetTokenRFScore to get each query token's P(token|feedback model) in feedback documents
		// (3) implement the relevance feedback model for each token: combine the each query token's original retrieval score P(token|document) with its score in feedback documents P(token|feedback model)
		// (4) for each document, use the query likelihood language model to get the whole query's new score, P(Q|document)=P(token_1|document')*P(token_2|document')*...*P(token_n|document')
		
		//get P(token|feedback documents)
		HashMap<String,Double> TokenRFScore=GetTokenRFScore(aQuery,TopK);
        
        String Qu = aQuery.GetQueryContent();
        String[] Que = Qu.split(" ");
    	scoremap = new HashMap<Integer, Double>();
    	
        for(int j=0; j< Que.length; j++){
        	String token = Que[j];
        	long ctf = ixreader.CollectionFreq(token);

        	if(ctf>0){
        		int[][] posting = ixreader.getPostingList(token);
        		for(int ix=0;ix<posting.length;ix++){
        			int docid1 = posting[ix][0];
        			int freq = posting[ix][1];
        			        			    			
            		double q = ((double)ctf)/totalnum;        				
                    double score = ((double)(freq+2000*q))/(2000+ixreader.docLength(docid1));
                    double finalscore = (alpha)*score+(1-alpha)*TokenRFScore.get(token);
                    	
        		    if(!scoremap.containsKey(docid1)){
        		    	scoremap.put(docid1, finalscore);
        		    }else{
        		        double score1 = scoremap.get(docid1);
        		        scoremap.put(docid1, score1+finalscore);
        		    }
        		}		
        	}  	
        }
        
		List<Document> results = new ArrayList<Document>();
		
        Map<Integer, Double> sortedmap = sortByValues(scoremap);  
        for (Entry<Integer, Double> entry : sortedmap.entrySet()) {
        	results.add(new Document(entry.getKey() + "", ixreader.getDocno(entry.getKey()), entry.getValue()));
        }
		
//		List<Document> results_final = new ArrayList<Document>();
//        removeDuplicate(results,results_final);
        
		return results.subList(0, TopN);
	}
	
	public HashMap<String,Double> GetTokenRFScore(Query aQuery,  int TopK) throws Exception
	{
		// for each token in the query, you should calculate token's score in feedback documents: P(token|feedback documents)
		// use Dirichlet smoothing
		// save <token, score> in HashMap TokenRFScore, and return it
		List<Document> feedbackDocs=new QueryRetrievalModel(ixreader) .retrieveQuery(aQuery, TopK);
		HashMap<String,Double> TokenRFScore=new HashMap<String,Double>();

		int feedbackdoclength = 0;
		int docfq = 0;
		
		if (feedbackDocs != null) {
			for (Document feedbackdoc : feedbackDocs) {
				feedbackdoclength = feedbackdoclength + ixreader.docLength(Integer.parseInt(feedbackdoc.docid()));
			}
		}
		
		String Qu = aQuery.GetQueryContent();
		String[] Que = Qu.split(" ");
		
		for(int j=0; j< Que.length; j++){
			String token = Que[j];
			long ctf = ixreader.CollectionFreq(token);
			
			if(ctf>0){
				int[][] posting = ixreader.getPostingList(token);
				for(int ix=0;ix<posting.length;ix++){
					int docid1 = posting[ix][0];
					if(feedbackDocs.contains(docid1)){
						docfq = docfq + posting[ix][1];
					}
				}
			}
			
			double q = ((double)ctf)/totalnum;       	
			double score = ((double)(docfq+2000*q))/(2000+feedbackdoclength);
			
			TokenRFScore.put(token, score);
		}
		
		return TokenRFScore;
	}
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(  
            final Map<K, V> map) {  
        Comparator<K> valueComparator = new Comparator<K>() {  
            public int compare(K k1, K k2) {  
                int compare = map.get(k2).compareTo(map.get(k1));  
                if (compare == 0)  
                    return 1;  
                else  
                    return compare;  
            }  
        };  
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);  
        sortedByValues.putAll(map);  
        return sortedByValues;  
    }  
	
	
	public   static   List<Document>  removeDuplicate(List<Document> list, List<Document> newlist) throws Exception  {  
//		for (Iterator<Document> it = list.iterator(); it.hasNext(); ) {  
//			Document ele1 = it.next();
//			for (Iterator<Document> it1 = list.iterator(); it1.hasNext(); ) {  
//				Document ele2 = it1.next();
//				if(ele1.docno().equals(ele2.docno())){
//					it1.remove();
//				}	
//			}			
//		}
		for(Document document:list){
			for(Document document1:list){
				if(!document.docno().equals(document1.docno())){
					newlist.add(document);
				}
			}
		}
		return newlist;       
	} 
	
}