package br.unb.cic.tp2.command;


import static br.unb.cic.tp2.memory.Environment.stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {
	
	/**
	 * Requer que o topo da pilha possua uma lista 
	 * de linhas, para computar uma lista de palavras 
	 * e adicionar no topo da pilha. 
	 */
	public static void split() {
		List<String> words = new ArrayList<>();
		Object obj = stack().pop();
		
		if(obj instanceof List) {
			List<String> lines = (List)obj;
			
			for(String w: lines) {
				words.addAll(Arrays.asList(w.split("\\s+")));
			}
			stack().push(words);
		}
		else {
			stack().push(obj);
			throw new RuntimeException("Invalid state. Expecting a list of objects. Found " + 
			   obj.getClass().toGenericString());
		}
		
	}
		
	public static void removeStopWords() {
		try {
			List<String> stopWords = Files.readAllLines(Paths.get(stack().pop().toString()));
			List<String> words = new ArrayList<>();
			Object obj = stack().pop();
			
			if(obj instanceof List) {
				List<String> allWords = (List)obj;
				
				for(String w: allWords) {
					if(!stopWords.contains(w.trim()) && !w.equals(" ")) {
						words.add(w);
					}
				}
			}
			//TODO: o que fazer quando obj nao for uma lista?
			stack().push(words);
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void removeSpecialCharacters() {
		List<String> words = new ArrayList<>();
		Object obj = stack().pop();
		
		if(obj instanceof List) {
			List<String> lines = (List)obj;
			
			for(String w: lines) {
				words.add(w.replaceAll("[^a-zA-Z ]", ""));
			}
		}
		//TODO: o que fazer quando obj nao for uma lista?
		stack().push(words);
	}
}
