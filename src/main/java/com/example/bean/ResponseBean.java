package com.example.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;

import com.customer.CustomersResponse;
import com.customer.CustomersResponse.GetCustomerResponse;

public class ResponseBean {

	public CustomersResponse getData(Exchange exchange) {
		List<GetCustomerResponse> getCustomerResponse = new ArrayList<GetCustomerResponse>();
		CustomersResponse.GetCustomerResponse cust = null;
				Map<?, ?> customerDetailsMap = null;

		List<?> customerDetailsList = (List<?>) exchange.getIn().getBody();
		System.out.println(customerDetailsList);

		if (customerDetailsList != null && customerDetailsList.size() > 0) {
			for(int i=0; i<customerDetailsList.size();i++) {
				cust=new CustomersResponse.GetCustomerResponse();
			customerDetailsMap = (Map<?, ?>) customerDetailsList.get(i);
			cust.setId((Integer) customerDetailsMap.get("cid"));
			cust.setName(customerDetailsMap.get("cname").toString());
			cust.setEmail(customerDetailsMap.get("email").toString());
			cust.setLocation(customerDetailsMap.get("location").toString());
			System.out.println((Integer) customerDetailsMap.get("cid"));
			System.out.println(customerDetailsMap.get("cname").toString());
			System.out.println(customerDetailsMap.get("email").toString());
			System.out.println(customerDetailsMap.get("location").toString());
			getCustomerResponse.add(cust);
			
			}

		}
		return   getCustomerResponse;
		 
	}

}
