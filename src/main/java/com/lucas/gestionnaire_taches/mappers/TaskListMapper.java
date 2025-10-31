package com.lucas.gestionnaire_taches.mappers;

import com.lucas.gestionnaire_taches.domain.dto.TaskListDto;
import com.lucas.gestionnaire_taches.domain.entities.TaskList;

public interface TaskListMapper
{
    TaskList fromDto (TaskListDto taskListDto);
    TaskListDto toDto (TaskList taskList);
}
