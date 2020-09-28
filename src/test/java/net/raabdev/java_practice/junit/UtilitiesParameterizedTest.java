package net.raabdev.java_practice.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UtilitiesParameterizedTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]
				{{"ABCDEEFF","ABCDEF"}, 
			     {"AB88EFFG","AB8EFG"},
			     {"1122445566","12456"},
			     {"ZYZQQB","ZYZQB"},
			     {"A","A"}
				});
	}
	
	@Test
	public void testConverter() {
		assertEquals(result, Utilities.removePairs(input));
	}
	
	private String result;
	private String input;
	
	public UtilitiesParameterizedTest(String input, String result) {
		this.result = result;
		this.input = input;
	}

}
