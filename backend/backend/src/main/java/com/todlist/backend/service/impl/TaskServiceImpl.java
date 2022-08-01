package com.todlist.backend.service.impl;

import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.entity.Task;
import com.todlist.backend.persistence.TaskDao;
import com.todlist.backend.service.TaskService;
import com.todlist.backend.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;
    private final Validator validator;

    public TaskServiceImpl(TaskDao taskDao, Validator validator) {
        this.taskDao = taskDao;
        this.validator = validator;
    }

    @Override
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    public Task saveTask(TaskDTO taskDTO) {
        return taskDao.saveTask(taskDTO);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public Task deleteTaskById(Long id) {
        return taskDao.deleteTaskById(id);
    }

    @Override
    public Task updateTask(TaskDTO taskDTO) {
        return taskDao.updateTask(taskDTO);
    }
}
