package com.cabBooking.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.models.LoginData;



public interface LoginDataDAO extends JpaRepository<LoginData,Integer>{

}
