package com.techmojo.twittrends.matcher.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.techmojo.twittrends.model.Twit;

public class HashTagMatcherTest {

	private HashTagMatcher matcher;

	@Before
	public void setup() {
		matcher = new HashTagMatcher();
	}

	@Test
	public void shouldFetchAllHashTagsToken() {
		Twit twit = new Twit("Hello #world i'm #prashant and i'm #SoftwareDevelpoer. Proud to be #coder");
		matcher.setTwit(twit);
		Set<String> expectedHashTags = new HashSet<>();
		expectedHashTags.add("#world");
		expectedHashTags.add("#prashant");
		expectedHashTags.add("#SoftwareDevelpoer");
		expectedHashTags.add("#coder");
		findAndCompareHashTags(expectedHashTags);
	}

	@Test
	public void shouldFetchZeroHashTagsTokenForBlankString() {
		Twit twit = new Twit("");
		matcher.setTwit(twit);
		Set<String> expectedHashTags = new HashSet<>();
		findAndCompareHashTags(expectedHashTags);
	}

	@Test
	public void shouldFetchZeroHashTagsTokenForStringWhichContainOnlyHashTag() {
		Twit twit = new Twit("#");
		matcher.setTwit(twit);
		Set<String> expectedHashTags = new HashSet<>();
		findAndCompareHashTags(expectedHashTags);
	}

	@Test
	public void shouldFetchZeroHashTagsTokenForNullTwit() {
		matcher.setTwit(null);
		Set<String> expectedHashTags = new HashSet<>();
		findAndCompareHashTags(expectedHashTags);
	}

	@Test
	public void shouldFetchHashTagsTokenForStringWhichContainOnlyValidHashTag() {
		Twit twit = new Twit("#one#two#three");
		matcher.setTwit(twit);
		Set<String> expectedHashTags = new HashSet<>();
		expectedHashTags.add("#one");
		expectedHashTags.add("#two");
		expectedHashTags.add("#three");
		findAndCompareHashTags(expectedHashTags);
	}

	private void findAndCompareHashTags(Set<String> expectedHashTags) {
		int count = 0;
		for (String hashTag : matcher) {
			assertTrue(String.format("extracted hashtag %s is not expected from the given twit.", hashTag),
					expectedHashTags.contains(hashTag));
			count++;
		}
		assertEquals(String.format("Expected total %d hashtags but found only %d.", expectedHashTags.size(), count),
				expectedHashTags.size(), count);
	}

}
