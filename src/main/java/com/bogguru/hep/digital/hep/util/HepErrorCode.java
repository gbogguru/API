package com.bogguru.hep.digital.hep.util;

public enum HepErrorCode {
	
	HEP_NAME_IS_MISSING("HEP_1001"),	
	HEP_EMAIL_IS_MISSING("HEP_1002"),
	HEP_STATUS_IS_MISSING("HEP_1003");
	
	
	private final String hepErrorCode;
	
	private HepErrorCode(String hepErrorCode) {
		this.hepErrorCode = hepErrorCode;
	}
	
	public String getHepErrorCode() {
		return hepErrorCode;
	}

}
