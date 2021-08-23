package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Data
@NoArgsConstructor
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Отсутсвует тип самолета")
    private String typeOfAircraft;
    @NotNull(message = "Количество мест не может быть 0 или меньше")
    @Positive
    private Integer countOfSeats;

    public Plane(String typeOfAircraft, Integer countOfSeats) {
        this.typeOfAircraft = typeOfAircraft;
        this.countOfSeats = countOfSeats;
    }
}
