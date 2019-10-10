package br.unb.cic.tp2;

public class WordFrequency implements Comparable<WordFrequency>{
	private String word;
	private Integer frequency; 
	
	public WordFrequency(String w, Integer f) {
		this.word = w;
		this.frequency = f; 
	}

	public String getWord() {
		return word;
	}

	public Integer getFrequency() {
		return frequency;
	}

	@Override
	public int compareTo(WordFrequency o) {
		int diff = o.frequency.compareTo(this.frequency);
		if(diff != 0) {
			return diff;
		}
		return o.word.compareTo(this.word);
	}
}
