package vn.ptit.ultils;

import java.util.Date;

public class DepartmentDisplay {
	private int id;
	private String name;
	private Date dateCreate;
	
	public DepartmentDisplay() {
		// TODO Auto-generated constructor stub
	}
	
	public DepartmentDisplay(int id, String name, Date dateCreate) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreate = dateCreate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	

}
