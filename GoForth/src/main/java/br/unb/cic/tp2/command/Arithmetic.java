package br.unb.cic.tp2.command;

import static br.unb.cic.tp2.memory.Environment.*;

public class Arithmetic {

	public static void add() {
		try {
			Integer left = Integer.parseInt(stack().pop().toString());
			Integer right = Integer.parseInt(stack().pop().toString());
			stack().push(left + right);
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid arguments to the add command ");
			stack().push("error");
		}
	}
}
