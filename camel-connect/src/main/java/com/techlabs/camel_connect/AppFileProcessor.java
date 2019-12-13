package com.techlabs.camel_connect;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class AppFileProcessor implements Processor {

  Logger logger =  Logger.getLogger(AppFileProcessor.class);

	@Override
	public void process(Exchange e) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Inside Processor "+  e.getMessage().getBody().toString());	
		
	}

}
