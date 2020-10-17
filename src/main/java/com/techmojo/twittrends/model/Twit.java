package com.techmojo.twittrends.model;

public final class Twit {
	private final String twitStr;

	public Twit(String twitStr) {
		this.twitStr = twitStr;
	}

	public String getTwit() {
		return twitStr;
	}

	@Override
	public String toString() {
		return twitStr;
	}
}
