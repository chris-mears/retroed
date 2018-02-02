package com.retroed.retroed.controller;

import com.retroed.retroed.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("sectionController")
public class SectionController {

    @Autowired
    private SectionService sectionService;
}
