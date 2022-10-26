package com.brq.ms01.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/*
 * @ControllerAdvice permite manipular exceções de forma global.
 * Para cada tipo de exceção, podemos manipular desde o status
 * até a mensagem de retorno
 * */

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler {

    /* gostaria que o método abaixo trate exceções
        do tipo de validação de dados*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodValidationHandler(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ){
        StandardError standardError = StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validarion Error")
                .path("")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}