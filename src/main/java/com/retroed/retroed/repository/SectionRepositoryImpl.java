package com.retroed.retroed.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("sectionRepository")
public class SectionRepositoryImpl implements SectionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
