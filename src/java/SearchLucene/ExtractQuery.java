package SearchLucene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Classes.Path;
import Classes.Query;
import PreProcessData.StopWordRemover;
import PreProcessData.WordNormalizer;

public class ExtractQuery {

	ArrayList<Query> queries;
	BufferedReader inputStream;
	StopWordRemover stopwordRemover = new StopWordRemover();
	WordNormalizer normalizer = new WordNormalizer();
	
	List<String> biology = new ArrayList<String>();
	List<String> music = new ArrayList<String>();
	List<String> politics = new ArrayList<String>();
	List<String> psychology = new ArrayList<String>();
	
	int idx = 0;

	public ExtractQuery() throws Exception {
		// you should extract the 4 queries from the Path.TopicDir
		// NT: the query content of each topic should be 1) tokenized, 2) to
		// lowercase, 3) remove stop words, 4) stemming
		// NT: you can simply pick up title only for query, or you can also use
		// title + description + narrative for the query content.
		queries = new ArrayList<>();
		Query aQuery = new Query();
		aQuery.SetTopicId("biology");
		try {
            inputStream = new BufferedReader(
                            new FileReader(Path.biology));
            String line;
            while ((line = inputStream.readLine()) != null) {
            	for(String w:line.split("\\s")){
            		biology.add(w);
            	};              	
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
		String content = null;
		for(String word:biology){
			word = normalizer.lowercase(word);
			if (!stopwordRemover.isStopword(word)){
//				System.out.println(word);
				content = normalizer.stem(word) + " " + content;
//				aQuery.SetQueryContent(normalizer.stem(word));
			}
		}
//		System.out.println(content);
		aQuery.SetQueryContent(content);
//		System.out.println(aQuery.GetQueryContent());
		queries.add(aQuery);
		aQuery = new Query();
		aQuery.SetTopicId("music");
		try {
            inputStream = new BufferedReader(
                            new FileReader(Path.music));
            String line;
            while ((line = inputStream.readLine()) != null) {
            	for(String w:line.split("\\s")){
            		music.add(w);
            	};              	
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
		content = null;
		for(String word:music){
			word = normalizer.lowercase(word);
			if (!stopwordRemover.isStopword(word)){
				content = normalizer.stem(word) + " " + content;
			}
		}
		aQuery.SetQueryContent(content);
		queries.add(aQuery);
		aQuery = new Query();
		aQuery.SetTopicId("politics");
		try {
            inputStream = new BufferedReader(
                            new FileReader(Path.politics));
            String line;
            while ((line = inputStream.readLine()) != null) {
            	for(String w:line.split("\\s")){
            		politics.add(w);
            	};              	
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
		content = null;
		for(String word:politics){
			word = normalizer.lowercase(word);
			if (!stopwordRemover.isStopword(word)){
				content = normalizer.stem(word) + " " + content;
			}
		}
		aQuery.SetQueryContent(content);
		queries.add(aQuery);
		aQuery = new Query();
		aQuery.SetTopicId("psychology");
		try {
            inputStream = new BufferedReader(
                            new FileReader(Path.psychology));
            String line;
            while ((line = inputStream.readLine()) != null) {
            	for(String w:line.split("\\s")){
            		psychology.add(w);
            	};              	
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
		content = null;
		for(String word:psychology){
			word = normalizer.lowercase(word);
			if (!stopwordRemover.isStopword(word)){
				content = normalizer.stem(word) + " " + content;
			}
		}
		aQuery.SetQueryContent(content);
		queries.add(aQuery);
	}

	public boolean hasNext() {
		if (idx == queries.size()) {
			return false;
		} else {
			return true;
		}
	}

	public Query next() {
		return queries.get(idx++);
	}

}
