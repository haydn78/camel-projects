package com.techlabs.camel_connect;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */

public class App 
{
	
    public static void main( String[] args ) throws InterruptedException 
    {
        System.out.println( "Hello World!" );
      //  BasicConfigurator.configure();
        
        CamelContext ctx = new DefaultCamelContext();
		try {
			ctx.addRoutes(new AppHTTPRouteBuilder());

			//	ctx.addRoutes(new AppRouterBuilder());
			ActiveMQConnectionFactory jmsCF = new ActiveMQConnectionFactory("tcp://AUSMEL150358L:61616");
			ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(jmsCF));
			ctx.getRegistry().bind("filebeanPrinter", new AppBeanPrinter());
			ctx.getRegistry().bind("jmsbeanPrinter", new AppBeanPrinter());
			
			ctx.addRoutes(new AppFileRouteBuilder());
			ctx.addRoutes(new AppJMSRouteBuilder());
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.start();
		 System.out.println("Running for 10 seconds and then stopping");
	     Thread.sleep(100000);
    }

	
}
