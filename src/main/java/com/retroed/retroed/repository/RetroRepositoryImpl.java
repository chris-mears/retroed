package com.retroed.retroed.repository;

import com.retroed.retroed.model.Retro;
import com.retroed.retroed.util.RetroRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("retroRepository")
public class RetroRepositoryImpl implements RetroRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Retro> getRetros() {
        List<Retro> retros = jdbcTemplate.query("SELECT * FROM retros", new RetroRowMapper());

        return retros;
    }

    @Override
    public Retro getRetro(Integer id) {
        Retro retro = jdbcTemplate.queryForObject("SELECT * FROM retros WHERE retro_id = ?", new RetroRowMapper(), id);
        return retro;
    }

    @Override
    public Retro createRetro(Retro retro) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

				PreparedStatement ps = connection.prepareStatement("insert into retros (name, body) VALUES (?,?)", new String [] {"retro_id"});
				ps.setString(1, retro.getName());
				ps.setString(2, retro.getbody());
				return ps;
			}
		}, keyHolder);
		Number id = keyHolder.getKey();
        return getRetro(id.intValue());
    }
}
