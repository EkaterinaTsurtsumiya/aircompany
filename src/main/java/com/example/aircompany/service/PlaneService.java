package com.example.aircompany.service;

import com.example.aircompany.exception.AirEntityNotFoundException;
import com.example.aircompany.repository.PassengerRepository;
import com.example.aircompany.repository.PlaneRepository;
import com.example.aircompany.structure.Flight;
import com.example.aircompany.structure.Passenger;
import com.example.aircompany.structure.Plane;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public Page<Plane> get(int page, int size) {

        Pageable pageRequest = PageRequest.of(page, size);
        return planeRepository.findAll(pageRequest);
    }
    public Plane getById(Integer id) {
        return planeRepository.findById(id)
                .orElseThrow(() -> new AirEntityNotFoundException("Plane", id));
    }

    public Plane save(Plane plane) {
        return planeRepository.save(plane);
    }

    public void delete(Integer id) {
        planeRepository.deleteById(id);

    }
}
