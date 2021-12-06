package zqu.eqms.test;

import zqu.eqms.dao.RegisterDao;
import zqu.eqms.domain.DepartmentDomain;

public class DaoTest {
	public static void main(String[] args) {
		for(DepartmentDomain d:RegisterDao.displayDepartmentName())
		System.out.println(d);
		System.out.println(RegisterDao.displayDepartmentName().size());
		
	}
}
