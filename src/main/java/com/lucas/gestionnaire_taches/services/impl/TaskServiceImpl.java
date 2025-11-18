package com.lucas.gestionnaire_taches.services.impl;

import com.lucas.gestionnaire_taches.domain.entities.Task;
import com.lucas.gestionnaire_taches.repositories.TaskRepository;
import com.lucas.gestionnaire_taches.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService
{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepo)
    {
        this.taskRepository = taskRepo;
    }

    @Override
    public List<Task> listTasks(UUID taskListId)
    {
        return this.taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask() {
        return null;
    }

    @Override
    public Task updateTask() {
        return null;
    }

    @Override
    public void deleteTask() {

    }
}
