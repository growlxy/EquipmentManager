package zqu.eqms.domain;

import java.sql.Blob;
import java.util.Date;

public class EquipmentDomain {
	private String id;
	private String name;
	private String spec;
	private Blob pic;
	private double price;
	private Date date;
	private String loc;
	private String manager;
	
	public EquipmentDomain(String id, String name, String spec, Blob pic, double price, Date date,
			String loc, String manager) {
		super();
		this.id = id;
		this.name = name;
		this.spec = spec;
		this.pic = pic;
		this.price = price;
		this.date = date;
		this.loc = loc;
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

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	
	public Blob getPic() {
		return pic;
	}

	public void setPic(Blob pic) {
		this.pic = pic;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "EquipmentDomain [id=" + id + ", name=" + name + ", spec=" + spec + ", pic=" + pic + ", price=" + price
				+ ", date=" + date + ", loc=" + loc + ", manager=" + manager + "]";
	}
}
