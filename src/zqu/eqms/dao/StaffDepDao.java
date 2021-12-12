package zqu.eqms.dao;

import java.sql.*;
import java.util.ArrayList;

import zqu.eqms.domain.StaffDomain;
import zqu.eqms.util.ConnectionUtil;

public class StaffDepDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet staffDepQuery(String item) {
		try {
			String sql = "select *"
					+ " from staff"
					+ " where sdepno like '%"+item+"%'";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return rs;
	}
	
	public static ArrayList<StaffDomain> displayStaff(String item){
		rs = staffDepQuery(item);
		ArrayList<StaffDomain> al = new ArrayList<StaffDomain>();
		try {
			while(rs.next()) {
				al.add(new StaffDomain(rs.getString("sno"), rs.getString("spw"), rs.getString("sname"),
						rs.getString("stel"), rs.getBoolean("sis_mana"), rs.getString("sdepno")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return al;
	}
}
