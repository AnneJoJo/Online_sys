package PreProcessData;
import Classes.Stemmer;

/**
 * This is for INFSCI 2140 in 2017
 * 
 */
public class WordNormalizer {
	//you can add essential private methods or variables
	
	// YOU MUST IMPLEMENT THIS METHOD
	public String lowercase(String chars ) {
		//transform the uppercase characters in the word to lowercase
		chars = chars.toLowerCase();
		return chars;
	}
	
	public String stem(String chars)
	{
		//use the stemmer in Classes package to do the stemming on input word, and return the stemmed word
		Stemmer stem = new Stemmer();
	    //return stem.stem(chars);
		stem.add(chars.toCharArray(), chars.length());
		stem.stem();
		return stem.toString();
//		String str="";
//		return str;
	}
	
}
