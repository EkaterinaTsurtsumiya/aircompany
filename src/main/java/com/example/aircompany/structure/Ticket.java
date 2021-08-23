package com.example.aircompany.structure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank (message = "Номер билета не может быть пустым")
    private String number;

    @NotNull(message = "Цена не может быть 0")
    @Positive
    private Integer price;

    @NotNull(message = "А где все пассажиры?")
    @ManyToOne
    private Passenger passenger;

    @ManyToMany(mappedBy = "tickets")
    private List<Flight> flights;

    public Ticket(String number, Integer price) {
        this.number = number;
        this.price = price;
    }
}
