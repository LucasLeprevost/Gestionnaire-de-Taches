package com.lucas.gestionnaire_taches.domain.dto;

public record ErrorResponse(
    int status,
    String message,
    String details
    )
{
}
