package com.rajantech.camel.routes;

import java.util.HashMap;
import java.util.Map;


import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Processor;

@Component
public class GoogleBigQueryRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("timer://foo?period=5s")
		.log("timer working")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				
				Map<String, String> map = new HashMap<String,String>();
				map.put("name", "Rajan");
				map.put("email", "rkushwaha@ups.com");
				map.put("phone", "**********");
				exchange.getIn().setBody(map);
			}
		})
		.log("insert query ${body}")
				
				  .setHeader("CamelGoogleBigQuery.InsertId").simple("${date:now:yyyy-MM-dd}")
				  // URI patter : component:projectID:dataset:tablename
				  .to("google-bigquery:e-order-232805:Emp_Dataset:employee")
				 
		.log("${headers}");
		
	}

}
