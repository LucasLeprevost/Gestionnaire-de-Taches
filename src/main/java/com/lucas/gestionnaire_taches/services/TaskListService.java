package com.lucas.gestionnaire_taches.services;

import com.lucas.gestionnaire_taches.domain.entities.TaskList;

import java.util.List;
import java.util.UUID;

public interface TaskListService
{
    List<TaskList> listTaskLists();
}
