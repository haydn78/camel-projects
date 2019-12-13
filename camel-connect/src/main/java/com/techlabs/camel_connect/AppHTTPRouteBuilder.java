package com.techlabs.camel_connect;

import org.apache.camel.builder.RouteBuilder;

public class AppHTTPRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("jetty:http://localhost:9061/posts")
		.log("${body}")
		.setId("AppHTTPRouteBuilder");
	}

}
