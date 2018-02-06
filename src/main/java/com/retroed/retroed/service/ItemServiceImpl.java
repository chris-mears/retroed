package com.retroed.retroed.service;


import com.retroed.retroed.model.Item;
import com.retroed.retroed.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getItems(Long sectionId) {
        return itemRepository.getItems(sectionId);
    }

    @Override
    public Item getItem(Long sectionId, Integer id) {
        return itemRepository.getItem(sectionId, id);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.createItem(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.updateItem(item);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.deleteItem(id);
    }
}
