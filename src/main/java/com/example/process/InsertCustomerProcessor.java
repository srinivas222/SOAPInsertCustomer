package com.example.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


import com.customer.InsertCustomerRequest;



public class InsertCustomerProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("Processor class");
		InsertCustomerRequest customer = (InsertCustomerRequest) exchange.getIn().getBody();
		System.out.println("Customer data is "+customer.getId());
		exchange.getIn().setHeader("id", customer.getId());
		exchange.getIn().setHeader("name", customer.getName());
		exchange.getIn().setHeader("email", customer.getEmail());
		exchange.getIn().setHeader("location", customer.getLocation());

	}

}
