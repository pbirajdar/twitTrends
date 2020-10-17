package com.techmojo.twittrends.validator.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.techmojo.twittrends.exception.NoOfTwitsValidatorException;
import com.techmojo.twittrends.validator.Validator;

public class NoOfTwitsValidatorTest {

	private Validator<String> validator;

	@Before
	public void setup() {
		validator = new NoOfTwitsValidator("");
	}

	@Test(expected = NumberFormatException.class)
	public void validateBlankNumberString() {
		validator.validate();
	}

	@Test
	public void validateValidNumberString() {
		validator = new NoOfTwitsValidator("123");
		validator.validate();
		assertTrue(true);
	}

	@Test(expected = NoOfTwitsValidatorException.class)
	public void validateNegativeNumberString() {
		validator = new NoOfTwitsValidator("-123");
		validator.validate();
	}
	
	@Test(expected = NoOfTwitsValidatorException.class)
	public void validateInvalidNumberString() {
		validator = new NoOfTwitsValidator("a1223");
		validator.validate();
	}
	
	@Test(expected = NoOfTwitsValidatorException.class)
	public void validateZeroNumberString() {
		validator = new NoOfTwitsValidator("0");
		validator.validate();
	}
}
