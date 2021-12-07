package zqu.eqms.dao;

import java.sql.*;
import java.util.ArrayList;

import zqu.eqms.domain.StaffDomain;
import zqu.eqms.util.ConnectionUtil;

public class ForgetPwDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet validateQuery(String user) {
		try {
			String sql = "select s.sno, s.sname, s.stel, s.sis_mana from staff s where s.sno=" + user;
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ArrayList<StaffDomain> validate(String user){
		rs = ForgetPwDao.validateQuery(user);
		ArrayList<StaffDomain> al = new ArrayList<StaffDomain>();
		try {
			while(rs.next()) {
				al.add(new StaffDomain(rs.getString("sno"), null, rs.getString("sname"),  rs.getString("stel"), rs.getBoolean("sis_mana"), null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}
