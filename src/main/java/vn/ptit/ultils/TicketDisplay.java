package vn.ptit.ultils;

import java.util.Date;

public class TicketDisplay {
	private int id;
	private String nameDepartment;
	private String clientMobile;
	private String contentOfClient;
	private Date timeAccept;
	private String contentReply;
	private boolean status;
	private Date timeReply;
	
	public TicketDisplay() {
		
	}

	public TicketDisplay(int id, String nameDepartment, String clientMobile, String contentOfClient, Date timeAccept,
			String contentReply, boolean status, Date timeReply) {
		super();
		this.id = id;
		this.nameDepartment = nameDepartment;
		this.clientMobile = clientMobile;
		this.contentOfClient = contentOfClient;
		this.timeAccept = timeAccept;
		this.contentReply = contentReply;
		this.status = status;
		this.timeReply = timeReply;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	public String getClientMobile() {
		return clientMobile;
	}

	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
	}

	public String getContentOfClient() {
		return contentOfClient;
	}

	public void setContentOfClient(String contentOfClient) {
		this.contentOfClient = contentOfClient;
	}

	public Date getTimeAccept() {
		return timeAccept;
	}

	public void setTimeAccept(Date timeAccept) {
		this.timeAccept = timeAccept;
	}

	public String getContentReply() {
		return contentReply;
	}

	public void setContentReply(String contentReply) {
		this.contentReply = contentReply;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getTimeReply() {
		return timeReply;
	}

	public void setTimeReply(Date timeReply) {
		this.timeReply = timeReply;
	}

}
