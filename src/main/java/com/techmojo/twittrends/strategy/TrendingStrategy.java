package com.techmojo.twittrends.strategy;

import java.util.List;

public abstract class TrendingStrategy<INPUT, OUTPUT> {
	private INPUT input;

	public void setInput(INPUT input) {
		this.input = input;
	}

	public INPUT getInput() {
		return input;
	}

	public abstract List<OUTPUT> getTrendings();
}
