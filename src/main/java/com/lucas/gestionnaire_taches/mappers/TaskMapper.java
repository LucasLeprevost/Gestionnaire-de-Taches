package com.lucas.gestionnaire_taches.mappers;

import com.lucas.gestionnaire_taches.domain.dto.TaskDto;
import com.lucas.gestionnaire_taches.domain.entities.Task;

public interface TaskMapper
{
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
