package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.PassengerRepository;
import com.example.aircompany.repository.PilotRepository;
import com.example.aircompany.structure.Country;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Pilot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public Page<Passenger> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return passengerRepository.findAll(pageRequest);
    }

    public Passenger getById(Integer id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("Passenger", id));
    }

    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public void delete(Integer id) {
        passengerRepository.deleteById(id);
    }
}
