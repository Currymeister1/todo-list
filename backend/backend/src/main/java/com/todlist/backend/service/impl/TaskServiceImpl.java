package com.todlist.backend.service.impl;

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
}
