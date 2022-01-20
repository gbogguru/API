package com.bogguru.hep.digital.hep.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.bogguru.hep.digital.hep.error.InputValidationException;

@Component
public class CommonUtil {

	public void validateCustomerDetails(String name, String email, String status) {

		if (name == null || StringUtils.isEmpty(name) ) {
			throw new InputValidationException(HepErrorCode.HEP_NAME_IS_MISSING, "Customer Name Missing", "Service API Layer");
		}
	}

}
