package com.innovapp.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovapp.tickets.model.Passenger;

public interface PassegerRepository extends JpaRepository<Passenger, Integer> {

}
