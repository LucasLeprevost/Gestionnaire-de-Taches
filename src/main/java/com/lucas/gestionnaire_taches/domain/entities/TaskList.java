package com.lucas.gestionnaire_taches.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.REMOVE,
                                                 CascadeType.PERSIST})
    private List<Task> tasks;

    @Column(name = "created", nullable = false)
    private LocalDateTime createdAt;

    @Column (name = "updated", nullable = false)
    private LocalDateTime updated_at;

    public TaskList()
    {
    }

    public TaskList(UUID id, String title, String description, List<Task> tasks, LocalDateTime createdAt,
                    LocalDateTime updated_at)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.createdAt = createdAt;
        this.updated_at = updated_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title) && Objects.equals(description, taskList.description) && Objects.equals(tasks, taskList.tasks) && Objects.equals(createdAt, taskList.createdAt) && Objects.equals(updated_at, taskList.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, createdAt, updated_at);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", createdAt=" + createdAt +
                ", updated_at=" + updated_at +
                '}';
    }
}
