package com.todlist.backend.persistence.Impl;

import com.todlist.backend.Mapper.TaskMapper;
import com.todlist.backend.entity.Task;
import com.todlist.backend.persistence.TaskDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;
@Repository
public class TaskJbdcImpl implements TaskDao {
    private static final String TABLE_NAME = "PUBLIC.TASKS";
    private static final TaskMapper taskMapper = new TaskMapper();
    private final JdbcTemplate jdbcTemplate;

    public TaskJbdcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> getAll() {
        final String sql = String.format("SELECT * FROM %s", TABLE_NAME);
        return jdbcTemplate.query(sql, this::mapRow);

    }





    private Task mapRow(ResultSet resultset,int i) throws SQLException {
        final Task task = new Task();

        task.setId(resultset.getLong("id"));
        task.setName(resultset.getString("name"));
        task.setDescription(resultset.getString("description"));
        task.setStarted(resultset.getDate("started").toLocalDate());
        task.setEnded(resultset.getDate("ended").toLocalDate());
        task.setCategory(resultset.getString("category"));
        task.setIssuer(resultset.getString("issuer"));

        return task;


    }
}
