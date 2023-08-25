package com.bank.dao;

import java.util.List;
import com.bank.pojo.Customer;

public interface CustomerInterface {

	public Customer saveCustomer(Customer customer);

	// public static List<Customer> getCustomerList();

	public List<Customer> saveCustomerList(List<Customer> customerList);

	public boolean isCustomerExist(Customer customer);

	public Customer updateCustomer(Customer customer, int id);

	public void deleteCustomer(Customer customer);

	public boolean disableCustomer(int disable, int id);

	public boolean isCustomerEnable(int id, int isEnable);

	public double getCustomerCurrentBalance(int accountNumber);

	public void transferAmount(int debterID, int crediterId, double amount);

	public void depositeAmount(int accountNumber, int amount);

	public void withdrawAmount(int accountNumber, double amount);

}
