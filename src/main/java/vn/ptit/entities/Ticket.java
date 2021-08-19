package vn.ptit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ticket")
public class Ticket extends BaseEntity{
	@Column(name = "timeAccept", nullable = false)
	private Date timeAccept;
	
	@Column(name = "nameClient", length = 100, nullable = false)
	private String nameClient;
	
	@Column(name = "mobileClient", length = 100, nullable = false)
	private String mobileClient;
	
	@Column(name = "contentOfClient", length = 1000, nullable = false)
	private String contentOfClient;
	
	@Column(name = "contentReply", length = 1000, nullable = true)
	private String contentReply;
	
	@Column(name = "status", nullable = true)
	private Boolean status;
	
	@Column(name = "timeReply", nullable = true)
	private Date timeReply;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idDepartment")
	private Department department;

	public Date getTimeAccept() {
		return timeAccept;
	}

	public void setTimeAccept(Date timeAccept) {
		this.timeAccept = timeAccept;
	}

	public String getContentOfClient() {
		return contentOfClient;
	}

	public void setContentOfClient(String contentOfClient) {
		this.contentOfClient = contentOfClient;
	}

	public String getContentReply() {
		return contentReply;
	}

	public void setContentReply(String contentReply) {
		this.contentReply = contentReply;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getTimeReply() {
		return timeReply;
	}

	public void setTimeReply(Date timeReply) {
		this.timeReply = timeReply;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getMobileClient() {
		return mobileClient;
	}

	public void setMobileClient(String mobileClient) {
		this.mobileClient = mobileClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	
}
