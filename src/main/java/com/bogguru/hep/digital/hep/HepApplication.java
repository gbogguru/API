package com.bogguru.hep.digital.hep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@EnableJpaRepositories(basePackages = {"com.bogguru.hep.digital.hep.repository"})
@EnableScheduling
@SpringBootApplication
public class HepApplication extends SpringBootServletInitializer {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverName;
	
	public static void main(String[] args) {
		SpringApplication.run(HepApplication.class, args);
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder springApplicationBuilder) {
		
		return springApplicationBuilder.sources(HepApplication.class);
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/messages");
		messageSource.setUseCodeAsDefaultMessage(false);
		messageSource.setCacheSeconds((int)TimeUnit.HOURS.toSeconds(1));
		messageSource.setFallbackToSystemLocale(false);
		log.info("HepApplication - messageSource method ");
		
		return messageSource;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	//@Bean
	public HikariDataSource getDataSource() throws IOException {
	
		HikariConfig config = new HikariConfig();
		
		config.setDriverClassName(null);
		config.setJdbcUrl(null);
		config.setUsername(null);
		config.setPassword(new String(Files.readAllBytes(Paths.get("/tmp/decrypt.txt"))));
		config.setPoolName(null);
		config.setMinimumIdle(0);
		config.setIdleTimeout(0);
		config.setConnectionTimeout(0);
		config.setMaximumPoolSize(0);
		config.setLeakDetectionThreshold(0);
		
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource;
	}
	
}
