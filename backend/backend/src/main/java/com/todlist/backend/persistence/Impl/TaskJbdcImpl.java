package com.todlist.backend.persistence.Impl;

import com.todlist.backend.DTO.TaskDTO;
import com.todlist.backend.Mapper.TaskMapper;
import com.todlist.backend.entity.Task;
import com.todlist.backend.persistence.IssuerDao;
import com.todlist.backend.persistence.TaskDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import java.sql.*;

import java.time.ZoneId;
import java.util.List;
@Repository
public class TaskJbdcImpl implements TaskDao {
    private static final String TABLE_NAME = "TASKS";
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

    @Override
    public Task saveTask(TaskDTO taskDTO) {
        Task task = taskMapper.dtoToEntity(taskDTO);

        String issuerName = issuerName(task.getIssuer());
        Long groupID = getGroupId(task.getGroup());
        final String sql = String.format("INSERT INTO %s (name,description,started,ended,issuer,category,groupID) VALUES(?,?,?,?,?,?,?)",TABLE_NAME);

        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1,task.getName());
                ps.setString(2,task.getDescription());
                ps.setDate(3,Date.valueOf(task.getStarted()));
                ps.setDate(4,Date.valueOf(task.getEnded()));
                ps.setString(5,task.getIssuer());
                ps.setString(6,task.getCategory());
                ps.setLong(7,groupID);

                return ps;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(psc,keyHolder);

        long insertedID = keyHolder.getKey().longValue();

        task.setId(insertedID);
        task.setIssuer(issuerName);
        return task;
    }

    @Override
    public Task getTaskById(Long id) {
        final String sql = String.format("SELECT * FROM %s WHERE ID = %d",TABLE_NAME,id);

        return jdbcTemplate.query(sql,this::mapRow).get(0);
    }

    @Override
    public Task deleteTaskById(Long id) {
        Task task = getTaskById(id);
        final String sql = String.format("DELETE FROM %s WHERE ID=%d", TABLE_NAME, id);
        jdbcTemplate.execute(sql);
        return task;
    }

    @Override
    public Task updateTask(TaskDTO taskDTO) {
        Task task = taskMapper.dtoToEntity(taskDTO);
        long id =  task.getId();
        final String sql = String.format("UPDATE %s SET name=?,description=?,started=?,ended=?,issuer=?,category=? WHERE ID = ?",TABLE_NAME);

        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1,task.getName());
                ps.setString(2,task.getDescription());
                ps.setDate(3,Date.valueOf(task.getStarted()));
                ps.setDate(4,Date.valueOf(task.getEnded()));
                ps.setString(5,task.getIssuer());
                ps.setString(6,task.getCategory());
                ps.setLong(7,id);

                return ps;
            }
        };
        jdbcTemplate.update(psc);

        return task;

    }


    private String issuerName(String id){
        final String sql = "SELECT name FROM issuers WHERE ID = ?";

        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1,id);

                return ps;
            }
        };
       return jdbcTemplate.query(psc,this::mapRowIssuerName).get(0);
    }

    private Long getGroupId(String groupName){
        final String sql = "SELECT id FROM roles where name=?";

        final PreparedStatementCreator psc = con -> {
            final PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,groupName);
            return ps;
        };
        System.out.println("HELLO"+groupName);
        return jdbcTemplate.query(psc,this::mapRowGroup).get(0);

    }
    private Long mapRowGroup(ResultSet resultSet, int i) throws SQLException{
        return resultSet.getLong("id");
    }


    private String mapRowIssuerName(ResultSet resultSet, int i) throws SQLException{
        return resultSet.getString("name");
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

        System.out.println(task.getIssuer());
        task.setIssuer(issuerName(task.getIssuer()));
        return task;


    }
}
