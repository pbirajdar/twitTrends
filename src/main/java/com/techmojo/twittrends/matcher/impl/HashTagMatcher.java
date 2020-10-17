package com.techmojo.twittrends.matcher.impl;

import java.util.regex.Pattern;

import com.techmojo.twittrends.matcher.PatternMatcher;
import com.techmojo.twittrends.model.Twit;

public class HashTagMatcher extends PatternMatcher {
	private static Pattern pattern = Pattern.compile("(#\\w+)");
	private Twit twit;

	public HashTagMatcher(Twit twit) {
		super(pattern.matcher(twit.toString()));
		this.twit = twit;
	}

	public HashTagMatcher() {
		this(new Twit(""));
	}

	public Twit getTwit() {
		return twit;
	}

	public void setTwit(Twit twit) {
		if (twit != null) {
			this.twit = twit;
			setMatcher(pattern.matcher(twit.toString()));
		}
	}

}
