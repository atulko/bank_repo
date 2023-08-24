package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.AddressInterface;
import com.bank.dbconnection.DBConnection;
import com.bank.pojo.Address;

public class AddressImpl implements AddressInterface {

	public static final String getAddressList = "select * from address";
	public static final String saveAddress = "insert into address(flat_number,landmark,city,district,state,country,pin_code,isEnable) values(?,?,?,?,?,?,?,?)";
	public static final String updateAddress = "update address set city=? where id=?";
	public static final String deleteAddress = "delete from address where id=?";
	public static final String disableAddress = "update address set isEnable=? where id=?";

	@Override
	public List<Address> getAddressList() {
		List<Address> addressList = new ArrayList<Address>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Address address = null;
		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAddressList);
			while (rs.next()) {
				address = new Address();
				address.setAddressId(rs.getInt("id"));
				address.setFlatNumber(rs.getInt("flat_number"));
				address.setLandMark(rs.getString("landmark"));
				address.setCity(rs.getString("city"));
				address.setDistrict(rs.getString("district"));
				address.setState(rs.getString("state"));
				address.setCountry(rs.getString("country"));
				address.setPinNumber(rs.getInt("pin_code"));
				addressList.add(address);
			}
			for (Address ad : addressList) {
				System.out.println(ad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return addressList;
	}

	@Override
	public int saveAddress(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Address> saveAddressList(List<Address> addressList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAddressExists(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address updateAddress(Address address, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean disableAddress(int disable, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAddressEnable(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
