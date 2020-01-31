package com.projectbro.business.serviceImpl;

import java.util.Random;
import com.projectbro.business.service.TokenService;

public class TokenServiceImpl implements TokenService{
	private Random rand = new Random(); 
	private StringBuilder builder = new StringBuilder();
	
	public String generateToken() {
		builder.append(getThreeRandomNumbers());
		builder.append("-");
		builder.append(getThreeRandomLetters());
		builder.append("-");
		builder.append(getThreeRandomNumbers());
		return builder.toString();
	}
	
	private String getThreeRandomLetters() {
		String letters = "";
		char character;

		for (int letter = 0; letter < 3; letter++) {
			character = (char) (rand.nextInt(26) + 'a');
			letters += character;
		}
		return letters;
	}
	
	private int getThreeRandomNumbers() {
        return rand.nextInt(1000); 
	}
}
