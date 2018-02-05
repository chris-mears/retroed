package com.retroed.retroed.util;

import com.retroed.retroed.model.Section;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionRowMapper implements RowMapper<Section> {

    @Override
    public Section mapRow(ResultSet resultSet, int i) throws SQLException {
        Section section = new Section();
        section.setId(resultSet.getLong("section_id"));
        section.setRetroId(resultSet.getLong("retro_id"));
        section.setTitle(resultSet.getString("title"));
        section.setNotes(resultSet.getString("notes"));

        return section;
    }
}
