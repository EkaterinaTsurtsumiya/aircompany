package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.FlightRepository;
import com.example.aircompany.repository.TicketRepository;
import com.example.aircompany.structure.Flight;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final PassengerService passengerService;
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;

    public Page<Ticket> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return ticketRepository.findAll(pageRequest);
    }
    public Ticket getById(Integer id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("Ticket", id));
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void delete(Integer id) {
        ticketRepository.deleteById(id);
    }

    public Ticket book(List<Integer> flightIds, Integer passengerId){
        Passenger passenger = passengerService.getById(passengerId);

        List<Flight> flights = flightRepository.findAllById(flightIds);
        if (flights.size() < flightIds.size()) {
            throw new RuntimeException();
        }

        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setFlights(flights);
        ticket.setNumber(UUID.randomUUID().toString());
        return save(ticket);
    }
}
