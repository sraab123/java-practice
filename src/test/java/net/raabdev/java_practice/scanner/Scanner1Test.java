package net.raabdev.java_practice.scanner;

import junit.framework.TestCase;

public class Scanner1Test extends TestCase {

	
	public void testPrompt() {
		assert(Scanner1.namePrompt().equalsIgnoreCase("What's your name?"));
	}

	public void testResponse() {
		assert(Scanner1.response("Bob").equalsIgnoreCase("Hello, Bob"
				+ ""
				+ ""));
	}

}
