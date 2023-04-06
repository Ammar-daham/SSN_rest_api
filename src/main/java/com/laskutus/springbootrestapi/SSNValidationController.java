package com.laskutus.springbootrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSNValidationController {

	@PostMapping("/validate_ssn")
	public ResponseEntity<SSNResponse> validateSSN(@RequestBody SSNRequest request) {

		if (!request.getCountryCode().equals("FI")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		String ssn = request.getSsn();

		boolean isValid = SsnValidator.isValidSSN(ssn);

		SSNResponse response = new SSNResponse(isValid);
		return ResponseEntity.ok(response);
	}

}
