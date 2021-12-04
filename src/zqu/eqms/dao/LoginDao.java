package zqu.eqms.dao;

import java.sql.*;

import zqu.eqms.util.ConnectionUtil;

public class LoginDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet validateQuery(String user) {
		try {
			String sql = "select s.sno, s.spw from staff s where s.sno=" + user;
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
