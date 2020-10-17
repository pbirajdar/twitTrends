package com.techmojo.twittrends;

import java.io.IOException;

import com.techmojo.twittrends.strategy.impl.HashTagTrendingStrategy;

public class App {
	public static void main(String[] args) throws IOException {
		TwitterTrends trends = new TwitterTrends(new HashTagTrendingStrategy());
		trends.startGettinInputsFromUser();
		System.out.println(trends.getTrendingHashTags());
	}
}
