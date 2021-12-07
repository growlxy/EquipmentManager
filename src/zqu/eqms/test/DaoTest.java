package zqu.eqms.test;

import zqu.eqms.dao.ForgetPwDao;

public class DaoTest {
	public static void main(String[] args) {
		System.out.println(ForgetPwDao.validate("124") == null);

		System.out.println(ForgetPwDao.validate("123"));
		
	}
}
