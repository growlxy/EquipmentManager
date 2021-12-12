package zqu.eqms.dao;

import java.sql.*;
import java.util.ArrayList;

import zqu.eqms.domain.DepartmentDomain;
import zqu.eqms.util.ConnectionUtil;

public class AllDepartmentDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet allDepartmentQuery() {
		try {
			String sql = "select *"
					+ " from department";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return rs;
	}
	
	public static ArrayList<DepartmentDomain> displayAllDepartment(){
		rs = allDepartmentQuery();
		ArrayList<DepartmentDomain> al = new ArrayList<DepartmentDomain>();
		try {
			while(rs.next()) {
				al.add(new DepartmentDomain(rs.getString("dno"), rs.getString("dname"), rs.getString("dmanager")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return al;
	}
}
