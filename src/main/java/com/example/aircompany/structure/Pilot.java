package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Имя не может быть пустым или содержать менее 2 символов!")
    @Size(min=2)
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой или содержать менее 2 символов!")
    @Size(min=2)
    private String lastName;

    @ManyToMany
    private List<Flight> flights;

    public Pilot(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
