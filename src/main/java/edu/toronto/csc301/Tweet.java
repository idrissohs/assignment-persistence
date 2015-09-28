package edu.toronto.csc301;

import java.util.Set;

public class Tweet implements ITweet{
	
	private String username;
	private String text;

	public Tweet (String username, String text){
		this.username = username;
		this.text = text;
	}
	
	public Tweet() {
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	
	//equals method to compare tweet objects
	@Override
	public boolean equals (Tweet obj){
		if (this.getUsername().equals(obj.getUsername()) && this.getText().equals(obj.getText())){
			return true;
		}
		return false;
	}

	@Override
	public void setUsername(String username) {
		if(username == null){
			throw new NullPointerException();
		}
		
		if((checkLegalUsername(username))){
			throw new IllegalArgumentException();
		}
		this.username = username;
		//Checks Complete. Add rest of the functionality;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public void setText(String text) {
		if(text == null){
			throw new NullPointerException();
		}
		
		if(checkLegalText(text)){
			throw new IllegalArgumentException();
		}
		
		this.text = text;
		//Checks Complete. Add rest of the functionality.
	}

	@Override
	public Set<String> getHashTags() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean checkLegalUsername(String username){
		//update the method to count the numnber of chars
		username.replaceAll("\\s+","");
		if (username.length() >= 32 || username.length()==0){
			return true;
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
	public boolean checkLegalText(String text){
		text.replaceAll("\\s+", "");
		if (text.length() > 140 || text.length()==0){
			return true;
		}
		for (int i = 0; i<text.length(); i++){
			char c = text.charAt(i);
			if (((c > 'a') && (c < 'z')) || ((c > 'A') && (c < 'Z')) || ((c > 0) && (c < 9)) || (c == '_')){
			} 
			else {
				return false;
			}
		}
		return true;
	}
}

