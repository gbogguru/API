package com.bogguru.hep.digital.hep.error;

import java.util.List;

public class ErrorResponse {

	private String code;
	
	private List<String> causes;
	
	private String source;
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String code, List<String> causes, String source) {
		super();
		this.code = code;
		this.causes = causes;
		this.source = source;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getCauses() {
		return causes;
	}

	public void setCauses(List<String> causes) {
		this.causes = causes;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	
	
}
