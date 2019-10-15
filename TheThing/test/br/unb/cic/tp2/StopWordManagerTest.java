package br.unb.cic.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StopWordManagerTest {

	@Test
	public void test() {
		StopWordManager mgr = new StopWordManager("resources/stop-words.txt");
		assertEquals(127, mgr.numberOfStopWords());		
	}

}
