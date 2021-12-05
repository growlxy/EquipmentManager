package zqu.eqms.test;

import zqu.eqms.dao.LoginDao;

public class DaoTest {
	public static void main(String[] args) {
		System.out.println(LoginDao.validate("99999999").get(0));
	}
}
