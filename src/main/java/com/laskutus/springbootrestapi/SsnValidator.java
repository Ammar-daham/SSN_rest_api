package com.laskutus.springbootrestapi;

import java.time.DateTimeException;
import java.time.LocalDate;

public class SsnValidator {

	public static boolean isValidSSN(String ssn) {
		// Check length
		if (ssn.length() != 11) {
			return false;
		}

		// Check format
		if (!ssn.matches("\\d{6}[-]\\d{3}[A-Z]")) {
			System.out.println(ssn.matches("\\d{6}[-]\\d{3}[A-Z]"));
			return false;
		}

		// Check date
		int day = Integer.parseInt(ssn.substring(0, 2));
		int month = Integer.parseInt(ssn.substring(2, 4));
		int year = Integer.parseInt(ssn.substring(4, 6));
		if (!isValidDate(day, month, year)) {
			System.out.println(isValidDate(day, month, year));
			return false;
		}

		// Check the validity of the last character
		String controlChars = "0123456789ABCDEFHJKLMNPRSTUVWXY";
		int controlValue = Integer.parseInt(ssn.substring(0, 6) + ssn.substring(7, 10));
		char calculatedControlChar = controlChars.charAt(controlValue % 31);
		char actualControlChar = ssn.charAt(10);
		System.out.println(calculatedControlChar + " " + actualControlChar + " " + controlValue);

		if (calculatedControlChar != actualControlChar) {
			return false;
		}

		return true;
	}

	private static boolean isValidDate(int day, int month, int year) {
		if (year <= 100) {
			year += 1900;
		} else {
			year += 2000;
		}
		try {
			LocalDate.of(year, month, day);
			return true;
		} catch (DateTimeException e) {
			return false;
		}
	}
}
