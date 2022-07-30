package com.todlist.backend.rest;


import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.Mapper.TaskMapper;
import com.todlist.backend.service.TaskService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(TaskEndpoint.BASE_URL)
public class TaskEndpoint {
    static final String BASE_URL = "/tasks";
    private final TaskService taskService;
    private final TaskMapper taskMapper;


    public TaskEndpoint(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public Stream<TaskDTO> getAll(){
        return taskService.getAll().stream().map(taskMapper::entityToDto);
    }
}
