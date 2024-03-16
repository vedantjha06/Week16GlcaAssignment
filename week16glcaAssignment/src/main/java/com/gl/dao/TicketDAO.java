package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.bean.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByTicketTitle(String ticketTitle);
}
