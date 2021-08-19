package vn.ptit.ultils;

import java.util.List;

public class ListTicketAndSizeDisplay {
	private int size;
	private List<TicketDisplay> list;
	
	public ListTicketAndSizeDisplay() {
		
	}

	public ListTicketAndSizeDisplay(int size, List<TicketDisplay> list) {
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

	public List<TicketDisplay> getList() {
		return list;
	}

	public void setList(List<TicketDisplay> list) {
		this.list = list;
	}

}
