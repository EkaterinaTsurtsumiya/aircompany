package com.example.aircompany.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Schema(description = "Dto для заказа билета")
public class TicketBookDto {

    @Schema(description = "Список id полетов для заказа")
    List<Integer> flightIds;
    Integer passengerId;


}
