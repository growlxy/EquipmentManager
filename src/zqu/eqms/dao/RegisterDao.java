package zqu.eqms.dao;

import java.sql.*;
import java.util.ArrayList;

import zqu.eqms.domain.DepartmentDomain;
import zqu.eqms.domain.StaffDomain;
import zqu.eqms.util.ConnectionUtil;

public class RegisterDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;

	public static ResultSet existingQuery(String user) {
		try {
			String sql = "select s.sno from staff s where s.sno=" + user;
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

	public static boolean notExisting(String user) {
		rs = RegisterDao.existingQuery(user);
		ArrayList<StaffDomain> al = new ArrayList<StaffDomain>();
		try {
			while (rs.next()) {
				al.add(new StaffDomain(rs.getString("sno"), null, null, null, true, null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return al.isEmpty();
	}

	public static int registerUpdate(String id, String password, String name, String tel, String depid) {
		int result = 0;
		try {
			String sql = "insert into staff values('" + id + "','" + password + "','" + name + "','" + tel + "',"
					+ "false" + ",'" + depid + "')";
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

	public static ResultSet departmentQuery() {
		try {
			String sql = "select d.dno, d.dname from department d";
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

	public static ArrayList<DepartmentDomain> displayDepartmentName() {
		rs = RegisterDao.departmentQuery();
		ArrayList<DepartmentDomain> al = new ArrayList<DepartmentDomain>();

		int count = 0;
		try {
			rs.last();
			count = rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}

		String[] name = new String[count];
		try {
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				al.add(new DepartmentDomain(rs.getString("dno"), rs.getString("dname"), null));
				name[i] = rs.getString("dname");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return al;
	}
}
