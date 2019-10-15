package br.unb.cic.tp2;

import static br.unb.cic.tp2.command.StackBased.*;
import static br.unb.cic.tp2.command.Preprocessor.*;
import static br.unb.cic.tp2.command.WordCount.*;
import static br.unb.cic.tp2.command.IO.*;


public class Main {
	
	public static void main(String args[]) {
		String bookPath = args[0];
		String stopWordsPath = args[1];
		
		push(bookPath);
		readFile();
		split();
		removeSpecialCharacters();
		push(stopWordsPath);
		removeStopWords();
		countWords();
		sort();
		push(25);
		printFirst();
	
	}

}
