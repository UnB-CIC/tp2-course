package br.unb.cic.tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyManager implements Iterable<WordFrequency>{
	
	private Map<String, Integer> map; 
	private List<WordFrequency> freqs; 
	private Status status; 
	
	enum Status {
		INIT,
		READY
	};
	
	public WordFrequencyManager() {
		map = new HashMap<>();
		freqs = new ArrayList<>();
		status = Status.INIT;
	}
	
	public void record(String word) {
		Integer cnt = map.getOrDefault(word, 0);
		map.put(word, cnt + 1);
	}
	
	public void sort() {
//		map.keySet().stream()
//		            .forEach(s -> freqs.add(new WordFrequency(s, map.get(s))));
		for(String s: map.keySet()) {
			freqs.add(new WordFrequency(s, map.get(s)));
		}
		Collections.sort(freqs);
		status = Status.READY;
	}
	
	public Iterator<WordFrequency> getIterator() {
		if(status == Status.READY) {
			return new InternalIterator();
		}
		throw new RuntimeException("Invalid state. You must call sort before getIterator");
	}
	
	
	class InternalIterator implements Iterator<WordFrequency> {
		
		private int pos = 0; 

		@Override
		public boolean hasNext() {
			return pos < freqs.size();
		}

		@Override
		public WordFrequency next() {
			if(hasNext()) {
				return freqs.get(pos++);
			}
			throw new RuntimeException("there are no more elements");
		}

		@Override
		public void first() {
			pos = 0;
		}
		
	}


}
