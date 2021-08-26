package com.example.aircompany.api;

import com.example.aircompany.service.CountryService;
import com.example.aircompany.service.FlightService;
import com.example.aircompany.structure.Country;
import com.example.aircompany.structure.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightApi {

    private final FlightService flightService;

    @GetMapping
    public Page<Flight> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "15", required = false) int size) {
        return flightService.get(page, size);
    }

    @GetMapping("{id}")
    public Flight getById(@PathVariable("id") Integer id) {
        return flightService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight save(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        flightService.delete(id);
    }

}
