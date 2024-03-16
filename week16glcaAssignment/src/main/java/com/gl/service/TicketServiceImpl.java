package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bean.Ticket;
import com.gl.dao.TicketDAO;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDAO tdao;

	@Override
	public void addticket(Ticket ticket) {

		tdao.save(ticket);
	}

	@Override
	public List<Ticket> getTickets() {

		return tdao.findAll();
	}

	@Override
	public void deleteTicketById(int id) {
		if (tdao.findById(id).isPresent()) {
			Ticket t = tdao.findById(id).get();
			tdao.delete(t);
		}

	}

	@Override
	public Ticket getTicketById(int id) {
		Ticket t = null;
		if (tdao.findById(id).isPresent()) {
			t = tdao.findById(id).get();
		}

		return t;
	}

	@Override
	public void updateTicket(Ticket ticket) {

		tdao.save(ticket);

	}

	@Override
	public List<Ticket> getTicketsByQuery(String ticketTitle) {

		return tdao.findByTicketTitle(ticketTitle);
	}

}
