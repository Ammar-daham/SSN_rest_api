package com.laskutus.springbootrestapi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SSNValidatorTest {

	@Test
	public void testValidSSN() {
		assertTrue(SSNValidator.isValidSSN("290296-7808"));
		assertTrue(SSNValidator.isValidSSN("131052-308T"));

	}

	@Test
	public void testInvalidSSN() {
		assertFalse(SSNValidator.isValidSSN("110301-A72"));
		assertFalse(SSNValidator.isValidSSN("110301-A72888"));
		assertFalse(SSNValidator.isValidSSN("110302-972X"));
		assertFalse(SSNValidator.isValidSSN("130231+A7288"));
		assertFalse(SSNValidator.isValidSSN("990301-A7288"));
		assertFalse(SSNValidator.isValidSSN("110301-A728I"));
	}

}
