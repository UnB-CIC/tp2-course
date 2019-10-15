package br.unb.cic.tp2.model;

public class WordFrequency implements Comparable<WordFrequency>{
	
	private String word; 
	private Integer count; 
	
	public WordFrequency(String word, Integer count) {
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public Integer getCount() {
		return count;
	}

	@Override
	public String toString() {
		return word + " - " + count; 
	}
	
	@Override
	public int compareTo(WordFrequency o) {
		int diff = o.count.compareTo(this.count);
		if(diff != 0) {
			return diff; 
		}	
		return o.word.compareTo(this.word); 
	}

}
