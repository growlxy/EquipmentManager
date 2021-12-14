package zqu.eqms.dao;

import java.sql.*;

import zqu.eqms.util.ConnectionUtil;

public class CreateDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static int createDep(String id, String name, String manager) {
		int result = 0;
		try {
			String sql = "insert into department values('"
					+ id + "','"
					+ name + "','"
					+ manager + "')";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}
	
	public static int createStaff(String id, String password, String name, String tel, String isMana, String depid) {
		if(isMana=="是") isMana="true";
		if(isMana=="否") isMana="false";
		int result = 0;
		try {
			String sql = "insert into staff values('"
					+ id + "','"
					+ password + "','"
					+ name + "','"
					+ tel + "',"
					+ isMana + ",'"
					+ depid + "')";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}
	
	public static String equipIdRetrieve() {
		String id = null;
		
		try {
			String sql = "select *"
					+ " from equipment";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.last();
			id = rs.getString("eno");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return id;
	}

	public static int createEquip(String name, String spec, String price, String date, String loc, String manager) {
		String id = String.format("%05d", Integer.parseInt(equipIdRetrieve())+1);
		int result = 0;
		try {
			String sql = "insert into equipment values('"
					+ id + "','"
					+ name + "','"
					+ spec + "','"
					+ "" + "',"
					+ price + ","
					+ date + ",'"
					+ loc + "','"
					+ manager + "')";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}
}
