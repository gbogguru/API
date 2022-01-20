package com.bogguru.hep.digital.hep.error;

import org.springframework.validation.BindingResult;

import com.bogguru.hep.digital.hep.util.HepErrorCode;

public class InputValidationException extends APIException {

	
	private static final long serialVersionUID = -7597845035846021159L;

	private final HepErrorCode hepErrorCode;
	
	private transient BindingResult validationError;
	
	private String source;
	
	
	public InputValidationException(HepErrorCode hepErrorCode, String message, String source) {
		super(message);
		this.hepErrorCode = hepErrorCode;
		this.source = source;
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
