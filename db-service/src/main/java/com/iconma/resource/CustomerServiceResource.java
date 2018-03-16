package com.iconma.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iconma.constants.CustomerServiceRestEndPoints;
import com.iconma.entity.Customer;
import com.iconma.repository.CustomerRepository;

@RestController
@RequestMapping(value = {CustomerServiceRestEndPoints.ROOT_CUSTOMER_ENDPOINT })
public class CustomerServiceResource {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(value = { CustomerServiceRestEndPoints.SAVE_CUSTOMER_ENDPOINT })
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	/*@PutMapping(value = {CustomerServiceRestEndPoints.UPDATE_CUSTOMER_ENDPOINT})
	public Customer updateCustomer(@RequestBody Customer customer) {
		Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());
		Customer customer1 = optional.get();
		customer1.setCustomerName(customer.getCustomerName());
		customer1.setCustPhoneNo(customer.getCustPhoneNo());
		customer1.setCustomerAddress(customer.getCustomerAddress());
		return customerRepository.save(customer1);
	}*/

	/*@PutMapping(value = { CustomerServiceRestEndPoints.DELETE_CUSTOMER_ENDPOINT })
	public void deleteCustomer(@PathVariable("customerId") final int customerId) {
		customerRepository.deleteById(customerId);
	}*/

	@PutMapping(value = { CustomerServiceRestEndPoints.DELETEALL_CUSTOMERS_ENDPOINT})
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

	/*@GetMapping(value = { CustomerServiceRestEndPoints.FINDBYID_CUSTOMER_ENDPOINT })
	public Customer findCustomer(@PathVariable("customerId") final int customerId) {
		return customerRepository.findById(customerId).get();
	}*/

	@GetMapping(value = { CustomerServiceRestEndPoints.FINDALL_CUSTOMERS_ENDPOINT })
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}
}
