package com.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.in.entity.Ticket;

@Repository
@EnableJpaRepositories
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	public List<Ticket> getByEventId(int eventId);
	public Optional<Ticket> findByTicketId(int ticketId);
	public Optional<Ticket> findTicketByEventIdAndTicketType(int eventId, String ticketType);
}
