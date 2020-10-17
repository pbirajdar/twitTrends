package com.techmojo.twittrends.matcher.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberMatcherTest {

	private NumberMatcher matcher;

	@Before
	public void setup() {
		matcher = new NumberMatcher();
	}

	@Test
	public void checkValidNumber() {
		String numberStr = "123";
		matcher.setNumberStr(numberStr);
		assertFalse(String.format("Given string %s is not number.", numberStr), matcher.matches());
	}

	@Test
	public void checkNull() {
		String numberStr = null;
		matcher.setNumberStr(numberStr);
		assertFalse(String.format("Given string %s is not number.", numberStr), matcher.matches());
	}
	
	@Test
	public void checkForNegativeNumber() {
		String numberStr = "-123";
		matcher.setNumberStr(numberStr);
		assertTrue(String.format("Given string %s is not number.", numberStr), matcher.matches());
	}
	
	@Test
	public void checkForInvalidNumber() {
		String numberStr = "a1233";
		matcher.setNumberStr(numberStr);
		assertTrue(String.format("Given string %s is not number.", numberStr), matcher.matches());
	}
}
