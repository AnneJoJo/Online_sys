

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Classes.*;


public class JSON1 {
	

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
  
  public static void method1(String file, String conent) {                         
      BufferedWriter out = null;                                                   
      try {                                                                        
           out = new BufferedWriter(new OutputStreamWriter(                        
                  new FileOutputStream(file, true)));                              
           out.write(conent); 
           out.newLine();
       } catch (Exception e) {                                                     
           e.printStackTrace();                                                    
       } finally {                                                                 
          try {                                                                    
               out.close();                                                        
           } catch (IOException e) {                                               
               e.printStackTrace();                                                
           }                                                                       
       }                                                                           
   }                

  public static void main(String[] args) throws IOException, JSONException {
	
	List<String> list_words = new ArrayList<String>();
	List<String> list_isbn10 = new ArrayList<String>();
	
	
	int count=1;
	
//	FileReader fr;
//	BufferedReader br;
//	fr = new FileReader(Path.psychology+Path.biology);
//	br = new BufferedReader(fr);
//	String line = null;
//	while((line=br.readLine()) != null){
////		line=line.replaceAll("\\s", "\t");
//		words = line.split("\\s");

////			list_words.addAll(line.split("\\s"));
////			System.out.println(linee);
//
//
//	}
	
	
//    StringBuffer strBuffer = new StringBuffer();  

    File dir = new File(Path.category);
    File[] files = dir.listFiles();

    for (File f : files) {
        if(f.isFile()) {
            BufferedReader inputStream = null;

            try {
                inputStream = new BufferedReader(
                                new FileReader(f));
                String line;

                while ((line = inputStream.readLine()) != null) {
//                	strBuffer.append(line);
//                	System.out.println(line);
                	for(String w:line.split("\\s")){
                		list_words.add(w);
                	};
                	                	
//                    System.out.println(Arrays.toString(strBuffer.toString().split("\\s")));
                }
            }
            finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
    }
//	for(int i=0;i<words.length;i++){
//		System.out.println(words[i]);
//	}
//	System.out.println(list_words.size());
//
//    for(String tmp:list_words){
//        System.out.println(tmp);
//    }
	
//	System.out.println(list_words.get(1));

    
    for(int i = 0;i < 12; i ++){
    	list_words.remove(0);
//        System.out.println(list_words.get(i));
    }
    
    
    for(int k = 905; k < list_words.size(); k++){
        System.out.println(list_words.get(k));
        System.out.println(count);
        System.out.println(k+1);

        int S=1;
    	int N=40;
//	System.out.println(list_words.get(0));

	while(S<66){
    JSONObject json = readJsonFromUrl("https://www.googleapis.com/books/v1/volumes?q="+list_words.get(k)+"&startIndex="+S+"&maxResults="+N+"&key=AIzaSyAtC3PfvIe7SpFQC9B4-UIoSqNgO0LIbJE");
//    System.out.println(tmp);
//    method1("science.txt",json.get("items").toString());                                 
//    System.out.println(json.toString());
//    System.out.println(json.get("items"));
    if(json.has("items")){
    JSONArray items = json.getJSONArray("items");
//    System.out.println(items);
//    System.out.println(items.length());

    for(int i = 0; i < items.length(); i++) {
    	JSONObject item_detail = items.getJSONObject(i);
//    	System.out.println(item_detail.toString());
    	if(item_detail.has("volumeInfo")){
        
    	JSONObject volumeInfo = item_detail.getJSONObject("volumeInfo");
//        System.out.println(volumeInfo.toString());

    	if(volumeInfo.has("description") & volumeInfo.has("industryIdentifiers")){
//    	System.out.println(volumeInfo.toString());
        JSONArray industryIdentifiers = volumeInfo.getJSONArray("industryIdentifiers");
//        if(){
//    	System.out.println(industryIdentifiers.toString());
        for(int j = 0; j < industryIdentifiers.length(); j++){
            JSONObject industry_detail = industryIdentifiers.getJSONObject(j);
            if(industry_detail.get("type").toString().equals("ISBN_10")){
                String isbn10 = industry_detail.get("identifier").toString();
            	if(!list_isbn10.contains(isbn10)){
            	list_isbn10.add(isbn10);
            	String content="";
            	content=isbn10+"\n"+volumeInfo.get("description").toString();
            	method1("books.txt",content); 
            	count=count+1;
            	}
            }
//            String isbn10 = industry_detail.get("identifier").toString();
////            System.out.println(isbn10);
////            System.out.println(industry_detail.get("identifier"));
////            System.out.println(volumeInfo.get("description"));
//        	String content="";
//        	content=isbn10+"\n"+volumeInfo.get("description").toString();
////        	System.out.println(content);
//        	method1("books.txt",content);                                 
        }}}      
    	
    }


//    String durl = item.getString("durl");
//    String jianpin = item.getString("jianpin");
//    String name = item.getString("name");
//    String pinyin = item.getString("pinyin");
//    int provincecode = item.getInt("provincecode");
//    int size = item.getInt("size");
//    int version = item.getInt("version");
//    String areacode = item.getString("areacode");
//    JSONObject citys = item.getJSONObject("citys");
//    String citysname = citys.getString("name");

    
    }S=S+N;
	}
	}
//	System.out.println(list);
//	System.out.println(count);
  
  }
}