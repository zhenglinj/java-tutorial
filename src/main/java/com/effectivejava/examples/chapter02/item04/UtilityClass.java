// Noninstantiable utility class
package com.effectivejava.examples.chapter02.item04;

public class UtilityClass {
	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		throw new AssertionError();
	}
}
