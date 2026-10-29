package com.hotel_booking.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.entity.OyoEntity;
import com.hotel_booking.repository.OyoRepository;
import com.hotel_booking.request.OyoRequest;
import com.hotel_booking.response.OyoResponse;

@Service
public class OyoService {

	@Autowired
	OyoRepository oyoRepository;

	public int getDetails(OyoRequest oyoRequest) {

		OyoEntity entity = new OyoEntity();
		entity.setHotelName(oyoRequest.getHotelName());
		entity.setCustomerName(oyoRequest.getCustomerName());
		entity.setMobile(oyoRequest.getMobile());
		entity.setCheckInDate(oyoRequest.getCheckInDate());
		entity.setCheckOutDate(oyoRequest.getCheckOutDate());
		entity.setNumberOfGuests(oyoRequest.getNumberOfGuests());
		entity.setRoomType(oyoRequest.getRoomType());
		entity.setPrice(oyoRequest.getPrice());
		OyoEntity saveBoking = oyoRepository.save(entity);

		return saveBoking.getHotelId();
	}

	public Optional<OyoEntity> findByID(Integer id) {
		Optional<OyoEntity> Idss = oyoRepository.findById(id);
		return Idss;

	}

	public List<OyoEntity> findAll() {
		List<OyoEntity> all = oyoRepository.findAll();
		return all;

	}

	public OyoEntity findByHotelName(String hp) {

		OyoEntity byHotelName = oyoRepository.findByHotelName(hp);
		return byHotelName;
	}

	public List<OyoResponse> findByDate(LocalDate checkIn) {

		List<OyoEntity> bycheckIn = oyoRepository.findByCheckIn(checkIn);

		List<OyoResponse> res = new ArrayList<OyoResponse>();
		for (OyoEntity oyoEntity : bycheckIn) {

			OyoResponse response = new OyoResponse();
			response.setHotelName(oyoEntity.getHotelName());
			response.setCustomerName(oyoEntity.getCustomerName());
			response.setMobile(oyoEntity.getMobile());
			response.setCheckInDate(oyoEntity.getCheckInDate());
			response.setCheckOutDate(oyoEntity.getCheckOutDate());
			response.setNumberOfGuests(oyoEntity.getNumberOfGuests());
			response.setRoomType(oyoEntity.getRoomType());
			response.setPrice(oyoEntity.getPrice());
			res.add(response);
		}

		return res;

	}
}