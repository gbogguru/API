package com.bogguru.hep.digital.hep.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bogguru.hep.digital.hep.error.APIException;
import com.bogguru.hep.digital.hep.error.ErrorInfo;
import com.bogguru.hep.digital.hep.error.ErrorResponse;
import com.bogguru.hep.digital.hep.util.CommonUtil;

@ControllerAdvice
public class GenericExceptionHandler {
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public CommonUtil commonUtil;
	
	@ExceptionHandler
	@ResponseBody
	public final ResponseEntity<ErrorInfo> handleAPIException(final APIException apiException) {
		
		ErrorInfo errorResponse = null;
		
		BindingResult validationError = apiException.getValidationError();
		
		if (validationError == null) {
			errorResponse = buildErrorResponse(apiException);
		}
		
		
		switch (apiException.getHepErrorCode()) {
			case HEP_NAME_IS_MISSING:
				return new ResponseEntity<ErrorInfo>(errorResponse, HttpStatus.BAD_REQUEST);
			
			case HEP_EMAIL_IS_MISSING:
				return new ResponseEntity<ErrorInfo>(errorResponse, HttpStatus.BAD_REQUEST);
				
			case HEP_STATUS_IS_MISSING:
				return new ResponseEntity<ErrorInfo>(errorResponse, HttpStatus.BAD_REQUEST);
			
			default:
				return new ResponseEntity<ErrorInfo>(errorResponse, HttpStatus.NOT_IMPLEMENTED);
		}
		
	}
		
	private ErrorInfo buildErrorResponse(final APIException apiException) {
		
		ErrorInfo errorInfo = new ErrorInfo();
		
		List<ErrorResponse> errorResponseList = new ArrayList<ErrorResponse>();
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(apiException.getHepErrorCode().getHepErrorCode());
		
		List<String> cause = new ArrayList<String>();
		
		cause.add(apiException.getMessage());
		
		errorResponse.setCauses(cause);
		errorResponse.setSource(apiException.getSource());
		errorResponseList.add(errorResponse);
		
		
		errorInfo.setErrorInfo(errorResponseList);
		
		return errorInfo;			
	
	}

}
