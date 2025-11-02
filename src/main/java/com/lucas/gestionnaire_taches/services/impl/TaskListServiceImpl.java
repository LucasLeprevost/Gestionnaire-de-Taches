package com.lucas.gestionnaire_taches.services.impl;

import com.lucas.gestionnaire_taches.domain.entities.TaskList;
import com.lucas.gestionnaire_taches.repositories.TaskListRepository;
import com.lucas.gestionnaire_taches.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public TaskList createTaskList(TaskList taskList)
    {
        if(null!= taskList.getId())
            throw new IllegalArgumentException("TaskList a deja un Id");

        if (null == taskList.getTitle() || taskList.getTitle().isBlank())
                throw new IllegalArgumentException("La taskList doit avoir un titre");

        LocalDateTime now = LocalDateTime.now();
        return this.taskListRepository.save( new TaskList(      // le JPA comprend qu il doit faire un insert into
                null,                                           // grace au .save()
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now

        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id)
    {
        return this.taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList)
    {
        if (null == taskList.getId())
            throw new IllegalArgumentException("TaskList doit avoir un id");

        if (!Objects.equals(taskList.getId(), taskListId))
                throw new IllegalArgumentException("Vous ne pouvez pas modifier l'id d'une taskList");

        TaskList existingTaskList = this.taskListRepository.findById(taskListId).orElseThrow(() ->
                new IllegalArgumentException("TaskList inexistant"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated_at(LocalDateTime.now());
        return taskListRepository.save(existingTaskList);


    }
}
