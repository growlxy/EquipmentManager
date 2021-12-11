package zqu.eqms.dao;

import java.sql.*;
import java.util.ArrayList;

import zqu.eqms.domain.EquipmentDomain;
import zqu.eqms.util.ConnectionUtil;

public class AllEquipmentDao {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static ResultSet allEquipmentQuery() {
		try {
			String sql = "select e.eno, e.ename, e.espec, e.epic, e.eprice, e.edate, e.eloc, e.emanager"
					+ " from equipment e";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return rs;
	}
	
	public static ArrayList<EquipmentDomain> displayAllEquipment(){
		rs = allEquipmentQuery();
		ArrayList<EquipmentDomain> al = new ArrayList<EquipmentDomain>();
		try {
			while(rs.next()) {
				al.add(new EquipmentDomain(rs.getString("eno"), rs.getString("ename"), rs.getString("espec"),
						rs.getBlob("epic"), rs.getDouble("eprice"), rs.getDate("edate"), rs.getString("eloc"), rs.getString("emanager")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close();
		}
		return al;
	}
}
