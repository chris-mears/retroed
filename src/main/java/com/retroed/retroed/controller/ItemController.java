package com.retroed.retroed.controller;

import com.retroed.retroed.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("itemController")
public class ItemController {

    @Autowired
    private ItemService itemService;
}
