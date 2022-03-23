package com.lnt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.domain.Flight;
import com.lnt.domain.FlightSchedule;
import com.lnt.domain.UserDetails;
import com.lnt.service.FlightScheduleService;
import com.lnt.service.FlightService;
import com.lnt.service.UserDetailsService;

@RestController
@RequestMapping("/admin")
public class FlightController {
	@Autowired
	private FlightService flightService;
	@Autowired
	private FlightScheduleService fsService;
	@Autowired
	private UserDetailsService userService;

	HttpSession session;

	@PostMapping(value = "/login")
	public boolean login(@RequestBody UserDetails user) {

		System.out.println("Logged IN!");
		System.out.println(user.getFirstName());
		System.out.println(user.getPassword());

		List<UserDetails> users = userService.getAllUserService();
		for (UserDetails x : users) {
			if (x.getFirstName().equals(user.getFirstName()) && x.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(path = "/flight/all", method = RequestMethod.GET)
	public List<Flight> searchAllFlights() {
		return flightService.getAllFlightService();
	}

	@RequestMapping("/flight/find/{id}")
	public Flight findFlightById(@PathVariable int id) {
		return flightService.searchFlightByIdService(id);
	}

	@RequestMapping(path = "/flight/update/{id}", method = RequestMethod.PUT)
	public void updateFlight(@RequestBody Flight f, @PathVariable int id) {
		flightService.updateFlightService(f, id);
	}

	@RequestMapping(path = "/flight/find/{sourceCity}/{destinationCity}", method = RequestMethod.GET)
	public List<Flight> findFlightByCity(@PathVariable String sourceCity, @PathVariable String destinationCity) {
		return flightService.getFlightService(sourceCity, destinationCity);
	}

	@RequestMapping(path = "/flight-schedule/add", method = RequestMethod.POST, consumes = "application/json")
	public void addNewScheduleService(@RequestBody FlightSchedule fs) {
		fsService.addNewScheduleService(fs);
		System.out.println("New FlightSchedule has been added.");
	}

	@RequestMapping(path = "/flight-schedule/update/{id}", method = RequestMethod.PUT)

	public void updateFlightScheduleService(Flight f, int id) {
		fsService.updateFlightScheduleService(f, id);
		System.out.println("Schedule updated!!");

	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	// @PostMapping
	public void addNewFlight(@RequestBody Flight f) {
		flightService.addFlightService(f);
		System.out.println("New Flight added!");
	}
}
