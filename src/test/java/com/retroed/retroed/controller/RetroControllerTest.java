package com.retroed.retroed.controller;


import com.retroed.retroed.model.Retro;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class RetroControllerTest {

    @Test
    public void testGetRetros() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Retro>> retroResponse = restTemplate.exchange(
                "http://localhost:8080/retros", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Retro>>() {
                });
        List<Retro> retros = retroResponse.getBody();

        assertEquals("Test Retro 1", retros.get(0).getName());
        for(Retro retro : retros)
            System.out.println(retro.toString());
    }

    @Test
    public void testGetRetro() {
        RestTemplate restTemplate = new RestTemplate();
        Retro retro = restTemplate.getForObject("http://localhost:8080/retros/15", Retro.class);

        assertEquals("Test Retro 1", retro.getName());
        System.out.println(retro.toString());
    }

    @Test
    public void testCreateRetro() {
        RestTemplate restTemplate = new RestTemplate();

        Retro retro = new Retro();
        retro.setName("Test Retro 3");
        retro.setbody("This is a test retro");

        Retro responseRetro = restTemplate.postForObject("http://localhost:8080/retros", retro, Retro.class);
        System.out.println(responseRetro.getId());
    }
}
