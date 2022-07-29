package com.todlist.backend.persistence;

import com.todlist.backend.entity.Task;

import java.util.List;

public interface TaskDao {

    List<Task> getAll();
}
