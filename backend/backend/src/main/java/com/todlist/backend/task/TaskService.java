package com.todlist.backend.task;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class TaskService {
    public List<Task> getTasks(){
        return List.of(
                new Task(1L,
                        "Cleaning",
                        "Household",
                        LocalDate.of(2020, Month.APRIL,12),
                        LocalDate.of(2021,Month.APRIL,12),
                        "Mark",
                        "Important")
        );
    }
}
