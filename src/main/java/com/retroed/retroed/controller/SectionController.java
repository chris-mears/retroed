package com.retroed.retroed.controller;

import com.retroed.retroed.model.Retro;
import com.retroed.retroed.model.Section;
import com.retroed.retroed.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("sectionController")
@RequestMapping("/retros")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = "/{retroId}/sections", method = RequestMethod.GET)
    public @ResponseBody
    List<Section> getSections(@PathVariable(value="retroId") Long retroId) {return  sectionService.getSections(retroId);}

    @RequestMapping(value = "/{retroId}/sections/{id}", method = RequestMethod.GET)
    public @ResponseBody Section getSection(@PathVariable(value="retroId") Long retroId, @PathVariable(value="id") Integer id)
    {return sectionService.getSection(retroId, id);}

    @RequestMapping(value = "/sections", method = RequestMethod.POST)
    public @ResponseBody Section createSection(@RequestBody Section section) { return sectionService.createSection(section);}

    @RequestMapping(value = "/sections", method = RequestMethod.PUT)
    public @ResponseBody Section updateSection(@RequestBody Section section) { return sectionService.updateSection(section); }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
        sectionService.deleteSection(id);
        return null;
    }
}
