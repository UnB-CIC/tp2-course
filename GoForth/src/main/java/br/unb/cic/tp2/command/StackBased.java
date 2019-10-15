package br.unb.cic.tp2.command;

import static br.unb.cic.tp2.memory.Environment.stack;

public class StackBased {

	public static void push(Object object) {
		stack().push(object);
	}
	
	public static Object pop() {
		return stack().pop();
	}

	public static int size() {
		return stack().size();
	}
	
	public static Object top() {
		return stack().top();
	}
}
