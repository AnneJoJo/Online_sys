package PreProcessData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Classes.Path;

/**
 * This is for INFSCI 2140 in 2017
 *
 */
public class TrectextCollection implements DocumentCollection {
	//you can add essential private methods or variables
	BufferedReader br;
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrectextCollection() throws IOException {
		try{
	         // open input stream test.txt for reading purpose.
	         br = new BufferedReader(new FileReader(Path.DataBookDir));
	      }catch(Exception e){
	         e.printStackTrace();
	      }
		
		// This constructor should open the file in Path.DataTextDir
		// and also should make preparation for function nextDocument()
		// you cannot load the whole corpus into memory here!!
		
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, String> nextDocument() throws IOException {
		// this method should load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
//		 NTT: remember to close the file that you opened, when you do not use it any more
		Map<String, String> map=new HashMap<>();
		String brline;
		String isbn = null;
		String content = null;
//		map.put("0520037588", "");
//		brline = br.readLine();
		while ((brline=br.readLine())!= null){
			isbn = brline;
//			System.out.println(isbn);
			content=br.readLine();
//			System.out.println(content);

				//if(brline.trim().startsWith("<TEXT>") && brline.trim().endsWith("</TEXT>")){
				//	text += (brline+"\n");
				//	System.out.println(text);
				//}
//				
//				if(brline.trim().startsWith("<TEXT>")){
//					statue=true;
//
//				}
//				 if (statue && !brline.trim().startsWith("</TEXT>")){
//					text += (brline+"\n");
//					//System.out.println(text);
//				}
//				if(brline.trim().startsWith("</TEXT>")){
				map.put(isbn,content);
			
			break;
//				}
		}
		
//		if(map.containsKey("0080535861")){
//		System.out.println(map.getOrDefault("0080535861"));}
		
//		map.put("0080535861", "12");
//		map.put("0080535861", "13");
//
//		System.out.println(map.get("0080535861"));

		
		if (brline != null)
		return map;
		else return null;
		
		
		
		
//        try {
//            inputStream = new BufferedReader(
//                            new FileReader(Path.DataBookDir));
//            String line;
//
//            while ((line = inputStream.readLine()) != null) {
//				key=line;
//				System.out.println(key);
//				text=inputStream.readLine();
//				System.out.println(text);
////            	strBuffer.append(line);
////            	System.out.println(line);
//				store.put(key,text);
//
//
//            	                	
////                System.out.println(Arrays.toString(strBuffer.toString().split("\\s")));
//            }
//        }
//        finally {
//            if (inputStream != null) {
//                inputStream.close();
//                return null;
//            }
//		
//		
//	}
	}
	
}
