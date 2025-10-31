package com.lucas.gestionnaire_taches.mappers.Impl;

import com.lucas.gestionnaire_taches.domain.dto.TaskListDto;
import com.lucas.gestionnaire_taches.domain.entities.Task;
import com.lucas.gestionnaire_taches.domain.entities.TaskList;
import com.lucas.gestionnaire_taches.domain.entities.TaskStatus;
import com.lucas.gestionnaire_taches.mappers.TaskListMapper;
import com.lucas.gestionnaire_taches.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper
{
    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper)
    {
        this.taskMapper = taskMapper;
    }


    /**
     * Convertit un DTO (TaskListDto) en Entité (TaskList).
     *
     * 1. Optional.ofNullable(taskListDto.tasks()) : Vérifie si la liste de DTOs des tâches est NULL.
     * 2. .map(...) : SI la liste n'est pas NULL, ALORS elle est transformée en un Stream.
     * 3. Le Stream est traité : Chaque TaskDto est converti en Entité Task (taskMapper::fromDto).
     * 4. toList() : Les Entités converties sont rassemblées dans une List<Task>.
     * 5. .orElse(null) : SINON (si la liste était NULL au départ), la valeur retournée est NULL.
     *
     * @param taskListDto Le DTO de liste de tâches reçu de la couche API.
     * @return Une Entité TaskList prête à être sauvegardée en base de données.
     */
    @Override
    public TaskList fromDto(TaskListDto taskListDto)
    {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())            //Récupère la liste de DTOs ou un Optional vide.
                        .map(tasks -> tasks.stream()
                            .map(taskMapper::fromDto)
                            .toList()
                        ).orElse(null),
                null,
                null


        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList)
    {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size) // transforme la list en entier (sa taille)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto)
                                .toList()
                        ).orElse(null)


        );
    }

    private Double calculateTaskListProgress(List<Task> tasks)
    {
        if (null == tasks) return null;

        long closedTaskCount = tasks.stream().filter(task ->
                TaskStatus.CLOSED == task.getStatus()).count();

        return (double) closedTaskCount / tasks.size();

    }
}
