package com.lnt.service;

import java.util.List;

import com.lnt.domain.BookingDetails;

public interface BookingDetailsService {

	List<BookingDetails> getAllBookingService();

	List<BookingDetails> getBookingByDateService(String date);

	void addBookingService(BookingDetails b);

	void cancelBooking(BookingDetails b,int id);

}
