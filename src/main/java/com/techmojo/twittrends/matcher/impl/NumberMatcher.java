package com.techmojo.twittrends.matcher.impl;

import java.util.regex.Pattern;

import com.techmojo.twittrends.matcher.PatternMatcher;

public class NumberMatcher extends PatternMatcher {
	private static Pattern pattern = Pattern.compile(".*[^0-9].*");
	private String numberStr;

	public NumberMatcher() {
		this("");
	}

	public NumberMatcher(String input) {
		super(pattern.matcher(input));
	}

	public String getNumberStr() {
		return numberStr;
	}

	public void setNumberStr(String numberStr) {
		if (numberStr != null) {
			this.numberStr = numberStr;
			setMatcher(pattern.matcher(numberStr));
		}
	}

}
