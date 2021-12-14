package zqu.eqms.dao;

import java.sql.*;

import zqu.eqms.util.ConnectionUtil;

public class DeleteDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;

	public static int DepDel(String id) {
		int result = 0;
		try {
			String sql = "delete from department where dno='" + id + "'";
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

	public static int StaffDel(String id) {
		int result = 0;
		try {
			String sql = "delete from staff where sno='" + id + "'";
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

	public static int EquipDel(String id) {
		int result = 0;
		try {
			String sql = "delete from equipment where eno='" + id + "'";
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
