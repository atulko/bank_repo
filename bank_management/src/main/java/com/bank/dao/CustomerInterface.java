package com.bank.dao;

import java.util.List;
import com.bank.pojo.Customer;

public interface CustomerInterface {
	public List<Customer> getcustomerList();

	public Customer saveCustomer(Customer customer, String bank);

	public List<Customer> saveCustomerList(List<Customer> customerList);

	public boolean isCustomerExists(Customer customer);

	public Customer updateCustomer(Customer customer, int id);

	public void deletecustomer(int id);

	public boolean disableCustomer(int disable, int id);

	public double getCustomerCurrentBalance(int accountNumber);

	public void depositAmount(int id, double amount);

	public void withdrawAmount(int id, double amount);

	public void transferAmount(int debterID, int crediterId, double amount);
}
