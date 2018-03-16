package com.iconma.model;

public class Customer {

	private int customerId;
	private String customerName;
	private long custPhoneNo;
	private String customerAddress;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustPhoneNo() {
		return custPhoneNo;
	}

	public void setCustPhoneNo(long custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

}
