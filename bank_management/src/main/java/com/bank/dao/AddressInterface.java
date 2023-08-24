package com.bank.dao;

import java.util.List;
import com.bank.pojo.Address;

public interface AddressInterface {
	public List<Address> getaddressList();

	public int saveAddress(Address address);

	public List<Address> saveAddressList(List<Address> addressList);

	public boolean isAddressExists(Address address);

	public Address updateAddress(Address address, int id);

	public void deleteAddress(int id);

	public boolean disableAddress(int disable, int id);

	public boolean isAddressEnable(int id);

}