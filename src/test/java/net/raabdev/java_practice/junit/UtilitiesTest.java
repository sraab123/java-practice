package net.raabdev.java_practice.junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class UtilitiesTest {
	
	@Test
	public void everyNthCharTest1() {
		char[] testArray = {'e','l'}; 
		char[] sourceArray = {'h','e','l','l','o'}; 
		assertArrayEquals(testArray, Utilities.everyNthChar(sourceArray, 2));
	}

	@Test
	public void everyNthCharTest2() {
		char[] testArray = {'h','e','l','l','o'}; 
		char[] sourceArray = {'h','e','l','l','o'}; 
		assertArrayEquals(testArray, Utilities.everyNthChar(sourceArray, 6));
	}
	
	@Test
	public void everyNthCharTest3() {
		char[] testArray = {'h','e','l','l','o'}; 
		char[] sourceArray = {'h','e','l','l','o'}; 
		assertNull(Utilities.everyNthChar(null, 5));
	}


	@Test
	public void removePairsTest1() {
		assertEquals("abcdef", Utilities.removePairs("aabccdef"));
	}	

	@Test
	public void removePairsTest2() {
		assertEquals("abcabdef", Utilities.removePairs("abccabdeeff"));
	}
	
	@Test
	public void removePairsTest3() {
		assertEquals("acabdef", Utilities.removePairs("aaccabdeeff"));
	}	

	@Test
	public void removePairsTest4() {
		assertEquals("a", Utilities.removePairs("a"));
	}
	
	@Test
	public void removePairsTest5() {
		assertEquals("", Utilities.removePairs(null));
	}
	

	@Test
	public void converterTest1() {
		assertEquals(300, Utilities.converter(10, 5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void converterTest2() {
		assertEquals(300, Utilities.converter(10, 0));
	}

	@Test
	public void nullIfOddLengthTest1() {
		assertNull(Utilities.nullIfOddLength("abb"));
	}

	@Test
	public void nullIfOddLengthTest2() {
		assertEquals("avar", Utilities.nullIfOddLength("avar"));
	}

	
}
