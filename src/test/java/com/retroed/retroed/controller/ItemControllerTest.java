package com.retroed.retroed.controller;

import com.retroed.retroed.model.Item;
import com.retroed.retroed.model.Section;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemControllerTest {
    Section section = new Section();

    @BeforeTest
    public void getSection() {
        RestTemplate restTemplate = new RestTemplate();

        section = restTemplate.getForObject("http://localhost:8080/retros/25/sections/29", Section.class);
    }

    @Test
    public void testGetItems() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Item>> itemsResponse = restTemplate.exchange(
                "http://localhost:8080/sections/" + section.getId() + "/items", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Item>>() {
                });
        List<Item> items = itemsResponse.getBody();

        for(Item item : items)
            System.out.println(item.toString());
    }

    @Test
    public void testGetItem() {
        RestTemplate restTemplate = new RestTemplate();
        Item item = restTemplate.getForObject("http://localhost:8080/sections/" + section.getId() + "/items/20", Item.class);

        assertEquals("Task for Testing", item.getTitle());
        System.out.println(item.toString());
    }

    @Test
    public void testCreateItem() {
        RestTemplate restTemplate = new RestTemplate();
        Date date = new Date(118, 1, 28);



        Item item = new Item();
        item.setTitle("Test Item 1");
        item.setBody("Test item for items");
        item.setRetroId(section.getRetroId());
        item.setSectionId(section.getId());
        item.setType("task");
        item.setDueDate(date);


        Item responseItem = restTemplate.postForObject("http://localhost:8080/sections/items", item, Item.class);
        System.out.println(responseItem.getTitle() + ", " + responseItem.getId() + ", " + responseItem.getRetroId());
    }

    @Test
    public void testUpdateItem() {
        RestTemplate restTemplate = new RestTemplate();

        Item item = restTemplate.getForObject("http://localhost:8080/sections/" + section.getId() + "/items/20", Item.class);

        String updateBody = item.getBody() + " Updated!";

        item.setBody(updateBody);
        restTemplate.put("http://localhost:8080/sections/items", item);
        System.out.println(item.getTitle() + "," + item.getBody());
    }

    @Test
    public void testDelete() {
        RestTemplate restTemplate = new RestTemplate();
        Date date = new Date(2018, 2, 8);

        Item item = new Item();
        item.setSectionId(section.getId());
        item.setRetroId(section.getRetroId());
        item.setTitle("Test Item for Delete");
        item.setBody("This Item is being created so it can be deleted");
        item.setType("note");
        item.setDueDate(date);

        item = restTemplate.postForObject("http://localhost:8080/sections/items", item, Item.class);
        System.out.println(item.getId());
        restTemplate.delete("http://localhost:8080/sections/delete/" + item.getId());
    }
}
