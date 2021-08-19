package vn.ptit.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;

import vn.ptit.entities.Ticket;

@Service
public class TicketServices {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Ticket> searchAllTicket() {

		String jpql = "select p from Ticket p";

		Query query = entityManager.createQuery(jpql, Ticket.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> searchByIdDepartment(int id) {

		String jpql = "select p from Ticket p where p.department.id = " + id;

		Query query = entityManager.createQuery(jpql, Ticket.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> searchByType(String inputTypeSearch, Date from, Date to) {
		String jpql = "select p from Ticket p where ";
		if (!inputTypeSearch.isEmpty()) {
			jpql += "lower(p.mobileClient) like '%" + inputTypeSearch.toLowerCase() + "%' or lower(p.department.name) like '%" + inputTypeSearch.toLowerCase()
					+ "%'";
			Query query = entityManager.createQuery(jpql, Ticket.class);
			return query.getResultList();
		} else if (from != null && to != null) {
			jpql += "p.timeAccept >= :from and p.timeAccept <= :to";
			Query query = entityManager.createQuery(jpql, Ticket.class);
			query.setParameter("from",from,TemporalType.DATE);
			query.setParameter("to",to,TemporalType.DATE);
			return query.getResultList();
		}
		
		return null;
	}
}
