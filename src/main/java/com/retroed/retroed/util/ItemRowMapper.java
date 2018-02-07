package com.retroed.retroed.util;

import com.retroed.retroed.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getLong("item_id"));
        item.setRetroId(resultSet.getLong("retro_id"));
        item.setSectionId(resultSet.getLong("section_id"));
        item.setTitle(resultSet.getString("title"));
        item.setBody(resultSet.getString("body"));
        item.setType(resultSet.getString("item_type"));
        item.setDueDate(resultSet.getDate("due_date"));

        return item;
    }
}
