package com.lnt.repository;

import java.util.List;

import com.lnt.domain.Flight;
import com.lnt.domain.FlightSchedule;

public interface FlightScheduleDao {

	List<FlightSchedule> searchAllSchedules();
	
	Flight searchFlightById(int id);
	
	FlightSchedule searchFlightScheduleByTripCode(int tripCode);
	
	List<FlightSchedule> searchScheduleByDateAndTime(String date, String time);
	
	void addNewSchedule(FlightSchedule fs);
	
	void updateFlightSchedule(Flight f, int id);
	
	void deleteFlightSchedule(Flight f, int id);

	void updateSeats(Integer noOfPassenger, int tripCode);
	
}
