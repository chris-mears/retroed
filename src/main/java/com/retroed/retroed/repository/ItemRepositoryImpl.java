package com.retroed.retroed.repository;


import com.retroed.retroed.model.Item;
import com.retroed.retroed.util.ItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Item> getItems(Long sectionId) {
        List<Item> items = jdbcTemplate.query("SELECT * FROM items WHERE section_id = ?", new ItemRowMapper(), sectionId);
        return items;
    }

    @Override
    public Item getItem(Long sectionId, Integer id) {
        Item item = jdbcTemplate.queryForObject("SELECT * FROM items WHERE section_id = ? AND item_id = ?", new ItemRowMapper(), sectionId, id);
        return item;
    }

    @Override
    public Item createItem(Item item) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

        insert.setGeneratedKeyName("item_id");

        Map<String, Object> data = new HashMap<>();
        data.put("section_id", item.getSectionId());
        data.put("retro_id", item.getRetroId());
        data.put("title", item.getTitle());
        data.put("body", item.getBody());
        data.put("due_date", item.getDueDate());

        List<String> columns = new ArrayList<>();
        columns.add("section_id");
        columns.add("retro_id");
        columns.add("title");
        columns.add("body");
        columns.add("due_date");

        insert.setTableName("items");
        insert.setColumnNames(columns);
        Number id = insert.executeAndReturnKey(data);

        return getItem(item.getSectionId(), id.intValue());
    }

    @Override
    public Item updateItem(Item item) {
        jdbcTemplate.update("UPDATE items set section_id = ?, retro_id = ?, title = ?, body = ?, due_date = ? WHERE item_id = ?",
                item.getSectionId(), item.getRetroId(), item.getTitle(), item.getBody(), item.getId());

        return item;
    }

    @Override
    public void deleteItem(Integer id) {
        jdbcTemplate.update("DELETE FROM items WHERE item_id = ?", id);
    }
}
