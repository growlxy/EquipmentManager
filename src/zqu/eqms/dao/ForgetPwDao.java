package zqu.eqms.dao;

import java.sql.*;

import zqu.eqms.domain.StaffDomain;
import zqu.eqms.util.ConnectionUtil;

public class ForgetPwDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;

	public static ResultSet validateQuery(String user) {
		try {
			String sql = "select s.sno, s.sname, s.stel, s.sis_mana from staff s where s.sno=" + user;
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return rs;
	}

	public static StaffDomain validate(String user) {
		rs = ForgetPwDao.validateQuery(user);
		StaffDomain sd = null;
		try {
			while (rs.next()) {
				sd = new StaffDomain(rs.getString("sno"), null, rs.getString("sname"), rs.getString("stel"),
						rs.getBoolean("sis_mana"), null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return sd;
	}

	public static ResultSet passwordQuery(String user) {
		try {
			String sql = "select s.sno, s.spw from staff s where s.sno=" + user;
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return rs;
	}

	public static boolean samePassword(String user, String pw) {
		rs = ForgetPwDao.passwordQuery(user);
		StaffDomain sd = null;
		try {
			while (rs.next()) {
				sd = new StaffDomain(rs.getString("sno"), rs.getString("spw"), null, null, false, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return pw.equals(sd.getPassword());
	}

	public static int passwordUpdate(String user, String password) {
		int result = 0;
		try {
			String sql = "update staff set" + " spw='" + password + "'" + " where sno='" + user + "'";
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
