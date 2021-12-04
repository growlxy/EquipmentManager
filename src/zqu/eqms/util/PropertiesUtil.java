package zqu.eqms.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();

		props.setProperty("jdbc.driver", "com.mysql.cj.jdbc.Driver");
		props.setProperty("jdbc.url", "jdbc:mysql://localhost:3306/EQDB");
		props.setProperty("jdbc.username", "root");
		props.setProperty("jdbc.password", "");

		FileOutputStream fos = new FileOutputStream("database.properties");
		props.store(fos, "");
		fos.close();
		System.out.println("已创建database.properties");
	}
}
