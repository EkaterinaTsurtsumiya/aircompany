package com.example.aircompany.api;

import com.example.aircompany.repository.PilotRepository;
import com.example.aircompany.service.PilotService;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Pilot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pilots")
@RequiredArgsConstructor
public class PilotApi {

    private final PilotService pilotService;

    @GetMapping
    public Page<Pilot> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "15", required = false) int size) {

        return pilotService.get(page, size);
    }

    @GetMapping("{id}")
    public Pilot getById(@PathVariable("id") Integer id) {
        return pilotService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pilot save(@RequestBody Pilot pilot) {
        return pilotService.save(pilot);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        pilotService.delete(id);
    }
}
