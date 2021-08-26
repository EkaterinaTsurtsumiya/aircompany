package com.example.aircompany.service;
import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.TicketPriceRepository;
import com.example.aircompany.structure.TicketPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketPriceService {

    private final TicketPriceRepository ticketPriceRepository;

    public Page<TicketPrice> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return ticketPriceRepository.findAll(pageRequest);
    }
    public TicketPrice getById(Integer id) {
        return ticketPriceRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("TicketPrice", id));
    }

    public TicketPrice save(TicketPrice ticketPrice) {
        return ticketPriceRepository.save(ticketPrice);
    }

    public void delete(Integer id) {
        ticketPriceRepository.deleteById(id);

    }
}
