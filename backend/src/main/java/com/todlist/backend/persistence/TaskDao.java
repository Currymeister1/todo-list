package com.todlist.backend.persistence;

import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.entity.Task;

import java.util.List;

public interface TaskDao {

    List<Task> getAll(String name);

    Task saveTask(TaskDTO taskDTO);

    Task getTaskById(Long id);

    Task deleteTaskById(Long id);

    Task updateTask(TaskDTO taskDTO);
}
