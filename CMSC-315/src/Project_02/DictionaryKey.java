package Project_02;

// I like C++ structs more than having to do this :)

public class DictionaryKey {
	public String word;
	public int count;
	
	DictionaryKey(){
		word = "";
		count = 0;
	}
	DictionaryKey(String w){
		word = w;
		count = 1;
	}
}
