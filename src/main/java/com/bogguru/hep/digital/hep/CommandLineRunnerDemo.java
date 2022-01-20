package com.bogguru.hep.digital.hep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

	@Autowired
	public ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		
		String[] beans = ctx.getBeanDefinitionNames();
		
		int i = 0;
		for (String bean : beans) {
			i++;
			//System.out.println(" Bean " + i + " " + bean );
		}
		
		System.out.println("The total bean count is : " + i);
	}
	
	

}
