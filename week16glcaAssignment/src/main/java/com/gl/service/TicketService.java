package com.gl.service;

import java.util.List;

import com.gl.bean.Ticket;

public interface TicketService {

	public void addticket(Ticket ticket);

	public List<Ticket> getTickets();

	public void deleteTicketById(int id);

	public Ticket getTicketById(int id);

	public void updateTicket(Ticket ticket);

	public List<Ticket> getTicketsByQuery(String ticketTitle);
}
