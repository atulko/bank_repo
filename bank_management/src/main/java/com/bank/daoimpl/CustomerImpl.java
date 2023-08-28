package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.CustomerInterface;
import com.bank.dbconnection.DBConnection;
import com.bank.pojo.Customer;

public class CustomerImpl implements CustomerInterface {
	private static final String getAllCustomer = "select * from customer";
	public static final String saveCustomer = "insert into customer(firstName,lastName,accountNumber,currentBalance,mobileNumber,bank_id,addr_id,isEnable,pin,nomineeId) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String getUpdateCustomer = "Update  customer set first_name=? where id=? ";
	public static final String getDeleteCustomer = "delete from customer where id=?";
	public static final String getDisableCustomer = "update customer set is_enable =? where id =?";
	public static final String getIsEnableCustomer = "select * from customer where id=?  and is_enable=?";
	public static final String getCustomerCurrentBalance = "select * from customer where account_number=?";

	// @Override
		public static List<Customer> getCustomerList() {

			List<Customer> customerList = new ArrayList<Customer>();

			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;

			try {
				conn = DBConnection.getConnection();
				st = conn.createStatement();
				rs = st.executeQuery(getAllCustomer);
				Customer customer = null;
				while (rs.next()) {
					customer = new Customer();

					customer.setCustomerId(rs.getInt("id"));
					customer.setCustomerFirstName(rs.getString("first_name"));
					customer.setCustomerLastName(rs.getString("last_name"));
					customer.setAccountNumber(rs.getInt("account_number"));
					customer.setPhoneNumber(rs.getLong("mobile_number"));
					customer.setCustomerCurrentBal(rs.getInt("current_balance"));
					customerList.add(customer);

				}
				for (Customer cust : customerList) {
					// if (cust.getCustomerId() == 5)
					System.out.println(cust);

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
				if (st != null) {
					try {
						st.close();

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}

			return customerList;
		}

		@Override
		public List<Customer> saveCustomerList(List<Customer> customerList) {

			return null;
		}

		@Override
		public Customer saveCustomer(Customer customer) {
			Connection conn = null;
			PreparedStatement preSts = null;
			int result = 0;
			int pos = 0;
			int addressId = 0;
			int nomineeId=0;
			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				preSts = conn.prepareStatement(saveCustomer, preSts.RETURN_GENERATED_KEYS);

				preSts.setString(++pos, customer.getCustomerFirstName());
				preSts.setString(++pos, customer.getCustomerLastName());
				preSts.setInt(++pos, customer.getAccountNumber());
				preSts.setDouble(++pos, customer.getCustomerCurrentBal());
				preSts.setLong(++pos, customer.getPhoneNumber());
				preSts.setInt(++pos, customer.getBankId());

				AddressImpl impl = new AddressImpl();
				addressId = impl.saveAddress(customer.getAddress());
				preSts.setInt(++pos, addressId);
				//preSts.setInt(++pos, addressId);
				preSts.setInt(++pos, customer.getIs_enable());
				preSts.setInt(++pos, customer.getPin());
				NomineeImpl n=new NomineeImpl();
				nomineeId=n.addNominee(customer.getNomineeAccount());
				preSts.setInt(++pos, nomineeId);
				result = preSts.executeUpdate();
				if (result > 0) {
					conn.commit();
					System.out.println(customer.getCustomerFirstName() + " inserted into  DB with "
							+ customer.getCustomerId() + " and having address id " + addressId);
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

			}

			return customer;
		}

		@Override
		public boolean isCustomerExist(Customer customer) {
			boolean result = false;

			List<Customer> customerList = null;

			try {
				customerList = getCustomerList();

				for (Customer cust : customerList) {

					if (cust.getCustomerId() == customer.getCustomerId()
							&& cust.getCustomerFirstName().equalsIgnoreCase(customer.getCustomerFirstName())) {

						result = true;

						
						System.out.println("Customer with customer Id " + customer.getCustomerId() + " is already Exist ");
					}

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			return result;
		}

		@Override
		public Customer updateCustomer(Customer customer, int id) {
			Connection conn = null;
			PreparedStatement preSts = null;
			int result = 0;
			// int pos=0;
			try {
				conn = DBConnection.getConnection();
				preSts = conn.prepareStatement(getUpdateCustomer, preSts.RETURN_GENERATED_KEYS);
				preSts.setString(1, customer.getCustomerFirstName());
				preSts.setInt(2, id);
				result = preSts.executeUpdate();
				System.out.println(customer.getCustomerFirstName() + " Table is updated in " + id);

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

			}

			return customer;
		}

		@Override
		public boolean disableCustomer(int disable, int id) {
			Connection conn = null;
			PreparedStatement preSts = null;
			int result = 0;
			int pos = 0;
			try {
				conn = DBConnection.getConnection();
				preSts = conn.prepareStatement(getDisableCustomer, preSts.RETURN_GENERATED_KEYS);
				preSts.setInt(++pos, disable);
				preSts.setInt(++pos, id);
				result = preSts.executeUpdate();
				System.out.println("Table is updated in " + id);
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

			}

			return false;
		}

		@Override
		public void deleteCustomer(Customer customer) {
			Connection conn = null;
			PreparedStatement preSts = null;
			int result = 0;
			
			int pos = 0;
			try {

				conn = DBConnection.getConnection();
				preSts = conn.prepareStatement(getDeleteCustomer, preSts.RETURN_GENERATED_KEYS);
				preSts.setInt(++pos, customer.getCustomerId());
				result = preSts.executeUpdate();
				System.out.println(customer.getCustomerId() + " deleted with DB ");
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

			}

		}

		@Override
		public boolean isCustomerEnable(int id, int isEnable) {
			boolean flag = false;
			Connection con = null;
			PreparedStatement preSts = null;
			int result = 0;
			int pos = 0;
			ResultSet rs = null;
			try {

				con = DBConnection.getConnection();
				preSts = con.prepareStatement(getIsEnableCustomer, preSts.RETURN_GENERATED_KEYS);
				preSts.setInt(++pos, id);
				preSts.setInt(++pos, isEnable);

				rs = preSts.executeQuery();

				if (rs.next()) {
					flag = true;
					System.out.println(" Customer is Active " + id);
				} else {
					System.out.println("Customer  is not Active " + id);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
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
			}
			return flag;

		}

		@Override
		public double getCustomerCurrentBalance(int accountNumber) {
			Connection conn = null;
			PreparedStatement preSts = null;
			int result = 0;
			ResultSet rs = null;
			double balance = 0.0;
			Statement st = null;
			int pos = 0;
			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				//conn = null;
				preSts = conn.prepareStatement(getCustomerCurrentBalance, preSts.RETURN_GENERATED_KEYS);
				preSts.setInt(++pos, accountNumber);
				rs = preSts.executeQuery();

				if (rs.next()) {
					conn.commit();
					balance = rs.getInt(5);

					System.out.println("Hi " + rs.getString(2) + " " + rs.getString(3) + " your Current Balance is=" + balance);
					//System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);

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

				System.out.println("All connection closed");
			}

			return balance;
		}

		@Override
		public void depositeAmount(int accountNumber, int amount) {
			Connection conn = null;
			PreparedStatement preSts = null;
			ResultSet rs = null;
			int result = 0;
			double customerCurrentBalance = 0.0;
			Statement st = null;
			String sq = "select * from customer where account_number=?";
			String sql = "update customer set current_balance = ? where account_number =?";
			// int pos=0;
			PreparedStatement pre = null;

			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				preSts = conn.prepareStatement(sq, preSts.RETURN_GENERATED_KEYS);
				preSts.setInt(1, accountNumber);
				rs = preSts.executeQuery();
				if (rs.next())
					conn.commit();
				customerCurrentBalance = rs.getInt(5);

				// Update
				pre = conn.prepareStatement(sql, preSts.RETURN_GENERATED_KEYS);
				pre.setDouble(1, (customerCurrentBalance + amount));
				pre.setInt(2, accountNumber);
				result = pre.executeUpdate();
				if (result > 0) {
					conn.commit();
					System.out.println(" Hi " + rs.getString(2) + " " + rs.getString(3)
							+ " your Current Balance after deposite is=" + (customerCurrentBalance + amount));
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
				if (pre != null) {
					try {
						pre.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}

		}

		@Override
		public void withdrawAmount(int accountNumber, double amount) {
			Connection conn = null;
			PreparedStatement preSts = null;
			ResultSet rs = null;
			int result = 0;
			double customerCurrentBalance = 0.0;
			Statement st = null;
			String sq = "select * from customer where account_number=?";
			String sql = "update customer set current_balance = ? where account_number =?";
			int pos = 0;
			PreparedStatement pre = null;
			double bal = 0.0;

			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);
				preSts = conn.prepareStatement(sq, preSts.RETURN_GENERATED_KEYS);
				preSts.setInt(1, accountNumber);
				rs = preSts.executeQuery();
				if (rs.next())
					conn.commit();
				customerCurrentBalance = rs.getInt(5);
				//CustomerImpl impl=new CustomerImpl();
				//impl.getCustomerCurrentBalance(72);

				// Update
				pre = conn.prepareStatement(sql, preSts.RETURN_GENERATED_KEYS);
				pre.setDouble(1, customerCurrentBalance - amount);
				pre.setInt(2, accountNumber);
				result = pre.executeUpdate();
				bal = customerCurrentBalance - amount;
				if (result > 0) {
					conn.commit();
					System.out.println(" Hi " + rs.getString(2) + " " + rs.getString(3)
							+ "your Current Balance after Withdraw is=" + bal);
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

					if (pre != null) {
						try {
							pre.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			}
		}

		@Override
		public void transferAmount(int debterAccountNumber, int crediterAccountNumber, double amount) {
			Connection conn = null;
			PreparedStatement preset = null;
			int pos = 0;
			int result = 0;
			ResultSet rs = null;
			double balance = 0.0;
			String check = "select current_balance from customer where  account_number=?";
			String withdraw = "update customer set current_balance=current_balance-? where  account_number=?";
			String deposit = "update customer set current_balance=current_balance+? where  account_number=?";
			try {
				conn = DBConnection.getConnection();
				preset = conn.prepareStatement(check, preset.RETURN_GENERATED_KEYS);
				conn.setAutoCommit(false);
				preset.setInt(++pos, debterAccountNumber);
				rs = preset.executeQuery();
				while (rs.next()) {
					balance = rs.getDouble(1);
				}
				if (balance > amount) {
					Customer custimpl = new Customer();
					isCustomerEnable(15, 1);

					conn.commit();
					pos = 0;
					preset = conn.prepareStatement(withdraw, preset.RETURN_GENERATED_KEYS);
					preset.setDouble(++pos, amount);
					preset.setInt(++pos, debterAccountNumber);

					result = preset.executeUpdate();
					if (result > 0) {

						conn.commit();
						System.out.println("Amount transferred successfully...");
					}
				} else {
					System.out.println("Insufficient amount to transfer");
				}

				pos = 0;
				preset = conn.prepareStatement(deposit, preset.RETURN_GENERATED_KEYS);
				preset.setDouble(++pos, amount);
				preset.setInt(++pos, crediterAccountNumber);
				result = preset.executeUpdate();
				if (result > 0) {

					conn.commit();
					System.out.println("Amount received.....");
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

		
		
	}
