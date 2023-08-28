package com.bank.main;

import java.util.ArrayList;

import com.bank.daoimpl.AddressImpl;
import com.bank.daoimpl.CustomerImpl;
import com.bank.pojo.Address;
import com.bank.pojo.Customer;

public class BankMain {
	public static void main(String[] args) {

		Address address = new Address();
		address.setFlatNumber(555);
		address.setLandMark("Gandhi ward");
		address.setCity("Nagpur");
		address.setDistrict("Nagpur");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPinNumber(441101);
		address.setIsEnable(1);

		Customer customer = new Customer();
		customer.setCustomerFirstName("Pratik");
		customer.setCustomerLastName("Patil");
		customer.setAccountNumber(303030);
		customer.setCustomerCurrentBal(8888);
		customer.setPhoneNumber(96969696);
		customer.setBankId(4);
		customer.setIs_enable(1);
		customer.setPin(1112);
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(445544);
		list.add(754854);
		list.add(432101);
		customer.setNomineeAccount(list);
		customer.setAddress(address);

		
		
		CustomerImpl impl = new CustomerImpl();
		impl.saveCustomer(customer);
	}

}