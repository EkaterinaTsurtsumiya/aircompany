package com.example.aircompany.api;

import com.example.aircompany.repository.CountryRepository;
import com.example.aircompany.repository.PassengerRepository;
import com.example.aircompany.service.CountryService;
import com.example.aircompany.structure.Country;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Pilot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryApi {

    private final CountryService countryService;

    @GetMapping
    public Page<Country> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "15", required = false) int size) {

        return countryService.get(page, size);
    }

    @GetMapping("{id}")
    public Country getById(@PathVariable("id") Integer id) {
        return countryService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country save(@RequestBody Country country) {
        return countryService.save(country);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        countryService.delete(id);
    }


}
