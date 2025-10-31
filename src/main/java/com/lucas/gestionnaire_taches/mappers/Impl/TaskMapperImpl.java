package com.lucas.gestionnaire_taches.mappers.Impl;

import com.lucas.gestionnaire_taches.domain.dto.TaskDto;
import com.lucas.gestionnaire_taches.domain.entities.Task;
import com.lucas.gestionnaire_taches.mappers.TaskMapper;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper
{
    @Override
    public Task fromDto(TaskDto taskDto)
    {
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Task task)
    {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
