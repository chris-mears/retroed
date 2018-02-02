package com.retroed.retroed.controller;

import com.retroed.retroed.model.Retro;
import com.retroed.retroed.model.Section;
import com.retroed.retroed.util.RetroRowMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SectionControllerTest {
    Retro retro = new Retro();

    @BeforeAll
    public void getRetro() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Retro>> retroResponse = restTemplate.exchange(
                "http://localhost:8080/retros/?name=Section Test Retro", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Retro>>() {
                });
        List<Retro> retros = retroResponse.getBody();
        this.retro = retros.get(0);
        System.out.println(this.retro.getName());
    }

}
