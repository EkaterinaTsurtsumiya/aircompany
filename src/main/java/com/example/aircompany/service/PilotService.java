package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.PilotRepository;
import com.example.aircompany.structure.Country;
import com.example.aircompany.structure.Pilot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PilotService {

    private final PilotRepository pilotRepository;

    public Page<Pilot> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return pilotRepository.findAll(pageRequest);
    }

    public Pilot getById(Integer id) {
        return pilotRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("Pilot", id));
    }

    public Pilot save(Pilot pilot) {
        return pilotRepository.save(pilot);
    }

    public void delete(Integer id) {
        pilotRepository.deleteById(id);
    }
}
