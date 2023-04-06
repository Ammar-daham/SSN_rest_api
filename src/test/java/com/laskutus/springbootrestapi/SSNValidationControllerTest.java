package com.laskutus.springbootrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SSNValidationControllerTest {

	@Test
	public void testValidRequest() {
		SSNRequest request = new SSNRequest();
		request.setSSN("131052-308T");
		request.setCountryCode("FI");

		SSNValidationController controller = new SSNValidationController();
		ResponseEntity<SSNResponse> responseEntity = controller.validateSSN(request);
		SSNResponse response = responseEntity.getBody();

		assertNotNull(response);
		assertTrue(response.isSSNValid());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void testInvalidCountryCode() {
		SSNRequest request = new SSNRequest();
		request.setSSN("010190-123A");
		request.setCountryCode("SE");

		SSNValidationController controller = new SSNValidationController();
		ResponseEntity<SSNResponse> responseEntity = controller.validateSSN(request);

		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void testInvalidSSN() {
		SSNRequest request = new SSNRequest();
		request.setSSN("310290-1234");
		request.setCountryCode("FI");

		SSNValidationController controller = new SSNValidationController();
		ResponseEntity<SSNResponse> responseEntity = controller.validateSSN(request);
		SSNResponse response = responseEntity.getBody();

		assertNotNull(response);
		assertFalse(response.isSSNValid());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
