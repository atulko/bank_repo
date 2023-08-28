package com.bank.daoimpl;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bank.dbconnection.DBConnection;

public class NomineeImpl {

	public String getName(int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		int pos = 0;
		String firstName = null;
		String sql = "select firstName from customer where id=?";
		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			rs = preset.executeQuery();
			while (rs.next()) {
				firstName = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstName;
	}

	public void getNominee(int accountNumber) {
		Connection conn = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		int pos = 0;
		List nomineeId = new ArrayList();
		List nomineeName = new ArrayList();
		String sql = "select n.nominee1,n.nominee2,n.nominee3 from nominee n,customer c where c.accountNumber=? and c.nomineeId=n.id;";
		try {
			conn = DBConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, accountNumber);
			rs = preset.executeQuery();
			while (rs.next()) {
				for (int i = 1; i <= 3; i++) {
					nomineeId.add(rs.getInt(i));
				}
			}
			
			for (int i=0;i<nomineeId.size();i++) {
				int j=(int) nomineeId.get(i);
				nomineeName.add(getName(j));
			}
			System.out.println(nomineeName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addNominee(ArrayList<Integer> accountNumber) {
		Connection conn = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		int result = 0;
		int pos = 0;
		int id = 0;
		ArrayList<Integer> nominee = new ArrayList<>();
		String getId = "select id from customer where accountNumber=?";
		String addNominee = "insert into nominee (nominee1, nominee2, nominee3) values (?,?,?)";
		try {
			conn = DBConnection.getConnection();
			for (int i = 0; i < accountNumber.size(); i++) {
				id = 0;
				pos = 0;
				preset = conn.prepareStatement(getId, preset.RETURN_GENERATED_KEYS);
				// System.out.println(++pos+" "+accountNumber.get(i));
				preset.setInt(++pos, accountNumber.get(i));
				rs = preset.executeQuery();
				while (rs.next()) {
					id = rs.getInt(1);
					nominee.add(id);
				}
			}
			preset = null;
			int i = 0;
			pos = 0;
			id = 0;
			rs = null;
			preset = conn.prepareStatement(addNominee, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, nominee.get(i++));
			preset.setInt(++pos, nominee.get(i++));
			preset.setInt(++pos, nominee.get(i++));
			preset.executeUpdate();
			rs = preset.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
