package com.lnt.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
@Entity
@Table(name = "FLIGHTS_SCHEDULE")
public class FlightSchedule {

	@Id
	@GeneratedValue
	private int tripCode;

	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "flight_Id")
	private Flight flight;

	// @JsonFormat(pattern = "yyyy-MM-dd")
	private String date;

	// @JsonFormat(pattern = "hh-mm-ss")
	private String time;

	private Float journeyTime;
	private String source;
	private String destination;
	private Integer seatsAvailable;
	private Float offers;
	
	
	public FlightSchedule(int tripCode, String date, String time, Float journeyTime, String source, String destination,
			Integer seatsAvailable, Float offers) {
		super();
		this.tripCode = tripCode;
		this.date = date;
		this.time = time;
		this.journeyTime = journeyTime;
		this.source = source;
		this.destination = destination;
		this.seatsAvailable = seatsAvailable;
		this.offers = offers;
	}
	public int getTripCode() {
		return tripCode;
	}
	public void setTripCode(int tripCode) {
		this.tripCode = tripCode;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Float getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(Float journeyTime) {
		this.journeyTime = journeyTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public Float getOffers() {
		return offers;
	}
	public void setOffers(Float offers) {
		this.offers = offers;
	}
	public FlightSchedule() {
		super();
	}
	
	

		
}
