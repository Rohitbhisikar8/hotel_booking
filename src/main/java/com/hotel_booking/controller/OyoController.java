package com.hotel_booking.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking.entity.OyoEntity;
import com.hotel_booking.request.OyoRequest;
import com.hotel_booking.response.OyoResponse;
import com.hotel_booking.services.OyoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("checking")
public class OyoController {
	@Autowired
	OyoService oyoService;

	@PostMapping("done")
	public int checkIn(@RequestBody OyoRequest oyoRequest) {
		int details = oyoService.getDetails(oyoRequest);
		return details;

	}

	@GetMapping("/find/{id}")
	public Optional<OyoEntity> getMethodName(@PathVariable("id") Integer hotelID) {
		Optional<OyoEntity> byID = oyoService.findByID(hotelID);
		return byID;
	}

	@GetMapping("findAll")
	public java.util.List<OyoEntity> getAll() {
		java.util.List<OyoEntity> all = oyoService.findAll();
		return all;

	}

	@GetMapping("findName")
	public OyoEntity findByHotelName(@RequestParam("hotelName") String name) {
		OyoEntity byHotelName = oyoService.findByHotelName(name);
		return byHotelName;
	}

	@GetMapping("/checkBydate")
	public List<OyoResponse> byDate(@RequestParam("checkInDate") LocalDate check) {
	    List<OyoResponse> byDate = oyoService.findByDate(check);
	    return byDate;
	}
}
