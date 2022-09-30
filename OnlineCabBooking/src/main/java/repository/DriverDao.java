package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.Driver;
@Repository
public interface DriverDao extends JpaRepository<Driver, Integer> {

}
