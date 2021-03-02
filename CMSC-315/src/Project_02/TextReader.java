package Project_02;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader {
	public ArrayList<DictionaryKey> words;
	public static final String[] PUNCTUATION = {".",",","!",":","?",";","\"","\'","(",")","-"};
	
	TextReader(){
		words = new ArrayList<DictionaryKey>();
	}
	
	//Reads in all words from a file and adds them to words arraylist
	public void readWords(Scanner s) {
		//Read in each word
		while(s.hasNext()) {
			String w = s.next();
			//System.out.println(w);
			
			//Clean punctuation
			w = this.cleanWord(w);
			//Determine if exists in words, if not, add new DictionaryKey with appropriate values
			this.addWord(w, words);
		}
	}
	
	//Sorts all the words in words by their count
	public void sortByCount() {
		//sort each element so that the higher the count is closer to the start of the arraylist
		//Initialize a new arraylist and add a single empty element
		ArrayList<DictionaryKey> a = new ArrayList<DictionaryKey>();
		a.add(0,new DictionaryKey(""));
		
		for(DictionaryKey k : words) {
			//System.out.println("Placing word: \t" + k.word);
			//k has greatest count in a
			if(k.count > a.get(0).count) {
				//System.out.println("k has greatest count: " + k.count + " greater than: " + a.get(0).count);
				a.add(0,k);
			} 
			//k has count of 1
			else if(k.count == 1) {
				//System.out.println("k has least count of 1: " + k.count);
				a.add(k);
			} 
			//Must find where k belongs
			else {
				//Iterate from end of a to front
				for(int i = a.size()-1; i >= 0; i--) {
					while(k.count > a.get(i).count) {
						--i;
					}
					
					//When k.count is no longer greater than i.count, insert k
					a.add(i+1,k);
					//System.out.println("k added at index: " + (i+1) + " with count: " + k.count);
					break;
				}
			}
		}
		
		words.clear();
		for(DictionaryKey d : a) {
			words.add(d);
		}
	}
	
	//Remove whitespace and punctuation from s
	public String cleanWord(String s) {
		s = s.strip();
		s = s.toLowerCase();
		for(String p : PUNCTUATION) {
			s = s.replace(p, "");
		}
		return s;
	}
	
	//Adds a word to the arraylist if that word is not found within it, incrementing count as necessary
	public void addWord(String s, ArrayList<DictionaryKey> a) {
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).word.equalsIgnoreCase(s)) {
				a.get(i).count++;
				return;
			}
		}
		a.add(new DictionaryKey(s));
	}
}
	
