package com.bank.main;

import com.bank.daoimpl.AddressImpl;
import com.bank.daoimpl.CustomerImpl;
import com.bank.pojo.Customer;

public class BankMain {
	public static void main(String[] args) {

		AddressImpl impl = new AddressImpl();
		// impl.getAddressList();

		Customer cust1 = new Customer();
		cust1.setCustomerId(16);
		cust1.setCustomerFirstName("Rachna");
		cust1.setCustomerLastName("Madankar");
		cust1.setAccountNumber(10111);
		cust1.setCustomerCurrentBal(50000);
		cust1.setPhoneNumber(898979779);
		cust1.setBankId(5);
		cust1.setAddressId(11);
		
		Customer cust2 = new Customer();
		cust2.setCustomerId(1);
		cust2.setCustomerFirstName("Tejaram");
		cust2.setCustomerLastName("Kapse");
		cust2.setAccountNumber(998876);
		cust2.setCustomerCurrentBal(49000);
		cust2.setPhoneNumber(899979724);
		cust2.setBankId(1);
		cust2.setAddrId(11);
		
		Customer cust3 = new Customer();
		cust3.setCustomerId(17);
		cust3.setCustomerFirstName("Teju");
		cust3.setCustomerLastName("Ramteke");
		cust3.setAccountNumber(998876);
		cust3.setCustomerCurrentBal(49000);
		cust3.setPhoneNumber(899979724);
		cust3.setBankId(1);
		cust3.setAddressId(11);

		CustomerImpl custImpl = new CustomerImpl();
		//custImpl.getCustomerList();
		//custImpl.saveCustomer(cust1);
		//custImpl.deleteCustomer(cust1);
		//custImpl.disableCustomer(0, 1);
		//custImpl.getCustomerCurrentBalance(998876);
		//custImpl.isCustomerEnable(4, 0);
		//custImpl.updateCustomer(cust2, 1);
		//custImpl.isCustomerExist(cust2);
		//custImpl.depositeAmount(99000, 1000);
		//custImpl.withdrawAmount(99000, 500);
		
		custImpl.transferAmount(2, 15, 5000);
	}

}