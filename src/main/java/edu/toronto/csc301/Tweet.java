package edu.toronto.csc301;

import java.util.Set;

public class Tweet implements ITweet{
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsername(String username) {
		if(username == null){
			throw new NullPointerException();
		}
		
		if(!(checkLegalUsername(username))){
			throw new IllegalArgumentException();
		}
		
		//Checks Complete. Add rest of the functionality;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		if(text == null){
			throw new NullPointerException();
		}
		
		if(text.trim().isEmpty()){
			throw new IllegalArgumentException();
		}
		
		//Checks Complete. Add rest of the functionality.
	}

	@Override
	public Set<String> getHashTags() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean checkLegalUsername(String username){
		for(int i = 0; i < username.length(); i++){
			char c = username.charAt(i);
			if (((c > 'a') && (c < 'z')) || ((c > 'A') && (c < 'Z')) || ((c > 0) && (c < 9)) || (c == '_')){
			} else {
				return false;
			}
		}
		return true;
	}
}
