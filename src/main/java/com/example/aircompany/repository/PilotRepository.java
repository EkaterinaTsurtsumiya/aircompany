package com.example.aircompany.repository;

import com.example.aircompany.structure.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, Integer> {
}
