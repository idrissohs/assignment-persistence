package edu.toronto.csc301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader implements IDataLoader{

	@Override
	public List<ITweet> load(InputStream data) throws IOException {
		List<ITweet> tweets = new ArrayList<ITweet>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
		for(String individualData = bufferedReader.readLine(); individualData != null; individualData = bufferedReader.readLine()){
			if(individualData.length() > 0){
				tweets.add(processString(individualData));
			}
		}
		return tweets;
	}
	
	public ITweet processString(String tweetString){
		ITweet tweet = new Tweet();
		String tweetParts[] = tweetString.split(":");
		String username = tweetParts[0].trim();
		tweet.setUsername(username.substring(1));
		String text = tweetParts[1].trim();
		tweet.setText(text);
		return tweet;
	
	}

}