package com.techmojo.twittrends;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.techmojo.twittrends.model.HashTag;
import com.techmojo.twittrends.strategy.impl.HashTagTrendingStrategy;

public class TwitterTrendsTest {

	private TwitterTrends twitterTrends;

	@Before
	public void setup() {
		HashTagTrendingStrategy strategy = new HashTagTrendingStrategy();
		HashMap<HashTag, Long> input = new HashMap<>();
		input.put(new HashTag("#one"), 2L);
		input.put(new HashTag("#two"), 4L);
		input.put(new HashTag("#three"), 1L);
		input.put(new HashTag("#four"), 1L);
		input.put(new HashTag("#five"), 1L);
		input.put(new HashTag("#six"), 1L);
		input.put(new HashTag("#seven"), 1L);
		input.put(new HashTag("#eight"), 1L);
		input.put(new HashTag("#nine"), 1L);
		input.put(new HashTag("#ten"), 1L);
		input.put(new HashTag("#eleven"), 1L);
		input.put(new HashTag("#twelve"), 1L);
		input.put(new HashTag("#thirteen"), 1L);
		input.put(new HashTag("#fourteen"), 1L);
		strategy.setInput(input);
		twitterTrends = new TwitterTrends(strategy);
	}

	@Test
	public void getTopTenTrendingHashTags() {
		HashTag[] expected = {
				new HashTag("#two"),
				new HashTag("#one"),
				new HashTag("#eight"),
				new HashTag("#eleven"),
				new HashTag("#five"),
				new HashTag("#four"),
				new HashTag("#fourteen"),
				new HashTag("#nine"),
				new HashTag("#seven"),
				new HashTag("#six")
		};
		assertArrayEquals(expected, twitterTrends.getTrendingHashTags().toArray());
	}

}
