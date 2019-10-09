package br.unb.cic.tp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
	
	public static List<String> words(String path) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(path));
			List<String> res = new ArrayList<>();
			for(String line : lines) {
				String[] words = line.split(" "); 
				res.addAll(Arrays.asList(words));

			}
			return res;
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
