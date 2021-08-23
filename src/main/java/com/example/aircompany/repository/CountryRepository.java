package com.example.aircompany.repository;

import com.example.aircompany.structure.Country;
import com.example.aircompany.structure.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
