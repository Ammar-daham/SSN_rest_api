package com.laskutus.springbootrestapi;

import java.time.DateTimeException;
import java.time.LocalDate;

public class SSNValidator {

	public static boolean isValidSSN(String ssn) {
		// Check length
		if (ssn == null || ssn.length() != 11) {
			return false;
		}

		// Check format
		if (!ssn.matches("\\d{6}[-+A]\\d{4}") && !ssn.matches("\\d{6}[-+A]\\d{3}[A-Z]")) {
			return false;
		}

		// Check date
		int day = Integer.parseInt(ssn.substring(0, 2));
		int month = Integer.parseInt(ssn.substring(2, 4));
		if (day < 1 || day > 31 || month < 1 || month > 12) {
			return false;
		}
		if (month == 2 && day > 29) {
			return false;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
			return false;
		}

		// Check year
		int year = Integer.parseInt(ssn.substring(4, 6));
		if (year < 2) {
			year += 2000;
		} else if (year < 100) {
			year += 1900;
		} else {
			year += 1800;
		}
		try {
			LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
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

}
