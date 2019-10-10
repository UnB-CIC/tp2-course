package br.unb.cic.tp2;

public class Controller {
	
	private static InputManager input;
	private static StopWordManager stopWord;
	private static WordFrequencyManager frequency;

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Error.... expecting two command line args");
			System.exit(1);
		}
		
		input = new TextInputManager(args[0]);
		stopWord = new StopWordManager(args[1]);
		frequency = new WordFrequencyManager();
		
		input.load();
		Iterator<String> words = input.getIterator();
		
		while(words.hasNext()) {
			String word = words.next();
			if(!stopWord.isStopWord(word)) {
				frequency.record(word);
			}
		}
		
		frequency.sort();
		
		Iterator<WordFrequency> frequencies = frequency.getIterator();
		
		int max = 200; 
		
		while(frequencies.hasNext() && max > 0) {
			WordFrequency wf = frequencies.next();
			System.out.println(wf.getWord() + " - " + wf.getFrequency());
			max--;
		}
	}

}
