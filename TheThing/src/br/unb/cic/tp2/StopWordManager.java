package br.unb.cic.tp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StopWordManager {
	private List<String> stopWords;
	
	public int numberOfStopWords() {
		return stopWords.size();
	}
	
	public StopWordManager(String path) {
		try {
			stopWords = Files.readAllLines(Paths.get(path));
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public boolean isStopWord(String word) {
		return stopWords.contains(word) || word.trim().equals("");
	}
}
