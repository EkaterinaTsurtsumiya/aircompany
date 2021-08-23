package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class TicketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Поле полет должно быть заполнено")
    @ManyToOne
    private Flight flight;

    @NotBlank(message = "Не указан тип самолета")
    private String typeOfClass;

    @NotNull(message = "Цена не может быть 0")
    @Positive
    private BigDecimal price;

}
