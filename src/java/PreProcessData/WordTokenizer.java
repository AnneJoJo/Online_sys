package PreProcessData;

/**
 * This is for INFSCI 2140 in 2017
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	//you can add essential private methods or variables
	String[] words;
	private int num;
	// YOU MUST IMPLEMENT THIS METHOD
	public WordTokenizer( String texts ) {
		words = texts.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "").split("\\s+");
		// this constructor will tokenize the input texts
		// please remove all punctuations
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public String nextWord() {
		if(this.num < this.words.length)
			return words[num++];
		else
			return null;
	}
	
}
