package br.unb.cic.tp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextInputManager implements InputManager {

	private String path; 
	private List<String> words; 
	
	public TextInputManager(String path) {
		this.path = path;
		this.words = new ArrayList<>();
	}
	
	@Override
	public void load()  {
		try {
			List<String> lines = Files.readAllLines(Paths.get(path));
			for(String line: lines) {
				String[] split = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
				words.addAll(Arrays.asList(split));
			}
		}
		catch(IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public Iterator<String> getIterator() {
		return new InternalIterator();
	}
	
	class InternalIterator implements Iterator<String> {

		private int position = 0; 
		
		@Override
		public boolean hasNext() {
			return position < words.size();
		}

		@Override
		public String next() {
			if(hasNext()) {
				//return words.get(position++);
				String res = words.get(position);
				position++;
				return res;
			}
			throw new RuntimeException("there are no more elements...");
		}

		@Override
		public void first() {
			position = 0;
		}
		
	}
}
