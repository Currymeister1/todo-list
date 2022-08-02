package com.todlist.backend.persistence.Impl;

import com.todlist.backend.DTO.IssuerDTO;
import com.todlist.backend.Mapper.IssuerMap;
import com.todlist.backend.entity.Issuer;
import com.todlist.backend.persistence.IssuerDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.UUID;


@Repository
public class IssuerJbdcImpl implements IssuerDao {
    final String TABLE_NAME = "issuers";
    private final JdbcTemplate jdbcTemplate;
    private final IssuerMap issuerMap;
    public IssuerJbdcImpl(JdbcTemplate jdbcTemplate, IssuerMap issuerMap) {
        this.jdbcTemplate = jdbcTemplate;
        this.issuerMap = issuerMap;
    }

    @Override
    public List<Issuer> getAll() {
        final String sql = String.format("SELECT * FROM %s",TABLE_NAME);

        return jdbcTemplate.query(sql,this::mapRow);
    }

    @Override
    public Issuer saveIssuer(IssuerDTO issuerDTO) {
        Issuer issuer = issuerMap.dtoToEntity(issuerDTO);
        String uniqueID = UUID.randomUUID().toString();

        final String sql = String.format("INSERT INTO %s (id,name,role) VALUES(?,?,?)",TABLE_NAME);

        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1,uniqueID);
                ps.setString(2,issuer.getName());
                ps.setString(3,issuer.getRole());

                return ps;
            }
        };



        jdbcTemplate.update(psc);




        return issuer;
    }


    private Issuer mapRow(ResultSet resultset, int i) throws SQLException {
        final Issuer issuer = new Issuer();

        issuer.setId(resultset.getString("id"));
        issuer.setName(resultset.getString("name"));
        issuer.setRole(resultset.getString("role"));

        return issuer;

    }
}
