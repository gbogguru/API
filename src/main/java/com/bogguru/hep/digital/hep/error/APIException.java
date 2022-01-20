package com.bogguru.hep.digital.hep.error;

import org.springframework.validation.BindingResult;

import com.bogguru.hep.digital.hep.util.HepErrorCode;

public class APIException extends RuntimeException {

	
	private static final long serialVersionUID = 2241793932706409017L;

	private final HepErrorCode hepErrorCode;
	
	private transient BindingResult validationError;
	
	private String source;
	
	
	public APIException(final String message) {
		super(message);
		this.hepErrorCode = null;
		this.validationError = null;
	}

	public APIException(HepErrorCode hepErrorCode, String message, Throwable throwable ) {
		super(message, throwable);
		this.hepErrorCode = hepErrorCode;
		this.validationError = null;
	}
	

	public BindingResult getValidationError() {
		return validationError;
	}

	public void setValidationError(BindingResult validationError) {
		this.validationError = validationError;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public HepErrorCode getHepErrorCode() {
		return hepErrorCode;
	}
		
	
}
