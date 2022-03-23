package com.lnt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.domain.BookingDetails;
import com.lnt.domain.FlightSchedule;
import com.lnt.domain.UserDetails;
import com.lnt.service.BookingDetailsService;
import com.lnt.service.FlightScheduleService;
import com.lnt.service.UserDetailsService;
@CrossOrigin(origins = "*",
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/users")
public class UserDetailsController {

	@Autowired
	private UserDetailsService userService;
	@Autowired
	private BookingDetailsService bookingService;
	@Autowired
	private FlightScheduleService fsService;

	HttpSession session;

	@PostMapping(value = "/login")
	public boolean login(@RequestBody UserDetails user) {

		System.out.println("Logged IN!");
		System.out.println(user.getFirstName());
		System.out.println(user.getPassword());
		List<UserDetails> users = userService.getAllUserService();

		for (UserDetails u : users) {
			if (u.getFirstName().equals(user.getFirstName()) && u.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;

	}

	@RequestMapping("/all")
	public List<UserDetails> getAllUsers() {
		return userService.getAllUserService();
	}

	@RequestMapping("/find/{id}")
	public UserDetails findUserById(@PathVariable int id) {
		return userService.searchUserByIdService(id);
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void updateUserDetails(@RequestBody UserDetails u, @PathVariable int id) {
		userService.updateUserDetailsService(u, id);
	}

	@RequestMapping(path = "/booking", method = RequestMethod.POST, consumes="application/json")
	public void addANewBooking(@RequestBody BookingDetails b) {
		System.out.println("Booking successful!");
		bookingService.addBookingService(b);
	}

	@RequestMapping(path = "/booking/find/{bookingDate}", method = RequestMethod.GET)
	public List<BookingDetails> findBookingByDate(@PathVariable String bookingDate) {
		return bookingService.getBookingByDateService(bookingDate);
	}

	@RequestMapping(path = "/booking/update/{id}", method = RequestMethod.GET)
	public void cancelBooking(@RequestBody BookingDetails b, @PathVariable int id) {
		System.out.println("Booking has been cancelled!");
		bookingService.cancelBooking(b, id);
	}

	@RequestMapping(path = "/flight-schedule/all", method = RequestMethod.GET)
	public List<FlightSchedule> getAllSchedules() {
		return fsService.getAllSchedules();
	}

	@RequestMapping(path = "/flight-schedule/find/{date}/{time}", method = RequestMethod.GET)
	public List<FlightSchedule> getScheduleByDateAndTime(String date, String time) {
		return fsService.getScheduleByDateAndTime(date, time);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	// @PostMapping
	public void addNewUser(@RequestBody UserDetails u) {
		System.out.println(u.getFirstName());
		userService.addUserService(u);
	}
}
