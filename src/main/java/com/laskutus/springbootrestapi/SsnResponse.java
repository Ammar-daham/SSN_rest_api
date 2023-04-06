package com.laskutus.springbootrestapi;

public class SSNResponse {

	private boolean ssnValid;

	public SSNResponse(boolean ssnValid) {
		this.ssnValid = ssnValid;
	}

	public boolean isSSNValid() {
		return ssnValid;
	}

	public void setSSNValid(boolean ssnValid) {
		this.ssnValid = ssnValid;
	}

}