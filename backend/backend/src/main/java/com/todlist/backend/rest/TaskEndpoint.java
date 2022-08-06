package com.todlist.backend.rest;


import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.Mapper.TaskMapper;
import com.todlist.backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
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

    @GetMapping("/group/{name}")
    public Stream<TaskDTO> getAll(@PathVariable("name")  String name){
        return taskService.getAll(name).stream().map(taskMapper::entityToDto);
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable("id") Long id){
        return taskMapper.entityToDto(taskService.getTaskById(id));
    }

    @PostMapping
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){

        return taskMapper.entityToDto(taskService.saveTask(taskDTO));
    }

    @DeleteMapping("/{id}")
    public TaskDTO deleteTaskById(@PathVariable("id") Long id){
        return taskMapper.entityToDto(taskService.deleteTaskById(id));
    }

    @PutMapping
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO){
        return taskMapper.entityToDto(taskService.updateTask(taskDTO));
    }
}
