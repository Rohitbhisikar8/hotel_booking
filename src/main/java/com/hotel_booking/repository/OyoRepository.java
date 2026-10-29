package com.hotel_booking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel_booking.entity.OyoEntity;

public interface OyoRepository extends JpaRepository<OyoEntity, Integer> {
	public OyoEntity findByHotelName(String hotelName);

	 @Query("SELECT o FROM OyoEntity o WHERE o.checkInDate = :data")
	List<OyoEntity> findByCheckIn(@Param("data") LocalDate data);

	 

}
