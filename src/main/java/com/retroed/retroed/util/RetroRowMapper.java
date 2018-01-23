package com.retroed.retroed.util;

import com.retroed.retroed.model.Retro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RetroRowMapper implements RowMapper<Retro> {

    @Override
    public Retro mapRow(ResultSet resultSet, int i) throws SQLException {
        Retro retro = new Retro();
        retro.setId(resultSet.getLong("retro_id"));
        retro.setName(resultSet.getString("name"));
        retro.setbody(resultSet.getString("body"));

        return retro;
    }
}
