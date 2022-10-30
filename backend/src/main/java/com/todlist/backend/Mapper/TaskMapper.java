package com.todlist.backend.Mapper;

import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO entityToDto(Task task){
        return new TaskDTO(task.getId(), task.getName(), task.getDescription(),task.getStarted(),task.getEnded(),task.getIssuer(),task.getCategory(),task.getGroup());
    }

    public Task dtoToEntity(TaskDTO taskDTO){
        return new Task(taskDTO.id(), taskDTO.name(), taskDTO.description(),taskDTO.started(),taskDTO.ended(),taskDTO.issuer(),taskDTO.category(),taskDTO.group());
    }

}
