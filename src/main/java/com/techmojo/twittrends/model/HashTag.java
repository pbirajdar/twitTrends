package com.techmojo.twittrends.model;

public final class HashTag implements Comparable<HashTag> {

	private final String hashTagStr;

	public HashTag(String hashTagStr) {
		this.hashTagStr = hashTagStr;
	}

	public String getHashTag() {
		return hashTagStr;
	}

	@Override
	public int hashCode() {
		return hashTagStr.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		HashTag hashTag = (HashTag) obj;
		return hashTagStr.equals(hashTag.getHashTag());
	}

	@Override
	public String toString() {
		return hashTagStr;
	}

	@Override
	public int compareTo(HashTag hashTag) {
		return this.hashTagStr.compareTo(hashTag.getHashTag());
	}
}
