package com.techmojo.twittrends.strategy.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.techmojo.twittrends.model.HashTag;

public class HashTagTrendingStrategyTest {

	private HashTagTrendingStrategy strategy;

	@Before
	public void setup() {
		strategy = new HashTagTrendingStrategy();
	}

	@Test
	public void testWithValidScenario() {
		HashMap<HashTag, Long> input = new HashMap<>();
		input.put(new HashTag("#one"), 2L);
		input.put(new HashTag("#two"), 4L);
		input.put(new HashTag("#three"), 1L);
		input.put(new HashTag("#thre"), 1L);
		HashTag[] expected = { new HashTag("#two"), new HashTag("#one"), new HashTag("#thre"), new HashTag("#three") };
		strategy.setInput(input);
		assertArrayEquals(expected, strategy.getTrendings().toArray());
	}

}
