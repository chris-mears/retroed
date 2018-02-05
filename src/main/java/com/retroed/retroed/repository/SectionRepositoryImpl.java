package com.retroed.retroed.repository;

import com.retroed.retroed.model.Section;
import com.retroed.retroed.util.SectionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("sectionRepository")
public class SectionRepositoryImpl implements SectionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Section> getSections(Long retroId) {
        List<Section> sections = jdbcTemplate.query("SELECT * FROM sections WHERE retro_id = ?", new SectionRowMapper(), retroId);
        return sections;
    }

    @Override
    public Section getSection(Long retroId, Integer id) {
        Section section = jdbcTemplate.queryForObject("SELECT * FROM sections WHERE retro_id = ? AND section_id = ?", new SectionRowMapper(), retroId, id);
        return section;
    }

    @Override
    public Section createSection(Section section) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setGeneratedKeyName("section_id");

        Map<String, Object> data = new HashMap<>();
        data.put("retro_id", section.getRetroId());
        data.put("title", section.getTitle());
        data.put("notes", section.getNotes());

        List<String> columns = new ArrayList<>();
        columns.add("retro_id");
        columns.add("title");
        columns.add("notes");

        insert.setTableName("sections");
        insert.setColumnNames(columns);
        Number id = insert.executeAndReturnKey(data);

        return getSection(section.getRetroId(), id.intValue());
    }

    @Override
    public Section updateSection(Section section) {
        jdbcTemplate.update("UPDATE sections set retro_id = ?, title = ?, notes = ? WHERE section_id = ?", section.getRetroId(), section.getTitle(), section.getNotes(), section.getId());

        return section;
    }

    @Override
    public void deleteSection(Integer id) {
        jdbcTemplate.update("DELETE FROM sections WHERE section_id = ?", id);
    }
}
