package zqu.eqms.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import zqu.eqms.util.ConnectionUtil;
import zqu.eqms.util.ImageUtil;

public class DaoTest {
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	public static void main(String[] args) {
		System.out.println(Update());
		readDB2Image();
	}
	
	public static int Update() {
		int result = 0;
		String path = "D:/1.jpg";
		FileInputStream in = null;
		try {
			in = ImageUtil.readImage(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			String sql = "update equipment set epic=? where eno='2'";
			ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setBinaryStream(1, in, in.available());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
    public static void readDB2Image() {
        String targetPath = "D:/image/1.png";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from equipment where eno =?";
            ps = ConnectionUtil.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, 2);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("epic");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
