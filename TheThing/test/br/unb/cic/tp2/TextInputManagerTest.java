package br.unb.cic.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextInputManagerTest {

	@Test
	public void testConstructor() {
		TextInputManager input = new TextInputManager("foo");
		
		assertNotNull(input);
		assertFalse(input.getIterator().hasNext());
	}
	
	@Test
	public void testValidInput() {
		TextInputManager input = new TextInputManager("resources/dracula.txt");
		
		input.load();
		Iterator<String> it = input.getIterator();
		assertTrue(it.hasNext());
		assertEquals("dracula", it.next());
	}
	
	@Test
	public void testInvalidInput() {
		try {
			TextInputManager input = new TextInputManager("dracula");
			input.load();
			fail("expecting a runtime exception");
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}

}
