package com.example.aircompany.advice;

import com.example.aircompany.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.net.BindException;
import java.time.LocalDateTime;
@Slf4j
@RestControllerAdvice
public class ApiAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handleEntityNotFoundException(Exception e, WebRequest request) {
        ExceptionDto dto = ExceptionDto.builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        log.error(dto.toString(),e);
        return dto;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handleEntityNotFoundException(EntityNotFoundException e, WebRequest request) {
        ExceptionDto dto = ExceptionDto.builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        log.warn(dto.toString());
        return dto;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleEmptyResultDataAccessException(EmptyResultDataAccessException e, WebRequest request) {
        ExceptionDto dto = ExceptionDto.builder()
                .message("Нельзя удалить то, чего нет")
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false))
                .build();
        log.warn(dto.toString());
        return dto;
    }

}
