package com.techlabs.camel_connect;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class AppScheduleRouteBuilder extends RouteBuilder  {
	
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:camel-connect-timer?period=10s")
		.log(LoggingLevel.INFO,"timer-name is + ${body.exchangeProperty.TIMER_NAME}")
		.log(LoggingLevel.INFO,"${body.camelId}")
		.bean("beanPrinter","printHeaders")
		//.bean(AppBeanCounter.class)
		.bean("beanPrinter","test")
		.log(LoggingLevel.INFO,"${body}");
		
		
		//.to("file:C://tmp//camel?filename=test.out&fileExist=Append");
	}

}
