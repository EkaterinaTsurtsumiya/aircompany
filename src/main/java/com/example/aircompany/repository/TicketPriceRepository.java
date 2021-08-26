package com.example.aircompany.repository;
import com.example.aircompany.structure.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceRepository extends JpaRepository<TicketPrice, Integer> {
}
