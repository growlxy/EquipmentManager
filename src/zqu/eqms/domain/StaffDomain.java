package zqu.eqms.domain;

public class StaffDomain {
	private final String id;
	private String password;
	private String name;
	private String tel;
	private boolean ismanager;
	private String depid;

	public StaffDomain(String id, String password, String name, String tel, boolean ismanager, String depid) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.ismanager = ismanager;
		this.depid = depid;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean isIsmanager() {
		return ismanager;
	}

	public void setIsmanager(boolean ismanager) {
		this.ismanager = ismanager;
	}

	public String getDepid() {
		return depid;
	}

	public void setDepid(String depid) {
		this.depid = depid;
	}

	@Override
	public String toString() {
		return "StaffDomain [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", ismanager="
				+ ismanager + ", depid=" + depid + "]";
	}
}
