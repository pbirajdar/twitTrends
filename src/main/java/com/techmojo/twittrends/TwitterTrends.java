package com.techmojo.twittrends;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.techmojo.twittrends.exception.NoOfTwitsValidatorException;
import com.techmojo.twittrends.matcher.PatternMatcher;
import com.techmojo.twittrends.matcher.impl.HashTagMatcher;
import com.techmojo.twittrends.model.HashTag;
import com.techmojo.twittrends.model.Twit;
import com.techmojo.twittrends.strategy.TrendingStrategy;
import com.techmojo.twittrends.validator.impl.NoOfTwitsValidator;

public final class TwitterTrends {

	private static final Long MAX_HASHTAG_TRENDS = 10L;
	private BufferedReader bReader;
	private TrendingStrategy<HashMap<HashTag, Long>, HashTag> strategy;
	private HashMap<HashTag, Long> hashTagsBase;

	public TwitterTrends(TrendingStrategy<HashMap<HashTag, Long>, HashTag> strategy) {
		this.strategy = strategy;
		bReader = new BufferedReader(new InputStreamReader(System.in));
		hashTagsBase = new HashMap<>();
	}

	public List<HashTag> getTrendingHashTags() {
		return strategy.getTrendings().stream().limit(MAX_HASHTAG_TRENDS).collect(Collectors.toList());
	}

	public void startGettingTwitsFromUser(Long noOfTwits) throws IOException {
		for (int i = 0; i < noOfTwits; i++) {
			PatternMatcher hashTagMatcher = new HashTagMatcher(new Twit(bReader.readLine()));
			hashTagMatcher.forEach(hashTagStr -> {
				HashTag hashTag = new HashTag(hashTagStr);
				if (hashTagsBase.containsKey(hashTag))
					hashTagsBase.put(hashTag, hashTagsBase.get(hashTag) + 1);
				else
					hashTagsBase.put(hashTag, 1L);
			});
		}
	}

	public void startGettinInputsFromUser() throws IOException {
		try {
			System.out.println("Enter No Of Twits: ");
			String noOfTwitsStr = bReader.readLine();
			new NoOfTwitsValidator(noOfTwitsStr).validate();
			Long noOfTwits = Long.parseLong(noOfTwitsStr);
			startGettingTwitsFromUser(noOfTwits);
			strategy.setInput(hashTagsBase);
		} catch (NoOfTwitsValidatorException noOfTwitsValidatorException) {
			System.err.println(noOfTwitsValidatorException.getMessage());
			System.exit(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}

	}

}
