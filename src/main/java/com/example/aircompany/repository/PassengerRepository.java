package com.example.aircompany.repository;

import com.example.aircompany.structure.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
