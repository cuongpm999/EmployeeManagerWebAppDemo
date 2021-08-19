package vn.ptit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> { }
