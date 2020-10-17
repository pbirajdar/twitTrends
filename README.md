# twitTrends

#### Problem Statement

Find the top 10 trending hashtags in twitter. You can write a standalone java class(es) / interfaces as deemed to be fit. 
Assumptions & notes : 
1) A tweet is a text being input by tweeters. 
2) A main method in a java class to be implemented which takes the tweet as an input. 
3) You need to extract hashtag from a tweet text (Ex: sachin is hashtag in the tweet -> " Worlds best cricketer is #sachin") 
4) Maintain a data structure that keeps tracking of the count of each hashtag that is coming to your main method 
5) print the list of top 10 hashtags at the end of main method execution 


#### Solution

Twitter shows trends in order to make its users aware of the trending news. These trends are nothing but trending hashtags that the users are tweeting about. For example: If thousands of users are talking about United States by adding a hashtag #US in their tweet, then US will be a trending hashtag. Couple of example tweets with hashtag #US could be:

Donald Trump becomes the 45th #US President
Roger Federer wins #US Open for 5th time
Given a list of NN tweets, your task is to find top the five trending hashtags. Each tweet, let’s call it SS, will contain at least one one word with hashtag. There will be maximum of three hashtags in any tweet. All hashtags in a single tweet will be unique.

#### Algorithm

	1. Maintain HashMap to maintain count of HashTag present in Twit.
	2. Then sort the entries of hashmap based on count or frequencies of hashtag.
		2.1 If any two hashtag frequency count is same then sort in lexicographical order.
	3. After sorting, return or display top ten hashtags from list.

#### Input:
First line of the input will contain N denoting the number of tweets.
Next N lines, each will contain a string S.

#### Output:
Print the top **ten** trending hashtags.