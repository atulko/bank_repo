package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bank.dao.BankInterface;
import com.bank.dbconnection.DBConnection;
import com.bank.pojo.Address;
import com.bank.pojo.Bank;

public class BankImpl implements BankInterface {
	private static final String getAllBank = "Select * from bank";
	private static final String saveBank = "insert into bank(bank_name,ifsc_code,total_no_of_cust,bank_bal,add_id)values(?,?,?,?,?)";
	private static final String updateBank = "update bank set total_no_of_cust=? where id=? and bank_name=?";
	private static final String deleteBank = "delete from bank where id=?";
	private static final String disableBank = "update bank set is_enable=? where id=?";
	private static final String isBankEnable = "select * from bank where id=? and is_enable=?";

	@Override
	public List<Bank> getBankList() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Bank bank = null;
		// String sql = "Select * from bank";
		List<Bank> BankList = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllBank);
			BankList = new ArrayList<Bank>();

			while (rs.next()) {
				bank = new Bank();
				bank.setBankId(rs.getInt("id"));
				bank.setBankName(rs.getString("bank_name"));
				bank.setIfscNumber(rs.getString("ifsc_code"));
				bank.setTotalNumberofCustomer(rs.getInt("total_no_of_cust"));
				bank.setBankBalance(rs.getDouble("bank_bal"));
				bank.setAddId(rs.getInt("addr_id"));
				BankList.add(bank);
			}
			for (Bank b : BankList) {

				System.out.println("Bank details are:" + b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}

				catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return BankList;
	}

	@Override
	public Bank saveBank(Bank bank) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;
		// String sql = "insert into
		// bank(bank_name,ifsc_code,total_no_of_cust,bank_bal,add_id)values(?,?,?,?,?)";

		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(saveBank, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(++pos, bank.getBankName());
			preSts.setString(++pos, bank.getIfscNumber());
			preSts.setInt(++pos, bank.getTotalNumberofCustomer());
			preSts.setDouble(++pos, bank.getBankBalance());
			preSts.setInt(++pos, bank.getAddId());
			result = preSts.executeUpdate();
			if (result > 0) {
				System.out.println(bank.getBankName() + " inserted into DB with " + bank.getBankBalance());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}

				catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return bank;
	}

	@Override
	public List<Bank> saveBankList(List<Bank> bankList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBankExists(Bank bank) {
		boolean result = false;
		List<Bank> existingBankList = null;

		try {
			existingBankList = getBankList();

			for (Bank b : existingBankList) {
				if (bank.getBankId() == bank.getBankId()) {
					result = true;

				}

			}
			System.out.println(bank.getBankName() + " bank is already exist");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Bank updateBank(Bank bank, int id, String bank_name) {
		int pos = 0;
		int result = 0;
		PreparedStatement preSts = null;
		Connection conn = null;
		// String sql = "update bank set total_no_of_cust=? where id=? and bank_name=?";

		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(updateBank, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, bank.getTotalNumberofCustomer());
			preSts.setInt(++pos, id);
			preSts.setString(++pos, bank.getBankName());
			result = preSts.executeUpdate();

			System.out.println(bank.getTotalNumberofCustomer() + " totalCustomer updated DB with id " + id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}

				catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return bank;
	}

	@Override
	public void deleteBank(int id) {
		PreparedStatement preSts = null;
		int pos = 0;
		int result = 0;
		Connection conn = null;
		// String sql = "delete from bank where id=?";

		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(deleteBank, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			result = preSts.executeUpdate();
			if (result > 0)
				System.out.println("Address deleted....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				}

				catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

	}

	@Override
	public boolean disableBank(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		// String sql = "update bank set is_enable=? where id=?";
		int result = 0;
		int pos = 0;

		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(disableBank, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, disable);
			preSts.setInt(++pos, id);
			result = preSts.executeUpdate();

			System.out.println("is_enable is updated in bank DB");

		} catch (Exception e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				}

				catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return false;
	}

	@Override
	public boolean isBankEnable(int id, int isEnable) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement preSts = null;
		ResultSet rs = null;
		int pos = 0;

		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(isBankEnable, preSts.NO_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			preSts.setInt(++pos, isEnable);
			rs = preSts.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println("bank is enable");
			} else {
				System.out.println("Bank is disable");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			System.out.println("DB Connection closed..!!");
		}
		return flag;
	}

	@Override
	public int getBankId(String bank) {
		// TODO Auto-generated method stub
		return 0;
	}

}
