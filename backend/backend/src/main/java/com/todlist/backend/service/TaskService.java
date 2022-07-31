package com.todlist.backend.service;

import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task saveTask(TaskDTO taskDTO);


    Task getTaskById(Long id);
}
