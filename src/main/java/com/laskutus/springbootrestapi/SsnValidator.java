package com.laskutus.springbootrestapi;

import java.time.LocalDate;

public class SsnValidator {

	public static boolean isValidSsn(String ssn) {
		// Check length
		if (ssn.length() != 11) {
			return false;
		}

		// Check format
		String regex = "\\d{6}[-+A]\\d{3}[\\dX]";
		if (!ssn.matches(regex)) {
			return false;
		}

		// Check date
		int day = Integer.parseInt(ssn.substring(0, 2));
		int month = Integer.parseInt(ssn.substring(2, 4));
		int year = Integer.parseInt(ssn.substring(4, 6));
		String centurySign = ssn.substring(6, 7);
		int century = 0;
		switch (centurySign) {
		case "-":
			century = 1900;
			break;
		case "+":
			century = 1800;
			break;
		case "A":
			century = 2000;
			break;
		default:
			return false;
		}
		LocalDate birthDate = LocalDate.of(century + year, month, day);
		if (birthDate.isAfter(LocalDate.now())) {
			return false;
		}

		// Check control character
		int[] weights = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9 };
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			int digit = Character.getNumericValue(ssn.charAt(i));
			sum += digit * weights[i];
		}
		int remainder = sum % 31;
		String controlCharacter = ssn.substring(10);
		String expectedControlCharacter = getControlCharacter(remainder);
		return controlCharacter.equals(expectedControlCharacter);
	}

	private static String getControlCharacter(int remainder) {
		String[] controlCharacters = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
				"H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y" };
		return controlCharacters[remainder];
	}
}
