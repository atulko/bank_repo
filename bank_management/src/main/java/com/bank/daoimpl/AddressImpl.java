package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
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
		Connection conn = null;
		PreparedStatement preset = null;
		int result = 0;
		int pos = 0;
		int addressId = 0;
		ResultSet rs = null;
		boolean flag = isAddressExists(address);
		if (!flag) {

			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				preset = conn.prepareStatement(saveAddress, preset.RETURN_GENERATED_KEYS);
				preset.setInt(++pos, address.getFlatNumber());
				preset.setString(++pos, address.getLandMark());
				preset.setString(++pos, address.getCity());
				preset.setString(++pos, address.getDistrict());
				preset.setNString(++pos, address.getState());
				preset.setString(++pos, address.getCountry());
				preset.setInt(++pos, address.getPinNumber());
				preset.setInt(++pos, address.getIsEnable());
				preset.executeUpdate();
				rs = preset.getGeneratedKeys();

				if (rs.next()) {
					conn.commit();
					addressId = rs.getInt(1);
					System.out.println(address.getCity() + " inserted into DB with " + addressId);
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
				if (preset != null) {
					try {
						preset.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return addressId;

	}

	@Override
	public List<Address> saveAddressList(List<Address> addressList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAddressExists(Address address) {
		boolean result = false;
		Address existingAddress = null;
		List<Address> addressList = null;

		try {
			addressList = getAddressList();
			Iterator itr = addressList.iterator();
			while (itr.hasNext()) {
				existingAddress = (Address) itr.next();
				if ((existingAddress.getLandMark().equalsIgnoreCase(address.getLandMark()))
						&& (existingAddress.getCity().equalsIgnoreCase(address.getCity()))) {
					result = true;
					// System.out.println("Address already exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
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
