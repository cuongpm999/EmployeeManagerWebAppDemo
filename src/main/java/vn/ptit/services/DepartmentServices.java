package vn.ptit.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;

import vn.ptit.entities.Department;
import vn.ptit.entities.Ticket;

@Service
public class DepartmentServices {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Department> searchByIdDepartment(int id) {

		String jpql = "select p from Department p where p.id = " + id;

		Query query = entityManager.createQuery(jpql, Department.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> searchByName(String input) {
		String jpql = "select p from Department p where ";
		if (!input.isEmpty()) {
			jpql += "lower(p.name) like '%" + input.toLowerCase() + "%'";
			
		}
		
		Query query = entityManager.createQuery(jpql, Department.class);
		return query.getResultList();
	}

}
