package com.techlabs.camel_connect;

import org.apache.camel.builder.RouteBuilder;

public class AppJMSRouteBuilder extends RouteBuilder  {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("jms:queue:foo.bar")
		.log("${body}")
		.setHeader("CamelHttpMethod", constant("POST"))
	//	.to("http://jsonplaceholder.typicode.com/posts?synchronous=true")
		.to("http://localhost:9061/posts?synchronous=true")
	//	.bean("jmsbeanPrinter","printHeaders")
		.bean("jmsbeanPrinter","printBody")
		.transform(body().regexReplaceAll("\\([^ ]*\\) \\(.*\\)", "\\U\\w"))
		.log("${body}")
		.setId("AppJMSRouteBuilder");
			
		
	}

}
