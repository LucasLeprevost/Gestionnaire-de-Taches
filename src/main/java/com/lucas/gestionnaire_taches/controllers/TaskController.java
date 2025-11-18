package com.lucas.gestionnaire_taches.controllers;

import com.lucas.gestionnaire_taches.domain.dto.TaskDto;
import com.lucas.gestionnaire_taches.domain.entities.Task;
import com.lucas.gestionnaire_taches.mappers.TaskMapper;
import com.lucas.gestionnaire_taches.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping (path = "api/task-lists/{task_list_id}/tasks")
public class TaskController
{
    private final TaskService taskService;
    private  final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper)
    {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTask (@PathVariable("task_list_id") UUID taskListId)
    {
        return this.taskService.listTasks(taskListId).stream()
                .map(this.taskMapper::toDto)
                .toList();

    }

    @PostMapping
    public TaskDto createTask (@PathVariable("task_list_id") UUID taskListId,
                                     @RequestBody TaskDto taskDto)
    {
        Task taskCreated = this.taskService.createTask(taskListId,
                this.taskMapper.fromDto(taskDto));

        return this.taskMapper.toDto(taskCreated);
    }
}
