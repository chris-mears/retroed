package com.retroed.retroed.service;

import com.retroed.retroed.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems(Long sectionId);

    Item getItem(Long sectionId, Integer id);

    Item createItem(Item item);

    Item updateItem(Item item);

    void deleteItem(Integer id);
}
