package uk.ac.manchester.finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest {

	/* Uses toNumeralA */
	@Test
	public void numberCanBeCreated() {
		Number n = new Number(1);
		assertEquals(1, n.toInteger());
	}

	@Test
	public void oneAsNumeral() {
		Number n = new Number(1);
		assertEquals("I", n.toNumeralA());
	}

	@Test
	public void twoAsNumeral() {
		Number n = new Number(2);
		assertEquals("II", n.toNumeralB());
	}

	@Test
	public void fourAsNumeral() {
		Number n = new Number(4);
		assertEquals("IV", n.toNumeralC());
	}

	@Test
	public void twentyElevenAsNumeral() {
		Number n = new Number(2011);
		assertEquals("MMXI", n.toNumeralD());
	}

	/**
	 * Complex, because things like 900, 400, 90, 40 etc. are corner cases that
	 * aren't immediately obvious.
	 */
	@Test
	public void complexNumber() {
		Number n = new Number(448);
		assertEquals("CDXLVIII", n.toNumeralD());
	}

}
