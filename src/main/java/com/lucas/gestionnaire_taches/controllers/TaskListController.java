package com.lucas.gestionnaire_taches.controllers;

import com.lucas.gestionnaire_taches.domain.dto.TaskListDto;
import com.lucas.gestionnaire_taches.mappers.TaskListMapper;
import com.lucas.gestionnaire_taches.services.TaskListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
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
}
