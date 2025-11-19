package com.lucas.gestionnaire_taches.services.impl;

import com.lucas.gestionnaire_taches.domain.entities.Task;
import com.lucas.gestionnaire_taches.domain.entities.TaskList;
import com.lucas.gestionnaire_taches.domain.entities.TaskPriority;
import com.lucas.gestionnaire_taches.domain.entities.TaskStatus;
import com.lucas.gestionnaire_taches.repositories.TaskListRepository;
import com.lucas.gestionnaire_taches.repositories.TaskRepository;
import com.lucas.gestionnaire_taches.services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Service
public class TaskServiceImpl implements TaskService
{
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepo, TaskListRepository taskListRepository)
    {
        this.taskRepository = taskRepo;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId)
    {
        return this.taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task)
    {
        if (task.getId() != null)
            throw new IllegalArgumentException("Cette tache a deja un id");


        if (task.getTitle() == null || task.getTitle().isBlank())
            throw new IllegalArgumentException(("Task doit avoir un titre non vide"));

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);

        LocalDateTime now = now();

        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = this.taskListRepository.findById(taskListId)
                .orElseThrow( () -> new IllegalArgumentException("un taskListId invalide est interdit"));

        Task taskToSave  = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskStatus,
                taskPriority,
                taskList,
                now,
                now

        );

        return this.taskRepository.save(taskToSave);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId)
    {
        return this.taskRepository.findByTaskListIdAndId(taskListId,taskId);
    }


    @Override
    public Task updateTask() {
        return null;
    }

    @Override
    public void deleteTask() {

    }
}
