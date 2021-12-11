package zqu.eqms.dao;

import java.sql.*;

import zqu.eqms.domain.StaffDomain;
import zqu.eqms.util.ConnectionUtil;

public class LoginDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet validateQuery(String user) {
		try {
			String sql = "select s.sno, s.spw, s.sis_mana from staff s where s.sno=" + user;
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return rs;
	}
	
	public static StaffDomain validate(String user){
		rs = LoginDao.validateQuery(user);
		StaffDomain sd = null;
		try {
			while(rs.next()) {
				sd = new StaffDomain(rs.getString("sno"), rs.getString("spw"), null, null, rs.getBoolean("sis_mana"), null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return sd;
	}
}
