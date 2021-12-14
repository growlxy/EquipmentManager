package zqu.eqms.dao;

import java.sql.*;

import zqu.eqms.util.ConnectionUtil;

public class UpdateDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;

	public static int DepUpdate(String id, String name, String manager) {
		int result = 0;

		try {
			String sql = "update department set dname='" + name + "'," + " dmanager='" + manager + "'" + " where dno='"
					+ id + "'";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}

	public static int StaffUpdate(String id, String name, String tel, String dep) {
		int result = 0;

		try {
			String sql = "update staff set sname='" + name + "'," + " stel='" + tel + "'," + " sdepno='" + dep + "'"
					+ " where sno='" + id + "'";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}

	public static int EquipUpdate(String id, String name, String spec, String price, String date, String loc,
			String manager) {
		int result = 0;

		try {
			String sql = "update equipment set ename='" + name + "'," + " espec='" + spec + "'," + " eprice=" + price
					+ "," + " edate=" + date.replaceAll("-", "") + "," + " eloc='" + loc + "'," + " emanager='"
					+ manager + "'" + " where eno='" + id + "'";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}

	public static int managerUpdate(String id) {
		int result = 0;

		try {
			String sql = "update staff set sis_mana=TRUE" + " where sno='" + id + "'";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return result;
	}
}
