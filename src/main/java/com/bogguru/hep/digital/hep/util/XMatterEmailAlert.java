package com.bogguru.hep.digital.hep.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class XMatterEmailAlert {

	Logger logger = LoggerFactory.getLogger(XMatterEmailAlert.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${xMattersAlert.url}")
	private String url;
	
	@Value("${xMattersAlert.key}")
	private String key;
	
	@Value("${xMattersAlert.type}")
	private String type;
	
	@Value("${xMattersAlert.version}")
	private String version;
	
	@Value("${xMattersAlert.object}")
	private String object;
	
	@Value("${xMattersAlert.severity}")
	private String severity;
	
	@Value("${xMattersAlert.env}")
	private String env;
	
	
	public void alertXMattersEmail() {
		
		StringBuffer sb = new StringBuffer(url);
		sb.append("?@key=" + key);
		sb.append("&@type=" + type);
		sb.append("&@version=" + version);
		sb.append("&@severity=" + severity);
		sb.append("&object=" + object);
		sb.append("&occurtime=" + System.currentTimeMillis());
		
		restTemplate.postForEntity(sb.toString(), null, String.class);
		
	}
	
}
