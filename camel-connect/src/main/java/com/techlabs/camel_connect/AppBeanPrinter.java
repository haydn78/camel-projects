package com.techlabs.camel_connect;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.log4j.Logger;

public class AppBeanPrinter {

   Logger logger =  Logger.getLogger(AppBeanPrinter.class);

	public AppBeanPrinter() {
		logger.info("AppCounter constructed"+this.hashCode());
		  
	}
	
	public void printHeaders(Exchange e) {
	   logger.info("Printing Headers "+e.getMessage().getHeaders().size());
	   e.getMessage().getHeaders()
	      .forEach((k,v) -> logger.info("Key = "+ k + ", Value = " + v)); 
	}
	
	
	public void test(Message m) {
		   logger.info("Testing ....."+" "+this.hashCode());
		   m.setBody(new String("Hello World"));
		   logger.info("Testing MEssage Bofy ....."+m.getBody());
						
	}
	
	public void printBody(Message m) {
		   if (m.getBody() != null) {
			   logger.info("Printing Body of Type "+m.getBody().getClass());
			   logger.info("Printing Body Details"+m.getBody().toString());
		   }
		   //e.getMessage().getBody()
		     // .forEach((k,v) -> logger.info("Key = "+ k + ", Value = " + v)); 
		}

	

}
