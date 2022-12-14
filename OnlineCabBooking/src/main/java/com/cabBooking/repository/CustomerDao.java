package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
