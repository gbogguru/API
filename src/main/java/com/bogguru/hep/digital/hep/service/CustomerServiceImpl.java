package com.bogguru.hep.digital.hep.service;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bogguru.hep.digital.hep.entity.Customer;
import com.bogguru.hep.digital.hep.repository.CustomerRepository;

@Service
@Qualifier("customerService")
public class CustomerServiceImpl implements CustomerService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Long addCustomer(String name, String email, String status) {
		
		log.info("CustomerServiceImpl - add customer method call starts here");
		
		Customer customer = new Customer();
		customer.setCustomerName(name);
		customer.setCustomerEmail(email);
		customer.setCustomerStatus(status);
		
		customerRepository.save(customer);
		
		new Thread(() -> {
			// We can make some more External API call or DB call or PubSub Calls 
			// which will execute at backgrounds
		});
		
		//Consumer<T>
		//BiConsumer<T, U>
		//BiFunction<T, U, R>
		//BiFunction<T, U, R>
		
		return customer.getCustomerId();
	}
}
