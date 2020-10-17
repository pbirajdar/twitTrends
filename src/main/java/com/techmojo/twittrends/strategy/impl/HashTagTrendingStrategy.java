package com.techmojo.twittrends.strategy.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.techmojo.twittrends.model.HashTag;
import com.techmojo.twittrends.strategy.TrendingStrategy;

public class HashTagTrendingStrategy extends TrendingStrategy<HashMap<HashTag, Long>, HashTag> {

	@Override
	public List<HashTag> getTrendings() {
		List<Entry<HashTag, Long>> hashTagEntries = new ArrayList<>(getInput().entrySet());
		Comparator<Entry<HashTag, Long>> comparator = new HashTagTrendingComparator();
		Collections.sort(hashTagEntries, comparator);
		return hashTagEntries.stream().map(entry -> entry.getKey()).collect(Collectors.toList());
	}

	private class HashTagTrendingComparator implements Comparator<Entry<HashTag, Long>> {
		@Override
		public int compare(Entry<HashTag, Long> a, Entry<HashTag, Long> b) {
			if (b.getValue().equals(a.getValue()))
				return a.getKey().compareTo(b.getKey());
			else
				return b.getValue().compareTo(a.getValue());
		}
	}
}
