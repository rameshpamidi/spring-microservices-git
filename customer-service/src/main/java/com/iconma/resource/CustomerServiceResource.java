package com.iconma.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iconma.constants.CustomerServiceRestEndPoints;
import com.iconma.model.Customer;

@RestController
@RequestMapping(value = {CustomerServiceRestEndPoints.ROOT_CUSTOMER_ENDPOINT })
public class CustomerServiceResource {
	private static final String SAVE_CUSTOMER_DBSERVICE_ENDPOINT="http://db-service/customer/saveCustomer";
	private static final String UPDATE_CUSTOMER_DBSERVICE_ENDPOINT="http://db-service/customer/updateCustomer";
	private static final String DELETE_CUSTOMER_DBSERVICE_ENDPOINT="http://db-service/customer/deleteCustomerById";
	private static final String DETETEALL_CUSTOMERD_DBSERVICE_ENDPOINT="http://db-service/customer/deleteAllCustomerse";
	private static final String FIND_CUSTOMER_DBSERVICE_ENDPOINT="http://db-service/customer/findCustomerById";
	private static final String FINDALL_CUSTOMERS_DBSERVICE_ENDPOINT="http://db-service/customer/findAllCustomers";
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value = { CustomerServiceRestEndPoints.SAVE_CUSTOMER_ENDPOINT })
	public Customer saveCustomer(@RequestBody Customer customer) {
		return restTemplate.postForObject(SAVE_CUSTOMER_DBSERVICE_ENDPOINT, customer, Customer.class);
	}

	@PutMapping(value = {CustomerServiceRestEndPoints.UPDATE_CUSTOMER_ENDPOINT})
	public Customer updateCustomer(@RequestBody Customer customer) {
		return restTemplate.postForObject(UPDATE_CUSTOMER_DBSERVICE_ENDPOINT, customer, Customer.class);
	}

	@PutMapping(value = { CustomerServiceRestEndPoints.DELETE_CUSTOMER_ENDPOINT })
	public void deleteCustomer(@PathVariable("customerId") final int customerId) {
		 restTemplate.delete(DELETE_CUSTOMER_DBSERVICE_ENDPOINT, customerId);
	}

	@PutMapping(value = { CustomerServiceRestEndPoints.DELETEALL_CUSTOMERS_ENDPOINT})
	public void deleteAllCustomers() {
		restTemplate.delete(DETETEALL_CUSTOMERD_DBSERVICE_ENDPOINT);
	}

	@GetMapping(value = { CustomerServiceRestEndPoints.FINDBYID_CUSTOMER_ENDPOINT })
	public Customer findCustomer(@PathVariable("customerId") final int customerId) {
		return restTemplate.getForObject(FIND_CUSTOMER_DBSERVICE_ENDPOINT+"/"+customerId, Customer.class);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = { CustomerServiceRestEndPoints.FINDALL_CUSTOMERS_ENDPOINT })
	public List<Customer> findAllCustomer() {
		return (List<Customer>) restTemplate.getForObject(FINDALL_CUSTOMERS_DBSERVICE_ENDPOINT, Customer.class);
	}
}
