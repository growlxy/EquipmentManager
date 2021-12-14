package zqu.eqms.domain;

public class DepartmentDomain {
	private String id;
	private String name;
	private String manager;

	public DepartmentDomain(String id, String name, String manager) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "DepartmentDomain [id=" + id + ", name=" + name + ", manager=" + manager + "]";
	}
}
