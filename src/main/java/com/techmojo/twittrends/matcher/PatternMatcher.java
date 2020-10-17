package com.techmojo.twittrends.matcher;

import java.util.Iterator;
import java.util.regex.Matcher;

public abstract class PatternMatcher implements Iterable<String> {
	private Matcher matcher;

	protected PatternMatcher(Matcher matcher) {
		this.matcher = matcher;
	}

	@Override
	public Iterator<String> iterator() {
		return new PatternMatcherIterator(matcher);
	}

	public final boolean matches() {
		return matcher.matches();
	}

	public Matcher getMatcher() {
		return matcher;
	}

	public void setMatcher(Matcher matcher) {
		this.matcher = matcher;
	}

	private class PatternMatcherIterator implements Iterator<String> {
		Matcher matcher;

		public PatternMatcherIterator(Matcher matcher) {
			this.matcher = matcher;
		}

		@Override
		public boolean hasNext() {
			return matcher.find();
		}

		@Override
		public String next() {
			return matcher.group();
		}

	}
}
