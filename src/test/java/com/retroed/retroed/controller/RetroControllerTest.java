package com.retroed.retroed.controller;


import com.retroed.retroed.model.Retro;
import org.testng.annotations.Test;
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

        for(Retro retro : retros)
            System.out.println(retro.toString());
    }

    @Test
    public void testGetRetroByOption() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Retro>> retroResponse = restTemplate.exchange(
                "http://localhost:8080/retros/?name=Section", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Retro>>() {
                });
        List<Retro> retros = retroResponse.getBody();

        for(Retro retro : retros)
        System.out.println(retro);
    }

    @Test
    public void testGetRetro() {
        RestTemplate restTemplate = new RestTemplate();
        Retro retro = restTemplate.getForObject("http://localhost:8080/retros/25", Retro.class);

        assertEquals("Section Test Retro", retro.getName());
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

    @Test
    public void testUpdateRetro() {
        RestTemplate restTemplate = new RestTemplate();

        Retro retro = restTemplate.getForObject("http://localhost:8080/retros/15", Retro.class);

        String updateBody = retro.getbody() + "!";

        retro.setbody(updateBody);
        restTemplate.put("http://localhost:8080/retros", retro);
        System.out.println(retro.getName() + "," + retro.getbody());

    }

    @Test
    public void testDelete() {
        RestTemplate restTemplate = new RestTemplate();

        Retro retro = new Retro();
        retro.setName("Test Retro for Delete");
        retro.setbody("This retro is being created so it can be deleted");

        retro = restTemplate.postForObject("http://localhost:8080/retros", retro, Retro.class);
        System.out.println(retro.getId());
        restTemplate.delete("http://localhost:8080/delete/" + retro.getId());
    }
}
