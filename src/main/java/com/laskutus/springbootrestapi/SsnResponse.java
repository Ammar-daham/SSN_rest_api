package com.laskutus.springbootrestapi;

public class SsnResponse {

	private boolean ssnValid;

	public SsnResponse(boolean ssnValid) {
		this.ssnValid = ssnValid;
	}

	public boolean isSSNValid() {
		return ssnValid;
	}

	public void setSSNValid(boolean ssnValid) {
		this.ssnValid = ssnValid;
	}

}