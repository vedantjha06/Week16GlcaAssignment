package com.gl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.bean.Ticket;
import com.gl.service.TicketService;

@Controller
public class HomeController {

	@Autowired
	TicketService tser;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("tickets", tser.getTickets());
		return "home";
	}

	@RequestMapping("/addTicket")
	public String addTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "addTicket";
	}

	@RequestMapping("/processAdd")
	public String processAdd(@ModelAttribute("ticket") Ticket ticket) {

		LocalDate localDate = ticket.getDate();
		ticket.setDate(localDate);
		tser.addticket(ticket);
		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
//		System.out.println(ticket);
		tser.deleteTicketById(id);
		return "redirect:/";
	}

	@RequestMapping("/view")
	public String view(@RequestParam("id") int id, Model model) {

		model.addAttribute("ticket", tser.getTicketById(id));
		return "view";
	}

	@RequestMapping("/processView")
	public String processView(@ModelAttribute("ticket") Ticket ticket) {

		tser.updateTicket(ticket);
		return "redirect:/";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("ticket", tser.getTicketById(id));
		return "edit";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("query") String query, Model model) {
//		System.out.println(ticket);
//		 System.out.println(tser.getTicketsByQuery(query));
		model.addAttribute("tickets", tser.getTicketsByQuery(query));

		return "search";
	}

}
