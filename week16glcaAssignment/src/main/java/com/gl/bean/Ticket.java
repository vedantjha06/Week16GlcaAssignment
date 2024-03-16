package com.gl.bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@ToString
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String ticketTitle;
	String shortDescription;
	String content;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	LocalDate date;

	public Date getFormattedDate() {
		// Convert LocalDate to Date
		return java.sql.Date.valueOf(date);
	}

//	public String getDateString() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        return sdf.format(date);
//    }

}
