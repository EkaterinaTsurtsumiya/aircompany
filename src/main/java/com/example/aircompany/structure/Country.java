package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Введите название страны")
    private String countryName;

    public Country(String countryName) {
        this.countryName = countryName;
    }
}
