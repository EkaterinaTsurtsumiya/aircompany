package com.example.aircompany.api;

import com.example.aircompany.dto.TicketBookDto;
import com.example.aircompany.repository.PlaneRepository;
import com.example.aircompany.service.PlaneService;
import com.example.aircompany.structure.Plane;
import com.example.aircompany.structure.Ticket;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/plains")
@RequiredArgsConstructor
public class PlaneApi {

    private final PlaneService planeService;

    public Page<Plane> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "15", required = false) int size){
        return planeService.get(page, size);
    }
    @GetMapping("{id}")
    public Plane getById(@PathVariable("id") Integer id) {
        return planeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plane save(@RequestBody Plane plane) {
        return planeService.save(plane);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        planeService.delete(id);
    }

}
