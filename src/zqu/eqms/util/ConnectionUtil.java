package zqu.eqms.util;

import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	private static Properties properties = new Properties();
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
			
	protected static Connection conn = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
	
	static {
		try {			
			properties.load(PropertiesUtil.class.getResourceAsStream("/database.properties"));
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> td = new ThreadLocal<Connection>();
	public static Connection getConnection() {
		Connection conn = td.get();
		try {
			if (conn == null) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);
				td.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
