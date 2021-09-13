package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.FlightRepository;
import com.example.aircompany.repository.TicketPriceRepository;
import com.example.aircompany.repository.TicketRepository;
import com.example.aircompany.structure.Flight;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Ticket;
import com.example.aircompany.structure.TicketPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final PassengerService passengerService;
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    private final TicketPriceRepository ticketPriceRepository;

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

    public Ticket book(List<Integer> ticketPriceIds, Integer passengerId) {
        Passenger passenger = passengerService.getById(passengerId);

        List<TicketPrice> ticketPrices = ticketPriceRepository.findAllById(ticketPriceIds);
        if (ticketPrices.size() != ticketPriceIds.size()) {
            throw new RuntimeException();
        }

        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
//        ticket.setFlights(ticketPrices.stream().map(TicketPrice::getFlight).collect(Collectors.toList()));
        ticket.setPrice(ticketPrices.stream().map(TicketPrice::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        ticket.setNumber(UUID.randomUUID().toString());
        Ticket savedTicket = save(ticket);

        List<Flight> flights = ticketPrices.stream().map(TicketPrice::getFlight)
                .peek(f -> f.getTickets().add(savedTicket))
                .collect(Collectors.toList());
        flightRepository.saveAll(flights);

        return savedTicket;
    }
}
