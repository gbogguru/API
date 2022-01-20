package com.bogguru.hep.digital.hep.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bogguru.hep.digital.hep.service.CustomerService;
import com.bogguru.hep.digital.hep.util.CommonUtil;

@RestController
@RequestMapping(value = "/application")
public class CustomerController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public CustomerService customerService;
	
	@Autowired
	public CommonUtil commonUtil;
	
	@PostMapping("/customer")
	public String customer(@ModelAttribute("name") String name,
			@ModelAttribute("email") String email, @ModelAttribute("status") String status) {
		
		log.info("CustomerController - add customer method call starts here");
		
		commonUtil.validateCustomerDetails(name, email, status);
		Long custId = customerService.addCustomer(name, email, status);
		
		
		return "Customer added to H2 Database - Customer ID is : " + custId;
	}

	@GetMapping("/")
	public String welcome() {
		
		return "Welcome to Spring Boot Leanring...";
	}
	
	@GetMapping("/test")
	public String test(@ModelAttribute("name") String name) {
		
		return "Test - Given name - " + name;
	}
	
}
