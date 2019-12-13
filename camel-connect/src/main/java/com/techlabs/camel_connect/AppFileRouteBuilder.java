package com.techlabs.camel_connect;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;

public class AppFileRouteBuilder extends RouteBuilder  {
	
	DataFormat bindy = new BindyCsvDataFormat(AppFileDataModel.class);
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:C://tmp//camel//poll?fileName=InCustomer.csv&noop=true&delay=10s")
		.bean("filebeanPrinter","printHeaders")
		.log("${body}")
		//	.bean("beanPrinter","printBody")
	//	.log("${header.CamelFileLength}")
	    .unmarshal(bindy)
		.split(body())
//		.process(new AppFileProcessor())
//		.setHeader(Exchange.FILE_NAME, constant("OutCustomer.json"))
		.marshal().json(JsonLibrary.Jackson)
		//.bean("filebeanPrinter","printBody")
		//.to("file:C://tmp//camel//poll//done");
		.log("${body}")
		.to("jms:queue:foo.bar?username=admin&password=admin");
	}

}
