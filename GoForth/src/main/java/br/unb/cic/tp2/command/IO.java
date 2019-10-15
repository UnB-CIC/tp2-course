package br.unb.cic.tp2.command;

import static br.unb.cic.tp2.memory.Environment.stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.unb.cic.tp2.model.WordFrequency;

public class IO {
	
	public static void readFile() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(stack().pop().toString()));
			stack().push(lines);
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static void printFirst() {
		Object obj1 = stack().pop();
		Object obj2 = stack().pop();
		if(obj1 instanceof Integer && obj2 instanceof List) {
			Integer total = (Integer)obj1;
			List<WordFrequency> words = (List)obj2;
			printList(total, words);	
		}
		else {
			throw new RuntimeException("Invalid state for printing the first elements of the stack. "
					+ "The stack should have a number followed by a list");
		}
	}
	
	private static void printList(int total, List<WordFrequency> words) {
		int size = words.size();
		int pos = 0; 
		while(pos < size && pos < total) {
			System.out.println(words.get(pos++).toString());
		}
	}
}
