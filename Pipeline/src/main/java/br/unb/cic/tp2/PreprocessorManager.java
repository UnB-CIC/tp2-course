package br.unb.cic.tp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PreprocessorManager {
	
	public static List<String> toLowerCase(List<String> words) {
		return words.stream()
		            .map(s -> s.toLowerCase())
		            .collect(Collectors.toList());
	}
	
	public static List<String> removeSpecialCharacters(List<String> words) {
		return words.stream()
				    .map(s -> s.replaceAll("[^a-zA-Z ]", ""))
				    .collect(Collectors.toList());

	}
	
	public static List<String> removeStopWords(String path, List<String> words) {
		try {
			List<String> stopWords = Files.readAllLines(Paths.get(path));
			return words.stream()
					    .filter(s -> !stopWords.contains(s))
					    .collect(Collectors.toList());
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
