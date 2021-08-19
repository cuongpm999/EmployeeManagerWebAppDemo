package vn.ptit.ultils;

import java.util.List;

public class ListDepartmentAndSize {
	private int size;
	private List<DepartmentDisplay> list;
	
	public ListDepartmentAndSize() {
		// TODO Auto-generated constructor stub
	}

	public ListDepartmentAndSize(int size, List<DepartmentDisplay> list) {
		super();
		this.size = size;
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<DepartmentDisplay> getList() {
		return list;
	}

	public void setList(List<DepartmentDisplay> list) {
		this.list = list;
	}
	
	
}
