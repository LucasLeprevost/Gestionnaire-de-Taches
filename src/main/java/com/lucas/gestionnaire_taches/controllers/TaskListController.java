package com.lucas.gestionnaire_taches.controllers;

import com.lucas.gestionnaire_taches.domain.dto.TaskListDto;
import com.lucas.gestionnaire_taches.domain.entities.TaskList;
import com.lucas.gestionnaire_taches.mappers.TaskListMapper;
import com.lucas.gestionnaire_taches.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto)
    {
        TaskList createTaskList = this.taskListService.createTaskList(
                this.taskListMapper.fromDto(taskListDto)
        );

        return this.taskListMapper.toDto(createTaskList);
    }
}
