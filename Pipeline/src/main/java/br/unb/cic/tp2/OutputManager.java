package br.unb.cic.tp2;

import java.util.List;

public class OutputManager {
	
	public static void export(List<WordFrequency> frequencies) {
		frequencies.stream().forEach(s -> System.out.println(s));
	}

}
