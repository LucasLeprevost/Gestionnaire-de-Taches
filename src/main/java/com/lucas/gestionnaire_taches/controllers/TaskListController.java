package com.lucas.gestionnaire_taches.controllers;

import com.lucas.gestionnaire_taches.domain.dto.TaskListDto;
import com.lucas.gestionnaire_taches.domain.entities.TaskList;
import com.lucas.gestionnaire_taches.mappers.TaskListMapper;
import com.lucas.gestionnaire_taches.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController
{
    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper)
    {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }



    @GetMapping
    public List<TaskListDto> listTaskLists()
    {
       return  this.taskListService.listTaskLists()
                .stream()
                .map(this.taskListMapper::toDto)
                .toList();
    }


    /**
     * Gère la requête HTTP POST sur /api/task-lists pour créer une nouvelle liste de tâches.
     *
     * Reçoit un DTO du client, appelle la logique métier (Service) pour sauvegarder la liste,
     * puis retourne le DTO mis à jour, incluant l'ID généré par la base de données.
     *
     * @param taskListDto Le DTO des données envoyées par le client.
     * @return Le DTO de liste de tâches complété (avec l'ID et les dates générées).
     */
    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto)
    {
        TaskList createdTaskList = this.taskListService.createTaskList(
                this.taskListMapper.fromDto(taskListDto)
        );

        return this.taskListMapper.toDto(createdTaskList);
    }

    @GetMapping("/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable ("task_list_id") UUID taskListId)
    {
        return this.taskListService.getTaskList(taskListId).map(this.taskListMapper::toDto);
    }
}
