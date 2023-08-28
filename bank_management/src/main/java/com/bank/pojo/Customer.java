package com.bank.pojo;

import java.util.ArrayList;

public class Customer {
	private int customerId;

	private int addressId;
	private String customerFirstName;
	private String customerLastName;
	private int accountNumber;
	private long phoneNumber;
	private String mailId;
	private double customerCurrentBal;
	private double depositeAmount;
	private double withDrawAmount;
	private Address address;// has-a-relation
	private String getCurrentBalance;
	private int bankId;
	private int addrId;
	private int is_enable;
	private int pin;
	private ArrayList<Integer> nomineeAccount;

	public Customer() {
		super();
	}

	public Customer(int customerId, int bankId, int addressId, String customerFirstName, String customerLastName,
			int accountNumber, long phoneNumber, String mailId, double customerCurrentBal, double depositeAmount,
			double withDrawAmount, Address address, String getCurrentBalance) {
		super();
		this.customerId = customerId;
		this.bankId = bankId;
		this.addressId = addressId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.mailId = mailId;
		this.customerCurrentBal = customerCurrentBal;
		this.depositeAmount = depositeAmount;
		this.withDrawAmount = withDrawAmount;
		this.address = address;
		this.getCurrentBalance = getCurrentBalance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public double getDepositeAmount() {
		return depositeAmount;
	}

	public void setDepositeAmount(double depositeAmount) {
		this.depositeAmount = depositeAmount;
	}

	public double getWithDrawAmount() {
		return withDrawAmount;
	}

	public void setWithDrawAmount(double withDrawAmount) {
		this.withDrawAmount = withDrawAmount;
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

	public String getGetCurrentBalance() {
		return getCurrentBalance;
	}

	public void setGetCurrentBalance(String getCurrentBalance) {
		this.getCurrentBalance = getCurrentBalance;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	

	public int getIs_enable() {
		return is_enable;
	}

	public void setIs_enable(int is_enable) {
		this.is_enable = is_enable;
	}
	
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public ArrayList<Integer> getNomineeAccount() {
		return nomineeAccount;
	}

	public void setNomineeAccount(ArrayList<Integer> nomineeAccount) {
		this.nomineeAccount = nomineeAccount;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", addressId=" + addressId + ", customerFirstName="
				+ customerFirstName + ", customerLastName=" + customerLastName + ", accountNumber=" + accountNumber
				+ ", phoneNumber=" + phoneNumber + ", mailId=" + mailId + ", customerCurrentBal=" + customerCurrentBal
				+ ", depositeAmount=" + depositeAmount + ", withDrawAmount=" + withDrawAmount + ", address=" + address
				+ ", getCurrentBalance=" + getCurrentBalance + ", bankId=" + bankId + ", addrId=" + addrId
				+ ", is_enable=" + is_enable + "]";
	}


	

}
