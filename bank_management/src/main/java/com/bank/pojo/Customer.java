package com.bank.pojo;

public class Customer {
	private int customerId;
	private int bankId;
	private int addressId;
	private String customerFirstName;
	private String customerLastName;
	private int accountNumber;
	private double customerCurrentBal;
	private Address address;
	private boolean isActive;
	private boolean isAlreadyExist;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCustomerCurrentBal() {
		return customerCurrentBal;
	}

	public void setCustomerCurrentBal(double customerCurrentBal) {
		this.customerCurrentBal = customerCurrentBal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isAlreadyExist() {
		return isAlreadyExist;
	}

	public void setAlreadyExist(boolean isAlreadyExist) {
		this.isAlreadyExist = isAlreadyExist;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", bankId=" + bankId + ", addressId=" + addressId
				+ ", customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", accountNumber=" + accountNumber + ", customerCurrentBal=" + customerCurrentBal + ", address="
				+ address + " isActive=" + isActive + "]";
	}

}
