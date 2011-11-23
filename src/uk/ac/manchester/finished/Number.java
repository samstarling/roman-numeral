package uk.ac.manchester.finished;

import java.util.LinkedHashMap;

public class Number {

	int number;

	/**
	 * Constructor that takes a number.
	 */
	public Number(int number) {
		this.number = number;
	}

	/**
	 * Simple getter.
	 */
	public int toInteger() {
		return this.number;
	}

	/**
	 * Here, we do the simplest thing to make the first test pass.
	 */
	public String toNumeralA() {
		return "I";
	}

	/**
	 * And here is the simplest thing that makes the first two tests pass - that
	 * is, we return "I" repeated this.number of times.
	 */
	public String toNumeralB() {
		String result = "";
		for (int i = 0; i < this.number; i++) {
			result += "I";
		}
		return result;
	}

	/**
	 * What about when we introduce a test for 4? That breaks the implementation
	 * of toNumeralB(), and we have a failing test. So we might use a switch.
	 * I've included this as it's a good example of getting into a bad pattern
	 * of your code mirroring your tests - that is, we can't just write a new
	 * case for each failing test.
	 */
	public String toNumeralC() {
		String result = "";
		switch (this.number) {
		case 1:
			result = "I";
			break;
		case 2:
			result = "II";
			break;
		case 3:
			result = "III";
			break;
		case 4:
			result = "IV";
			break;
		default:
			result = "Unknown number";
			break;
		}
		return result;
	}

	/**
	 * This is the first proper implementation of an actual algorithm for
	 * creating roman numerals. It's basically the same algorithm behind working
	 * out the most efficient way for a shopkeeper to give change to a customer.
	 */
	public String toNumeralD() {

		/* Use a LinkedHashMap, as it stays in order items are put in */
		LinkedHashMap<Integer, String> numeralMapping = new LinkedHashMap<Integer, String>();
		numeralMapping.put(1000, "M");
		numeralMapping.put(900, "CM");
		numeralMapping.put(500, "D");
		numeralMapping.put(400, "CD");
		numeralMapping.put(100, "C");
		numeralMapping.put(90, "XC");
		numeralMapping.put(50, "L");
		numeralMapping.put(40, "XL");
		numeralMapping.put(10, "X");
		numeralMapping.put(9, "IX");
		numeralMapping.put(5, "V");
		numeralMapping.put(4, "IV");
		numeralMapping.put(1, "I");

		/* Actually work out the numeral */
		String result = "";
		int tempNumber = this.number;
		/* Go through each item in the hashmap */
		for (Integer a : numeralMapping.keySet()) {
			/* How many times does this number go into our number? */
			int divisor = tempNumber / a;
			if (divisor > 0) {
				/*
				 * If it does go into our number, add numerals and subtract from
				 * working number
				 */
				tempNumber -= divisor * a;
				for (int i = 0; i < divisor; i++) {
					/* Append numerals into string */
					result += numeralMapping.get(a);
				}
			}
		}
		return result;

		/**
		 * Note: good way to show how useful the whole test suite is, is to
		 * change "i < divisor" to "i <= divisor" on line 105. The last two
		 * tests start to fail. Our test suite means we can refactor with
		 * confidence. The above implementation isn't the most efficient, but
		 * that's another module :)
		 */

	}

}
