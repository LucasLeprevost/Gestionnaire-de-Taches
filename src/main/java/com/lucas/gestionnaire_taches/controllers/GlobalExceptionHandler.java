package com.lucas.gestionnaire_taches.controllers;

import com.lucas.gestionnaire_taches.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice   //Indique à Spring de surveiller toutes les erreurs qui se produisent dans @RestController
public class GlobalExceptionHandler
{
    @ExceptionHandler(IllegalArgumentException.class)//specifie le type d'Exception que Spring doit intercepter
    public ResponseEntity<ErrorResponse> handleException(
            RuntimeException ex, WebRequest request)
    {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
