package com.example.aircompany.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Имя не должно быть пустым или содержать менее 2 символов!")
    @Size(min=2)
    private String firstName;
    @NotBlank(message = "Фамилия не должна быть пустой или содержать менее 2 символов!")
    @Size(min=2)
    private String lastName;
    //TODO
    @NotBlank (message = "Паспорт не может содержать меньше 9 символов и более 11")
    @Size(min=9, max =11)
    private String passport;
    @NotNull (message = "Поле email должно быть заполнено!")
    @Pattern(regexp = "^(\\b[a-zA-Z0-9\\-._]+)(@)([a-zA-Z0-9\\-.]+)(\\.)([a-zA-Z]{2,4})$",message = "Электронный адрес некорректен")
    private String email;
    @NotNull(message = "Не указан номер телефона")
    @Pattern(regexp = "^(\\+\\d{1,2})?\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2}$", message = "Номер телефона некорректен")
    private String phoneNumber;

    public Passenger(String firstName, String lastName, String passport, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
