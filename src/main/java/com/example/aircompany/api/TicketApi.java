package com.example.aircompany.api;

import com.example.aircompany.dto.TicketBookDto;
import com.example.aircompany.service.PilotService;
import com.example.aircompany.service.TicketService;
import com.example.aircompany.structure.Pilot;
import com.example.aircompany.structure.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
@Tag(name = "Ticket Api", description = "Api для работы с билетами")
public class TicketApi {

    private final TicketService ticketService;

    @GetMapping
    public Page<Ticket> getAll(@RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "15", required = false) int size) {

        return ticketService.get(page, size);
    }

    @GetMapping("{id}")
    public Ticket getById(@PathVariable("id") Integer id) {
        return ticketService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        ticketService.delete(id);
    }

    @Operation(summary = "Метод для заказа билетов")
    @PostMapping("book")
    public Ticket book(@RequestBody TicketBookDto ticketBookDto){
        return ticketService.book(ticketBookDto.getFlightIds(), ticketBookDto.getPassengerId());
    }
}



