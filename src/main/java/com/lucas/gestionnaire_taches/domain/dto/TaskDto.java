package com.lucas.gestionnaire_taches.domain.dto;

import com.lucas.gestionnaire_taches.domain.entities.TaskPriority;
import com.lucas.gestionnaire_taches.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
)
{

}
