package com.retroed.retroed.controller;

import com.retroed.retroed.model.Item;
import com.retroed.retroed.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("itemController")
@RequestMapping("/sections")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping(value = "/{sectionId}/items", method = RequestMethod.GET)
    public @ResponseBody
    List<Item> getItems(@PathVariable(value="sectionId") Long sectionId) {return  itemService.getItems(sectionId);}

    @RequestMapping(value = "/{sectionId}/items/{id}", method = RequestMethod.GET)
    public @ResponseBody Item getItem(@PathVariable(value="sectionId") Long sectionId, @PathVariable(value="id") Integer id)
    {return itemService.getItem(sectionId, id);}

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public @ResponseBody Item createItem(@RequestBody Item item) { return itemService.createItem(item);}

    @RequestMapping(value = "/sections", method = RequestMethod.PUT)
    public @ResponseBody Item updateSection(@RequestBody Item item) { return itemService.updateItem(item); }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
        itemService.deleteItem(id);
        return null;
    }
}
