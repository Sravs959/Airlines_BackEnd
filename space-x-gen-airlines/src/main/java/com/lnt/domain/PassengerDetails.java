package com.lnt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "PASSENGER_DETAILS")
public class PassengerDetails {

	private Integer pnrNo;
	private String passengerName;
	private Integer passengerAge;

	@Id
	@GeneratedValue
	private Long uId;

	private Double luggage;
	private String ticketType;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Booking_Id")
	private BookingDetails booking;

	public Integer getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(Integer pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public Double getLuggage() {
		return luggage;
	}

	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public BookingDetails getBooking() {
		return booking;
	}

	public void setBooking(BookingDetails booking) {
		this.booking = booking;
	}

}
