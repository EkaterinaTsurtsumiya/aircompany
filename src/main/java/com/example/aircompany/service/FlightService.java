package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.FlightRepository;
import com.example.aircompany.repository.PassengerRepository;
import com.example.aircompany.structure.Country;
import com.example.aircompany.structure.Flight;
import com.example.aircompany.structure.Passenger;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Page<Flight> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return flightRepository.findAll(pageRequest);
    }

    public Flight getById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("Flight", id));
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    public void delete(Integer id) {
        flightRepository.deleteById(id);

    }

}
