package com.example.aircompany.api;

import com.example.aircompany.repository.PassengerRepository;
import com.example.aircompany.service.PassengerService;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Pilot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
@RequiredArgsConstructor
public class PassengerApi {

    private final PassengerService passengerService;

    @GetMapping
    public Page<Passenger> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                                  @RequestParam(defaultValue = "15", required = false) int size) {
        return passengerService.get(page, size);
    }

    @GetMapping("{id}")
    public Passenger getById(@PathVariable("id") Integer id) {
        return passengerService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passenger save(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        passengerService.delete(id);
    }


}
