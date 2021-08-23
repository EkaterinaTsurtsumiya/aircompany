package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Airport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank (message = "Введите название аэропорта")
    private String airportName;
    @NotNull (message = "Введите название страны")
    @ManyToOne
    private Country country;

    public Airport(String airportName) {
        this.airportName = airportName;
    }
}
