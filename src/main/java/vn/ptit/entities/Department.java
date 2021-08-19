package vn.ptit.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_department")
public class Department extends BaseEntity{
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "dateCreate", nullable = false)
	private Date dateCreate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
	private List<Ticket> tickets = new ArrayList<>();
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		ticket.setDepartment(this);
	}

	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
		ticket.setDepartment(null);
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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
