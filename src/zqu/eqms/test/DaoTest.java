package zqu.eqms.test;

import zqu.eqms.dao.RegisterDao;

public class DaoTest {
	public static void main(String[] args) {
		try {
			if(RegisterDao.registerUpdate("111111", "1", "1", "1", "10001")!=0) {
				System.out.println("1");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
