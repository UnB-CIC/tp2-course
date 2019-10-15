package br.unb.cic.tp2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import jline.Terminal;
import jline.TerminalFactory;
import jline.console.ConsoleReader;
import jline.console.completer.FileNameCompleter;

import static br.unb.cic.tp2.command.StackBased.*;
import static br.unb.cic.tp2.command.Preprocessor.*;
import static br.unb.cic.tp2.command.WordCount.*;
import static br.unb.cic.tp2.command.IO.*;
import static br.unb.cic.tp2.command.Arithmetic.*;


public class Interpreter {
	
	
	private static final String PROMPT = "> "; 
	
	
	public static void main(String args[]) {
		try {
			String cmd = "";
		//	Scanner scanner = new Scanner(System.in);
			
			ConsoleReader console = new ConsoleReader();
	        console.setPrompt("prompt > ");
	  		console.addCompleter(new FileNameCompleter());
	  		
			while(true) {
				String[] tokens = console.readLine().split(" "); //scanner.nextLine().split(" ");
				String[] cmdArgs = null; 
				cmd = tokens[0];
				
				if(tokens.length > 1) {
					cmdArgs = Arrays.copyOfRange(tokens, 1, tokens.length);
				}
				
				switch(cmd) {
				  case "push" : push(cmdArgs[0]); break; 
				  
				  case "read" : readFile(); break; 
				  
				  case "pop"  : System.out.println(pop().toString()); break; 
				  
				  case "add"  : add(); System.out.println(top().toString()); break;
				  
				  case "inspect" : System.out.println(" Stack Size: " + size());
                                   System.out.print(" Top is an " + top().getClass().toString());
                                   break; 
				  case "exit" : TerminalFactory.get().restore(); System.exit(0);
				}
				System.out.println("");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
