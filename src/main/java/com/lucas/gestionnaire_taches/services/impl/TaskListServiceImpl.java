package com.lucas.gestionnaire_taches.services.impl;

import com.lucas.gestionnaire_taches.domain.entities.TaskList;
import com.lucas.gestionnaire_taches.repositories.TaskListRepository;
import com.lucas.gestionnaire_taches.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService
{
    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository)
    {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists()
    {
        return this.taskListRepository.findAll();
    }
}
