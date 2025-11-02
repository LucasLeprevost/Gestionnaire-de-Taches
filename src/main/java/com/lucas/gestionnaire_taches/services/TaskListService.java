package com.lucas.gestionnaire_taches.services;

import com.lucas.gestionnaire_taches.domain.entities.TaskList;

import java.util.List;

public interface TaskListService
{
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
