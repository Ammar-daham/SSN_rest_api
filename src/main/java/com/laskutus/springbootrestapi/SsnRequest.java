package com.laskutus.springbootrestapi;

public class SSNRequest {

	private String ssn;
	private String countryCode;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCountryCode() {
		if (this.countryCode == null) {
			return "";
		}
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
