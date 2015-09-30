package edu.toronto.csc301;

import java.util.*;

public class Database implements IDatabase{

	private List<ITweet> tweets;
	
	@Override
	public void loadTweets(List<ITweet> tweets) {
		//load the tweets to the db
		this.tweets = tweets;
	}

	@Override
	public int getTotalNumberOfTweets() {
		//return the total number of tweets in the db
		return tweets.size();
	}

	@Override
	public int getNumberOfUniqueUsers() {
		//return the number of unique users in the db
		Set<String> list = new HashSet<>();
		for (int i=0; i< tweets.size(); i++){
			list.add(tweets.get(i).getUsername());
		}
		return list.size();
	}

	@Override
	public int getNumberOfUniqueHashTags() {
		//return the number of unique users in the db
		Set<String> list = new HashSet<>();
		for (int i=0; i< tweets.size(); i++){
			list.addAll(tweets.get(i).getHashTags());
		}
		return list.size();
	}

	@Override
	public double getAverageNumberOfHashTagsPerTweet() {
		// returns number of hashtags divided by the number of tweets
		int count = 0;
		for (int i=0; i< tweets.size(); i++){
			count+=tweets.get(i).getHashTags().size();
		}
		if (tweets.size()==0){
			return 0;
		}
		return (double) count /  tweets.size();
	}

	@Override
	public double getAverageNumberOfTweetsPerUser() {
		// return number of tweets divided by number of users
		if (getNumberOfUniqueUsers () == 0){
			return 0;
		}
		return (double) tweets.size() / getNumberOfUniqueUsers();
	}

	@Override
	public String getMostPopularHashTag() {
		// returns the most popular hash tags
		Set<String> list = new TreeSet<>();
		for (int i=0; i< tweets.size(); i++){
			list.addAll(tweets.get(i).getHashTags());
		}
		if(list.size() == 0){
			return null;
		}
		return ((TreeSet<String>) list).first();
	}

}
