package br.unb.cic.tp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyManager {

	public static List<WordFrequency> frequencies(List<String> words) {
		Map<String, Integer> map = new HashMap<>();
		List<WordFrequency> res = new ArrayList<>();
		
		words.stream().forEach(s -> {
			Integer cnt = map.getOrDefault(s, 0);
			map.put(s, cnt + 1);
		});
		
		map.keySet().stream()
		            .forEach(s -> res.add(new WordFrequency(s, map.get(s))));
		
		return res; 
	}
	
	public static List<WordFrequency> sort(List<WordFrequency> frequencies) {
		return frequencies.stream()
				          .sorted()
				          .collect(Collectors.toList());
	}
	
	public static List<WordFrequency> first(int n, List<WordFrequency> frequencies) {
		return frequencies.subList(0, n);
	}
}
