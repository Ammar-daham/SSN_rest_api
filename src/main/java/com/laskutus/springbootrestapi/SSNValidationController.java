package com.laskutus.springbootrestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSNValidationController {

	@PostMapping("/validate_ssn")
	public ResponseEntity<SsnResponse> validateSSN(@RequestBody SsnRequest request) {

		if (!request.getCountryCode().equals("FI")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		String ssn = request.getSsn();

		// Implement SSN validation logic here

		boolean isValid = isValidSSN(ssn); // Replace with actual validation logic

		System.out.println(isValid);

		SsnResponse response = new SsnResponse(isValid);
		return ResponseEntity.ok(response);
	}

	public static boolean isValidSSN(String ssn) {
		// Check length
		if (ssn.length() != 11) {
			return false;
		}

		// Check format
		if (!ssn.matches("\\d{6}[-+\\d][A-Z]\\d{2}[A-Z\\d]")) {
			return false;
		}

		// Check control character
		int controlCharValue = getControlCharValue(ssn.substring(0, 6) + ssn.substring(7, 10));
		char actualControlChar = ssn.charAt(10);
		char expectedControlChar = getControlChar(actualControlChar, controlCharValue);
		System.out.println(controlCharValue + " " + expectedControlChar + " " + actualControlChar);

		return actualControlChar == expectedControlChar;
	}

	private static int getControlCharValue(String s) {
		int num = Integer.parseInt(s);
		return num % 31;
	}

	private static char getControlChar(char actualControlChar, int controlCharValue) {
		char[] controlCharTable = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'H',
				'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };
		int actualControlCharIndex = -1;
		for (int i = 0; i < controlCharTable.length; i++) {
			if (controlCharTable[i] == actualControlChar) {
				actualControlCharIndex = i;
				break;
			}
		}
		if (actualControlCharIndex == -1) {
			throw new IllegalArgumentException("Invalid control character: " + actualControlChar);
		}
		return controlCharTable[(actualControlCharIndex + controlCharValue) % 31];
	}

}
