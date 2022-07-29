package com.todlist.backend.service;

import com.todlist.backend.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
}
