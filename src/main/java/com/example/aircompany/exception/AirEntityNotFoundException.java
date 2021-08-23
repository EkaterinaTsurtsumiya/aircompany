package com.example.aircompany.exception;

import javax.persistence.EntityNotFoundException;

public class AirEntityNotFoundException extends EntityNotFoundException {

    public AirEntityNotFoundException(String entityName, Integer id){
        super(entityName + " with id = " + id + " not found!");
    }

}
