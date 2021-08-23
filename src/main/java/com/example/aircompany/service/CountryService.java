package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.CountryRepository;
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
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<Country> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return countryRepository.findAll(pageRequest);
    }

    public Country getById(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("Country", id));
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);

    }

}
