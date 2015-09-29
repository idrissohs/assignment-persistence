package edu.toronto.csc301;

import java.util.HashSet;
import java.util.Set;

public class Tweet implements ITweet{
	
	private String username;
	private String text;

	public Tweet (String username, String text){
		setUsername(username);
		setText(text);
		
	}
	
	public Tweet() {
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		if(username == null){
			throw new NullPointerException();
		}
		
		if(!(checkLegalUsername(username))){
			throw new IllegalArgumentException();
		}
		
		this.username = username;
		
		//Checks Complete. Add rest of the functionality;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		if(text == null){
			throw new NullPointerException();
		}
		
		if(text.trim().isEmpty()){
			throw new IllegalArgumentException();
		}
		
		if(text.length() > 140){
			throw new IllegalArgumentException();
		}
		
		this.text = text;
		//Checks Complete. Add rest of the functionality.
	}

	@Override
	public Set<String> getHashTags() {
		Set<String> hashTags = new HashSet<>();
		String [] textParts = text.split(" ");
		for (int i = 0; i < textParts.length; i++){
			String part = textParts[i].trim();
			if(part.startsWith("#")){
				String textWithoutHash = part.substring(1);
				if(textWithoutHash.length() > 0){
					String[] words = textWithoutHash.split("[^a-zA-Z0-9_']+");
					hashTags.add(words[0]);
				}
			}
		}
		
		return hashTags;
	}

	
	public boolean checkLegalUsername(String username){
		if(username.length() > 32){
			return false;
		}
		if(username.length() == 0){
			return false;
		}
		
		for(int i = 0; i < username.length(); i++){
			char c = username.charAt(i);
			if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')) || ((c >= 0) && (c <= 9)) || (c == '_')){
			} else {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(Tweet.class.isAssignableFrom(obj.getClass()))){
			return false;
		}
		Tweet tweet = (Tweet) obj;
		if(tweet.getUsername().equals(this.username) && (tweet.getText().equals(text))){
			return true;
		}
		return false;
	}
}
