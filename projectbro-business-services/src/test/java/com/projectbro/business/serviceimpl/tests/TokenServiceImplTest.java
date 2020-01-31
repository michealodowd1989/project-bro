package com.projectbro.business.serviceimpl.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.projectbro.business.serviceImpl.TokenServiceImpl;

public class TokenServiceImplTest {

	TokenServiceImpl service = new TokenServiceImpl();
	
	@Test
	public void generateToken_tokenIsCorrectLength() {
		String resultToken = service.generateToken();
		assertEquals(resultToken.length(), 11);
	}
}
