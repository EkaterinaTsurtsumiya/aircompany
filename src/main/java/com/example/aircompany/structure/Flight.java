package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "Номер рейса не указан")
    private String number;

    @NotNull(message = "Время вылета не указано")
    private LocalDateTime departureTime;

    @NotNull(message = "Время прибытия не указано")
    private LocalDateTime destinationTime;

    @NotNull (message = "Введите место отправления")
    @ManyToOne

    private Country departure;

    @NotNull (message = "Введите место назначения")
    @ManyToOne
    private Country destination;

    @NotNull(message = "Неизвестный тип самолета")
    @ManyToOne
    private Plane plane;

    @ManyToMany
    private List<Ticket> tickets;

    @NotNull (message = "Без пилота самолет не полетит")
    //TODO
    @ManyToMany(mappedBy = "flights")
    private List<Pilot> pilots;

    public Flight(String number, LocalDateTime departureTime, LocalDateTime destinationTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }
}
