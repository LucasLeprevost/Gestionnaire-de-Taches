package com.lucas.gestionnaire_taches.services;

import com.lucas.gestionnaire_taches.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService
{
    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID taskListId, Task task);
    Task updateTask();
    void deleteTask();
}
