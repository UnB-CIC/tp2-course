package br.unb.cic.tp2.memory;


public class Environment {
	
	private java.util.Stack<Object> stack; 
	
	// the unique Environment instance. please, see 
	// the singleton design pattern. 
	private static Environment instance; 
	
	// private constructor. according to the Singleton 
	// design pattern. 
	private Environment() {
		stack = new java.util.Stack<>();
	}
	
	// unique access point from the singleton 
	// instance of the environment class. 
	public static Environment stack() {
		if(instance == null) {
			instance = new Environment();
		}
		return instance; 
	}
	public void push(Object item) {
		stack.push(item); 
	}
	
	public Object pop() {
		if(isEmpty()) {
			throw new RuntimeException("Could not call pop on an empty stack");
		}
		return stack.pop();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.size();
	}
	
	public Object top() {
		return stack.peek();
	}

}
