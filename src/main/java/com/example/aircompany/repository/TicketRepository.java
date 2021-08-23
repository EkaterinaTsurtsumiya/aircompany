package com.example.aircompany.repository;

import com.example.aircompany.structure.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
