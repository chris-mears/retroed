package com.retroed.retroed.controller;

import org.testng.annotations.*;
import com.retroed.retroed.model.Retro;
import com.retroed.retroed.model.Section;
import com.retroed.retroed.util.RetroRowMapper;
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

    @BeforeTest
    public void getRetro() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Retro>> retroResponse = restTemplate.exchange(
                "http://localhost:8080/retros/?name=Section", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Retro>>() {
                });
        List<Retro> retros = retroResponse.getBody();
        retro = retros.get(2);
    }

    @Test
    public void testGetSections() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Section>> sectionResponse = restTemplate.exchange(
                "http://localhost:8080/retros/" + retro.getId() + "/sections", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Section>>() {
                });
        List<Section> sections = sectionResponse.getBody();

        for(Section section : sections)
            System.out.println(section.toString());
    }

    @Test
    public void testGetSection() {
        RestTemplate restTemplate = new RestTemplate();
        Section section = restTemplate.getForObject("http://localhost:8080/retros/" + retro.getId() + "/sections/29", Section.class);

        assertEquals("Test Section for getSection", section.getTitle());
        System.out.println(section.toString());
    }

    @Test
    public void testCreateSection() {
        RestTemplate restTemplate = new RestTemplate();

        Section section = new Section();
        section.setTitle("Test Section 4");
        section.setNotes("Test notes for section");
        section.setRetroId(retro.getId());


        Section responseSection = restTemplate.postForObject("http://localhost:8080/retros/sections", section, Section.class);
        System.out.println(responseSection.getTitle() + ", " + responseSection.getId() + ", " + responseSection.getRetroId());
    }

    @Test
    public void testUpdateSection() {
        RestTemplate restTemplate = new RestTemplate();

        Section section = restTemplate.getForObject("http://localhost:8080/retros/" + retro.getId() + "/sections/29", Section.class);

        String updateNotes = section.getNotes() + " Updated!";

        section.setNotes(updateNotes);
        restTemplate.put("http://localhost:8080/retros/sections", section);
        System.out.println(section.getTitle() + "," + section.getNotes());
    }

    @Test
    public void testDelete() {
        RestTemplate restTemplate = new RestTemplate();

        Section section = new Section();
        section.setRetroId(retro.getId());
        section.setTitle("Test Section for Delete");
        section.setNotes("This section is being created so it can be deleted");

        section = restTemplate.postForObject("http://localhost:8080/retros/sections", section, Section.class);
        System.out.println(section.getId());
        restTemplate.delete("http://localhost:8080/retros/delete/" + section.getId());
    }
}
