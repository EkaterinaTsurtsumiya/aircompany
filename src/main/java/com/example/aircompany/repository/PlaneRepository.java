package com.example.aircompany.repository;

import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}
