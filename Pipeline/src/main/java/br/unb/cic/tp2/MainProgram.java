package br.unb.cic.tp2;

import static br.unb.cic.tp2.InputManager.*;
import static br.unb.cic.tp2.PreprocessorManager.*; 
import static br.unb.cic.tp2.WordFrequencyManager.*;
import static br.unb.cic.tp2.OutputManager.*;

public class MainProgram {

	public static void main(String args[]) {
		if(args.length != 2) {
			
		}
		export(first(20, sort(frequencies(removeStopWords(args[1], removeSpecialCharacters(toLowerCase(words(args[0]))))))));	
	}
}
