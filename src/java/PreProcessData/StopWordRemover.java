package PreProcessData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Classes.*;

public class StopWordRemover {
	//you can add essential private methods or variables
	private ArrayList<String> stopWordArray = new ArrayList<String>();

	public StopWordRemover( ) {
		String  brline = null;
		try{
			// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader(new FileReader(Path.StopwordDir));
		    while ((brline = br.readLine()) != null) {
//				brline = br.readLine();
				stopWordArray.add(brline.trim());
		    }
		    br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		// address of stopword.txt should be Path.StopwordDir
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword(String word ) {
		boolean statue=false;
		for (String words: stopWordArray
			 ) {
			if(word.equals(words)){
				statue = true;
				break;
			}
		}
		if(statue){return true;}
		else return false;
		// return true if the input word is a stopword, or false if not
	}
}
