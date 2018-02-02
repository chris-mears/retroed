package com.retroed.retroed.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
