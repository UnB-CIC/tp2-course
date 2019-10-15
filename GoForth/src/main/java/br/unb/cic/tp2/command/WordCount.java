package br.unb.cic.tp2.command;

import static br.unb.cic.tp2.memory.Environment.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unb.cic.tp2.model.WordFrequency;

public class WordCount {
	
	public static void countWords() {
		Map<String, Integer> frequency = new HashMap<>(); 
		
		Object obj = stack().pop();
		
		if(obj instanceof List) {
			List<String> words = (List)obj;
			for(String w: words) {
				Integer cnt = frequency.getOrDefault(w, 0);
				stack().push(cnt);
				stack().push(1);
				Arithmetic.add();
				frequency.put(w, (Integer)stack().pop()); 
			}
		}
		
		stack().push(frequency);
	}
	
	public static void sort() {
		Object obj = stack().pop();
		List<WordFrequency> res = new ArrayList<>();
		
		if(obj instanceof Map) {
			Map<String, Integer> words = (Map)obj;
			
			for(String k: words.keySet()) {
				res.add(new WordFrequency(k, words.get(k)));
			}
			Collections.sort(res);
		}
		stack().push(res);
	}
	

}
