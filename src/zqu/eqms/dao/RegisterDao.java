package zqu.eqms.dao;

import java.sql.*;
import java.util.ArrayList;

import zqu.eqms.domain.StaffDomain;
import zqu.eqms.util.ConnectionUtil;

public class RegisterDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet existingQuery(String user) {
		try {
			String sql = "select s.sno from staff s where s.sno=" + user;
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static boolean notExisting(String user){
		rs = RegisterDao.existingQuery(user);
		ArrayList<StaffDomain> al = new ArrayList<StaffDomain>();
		try {
			while(rs.next()) {
				al.add(new StaffDomain(rs.getString("sno"), null, null, null, true, null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al.isEmpty();
	}
	
	public static int registerUpdate(String id, String password, String name, String tel, String depid) {
		int result = 0;
		try {
			String sql = "insert into staff values('"
					+ id + "','"
					+ password + "','"
					+ name + "','"
					+ tel + "',"
					+ "false" + ",'"
					+ depid + "')";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
