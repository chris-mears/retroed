package com.retroed.retroed.controller;

import com.retroed.retroed.model.Retro;
import com.retroed.retroed.service.RetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("retroController")
public class RetroController {

    @Autowired
    private RetroService retroService;

    @RequestMapping(value = "/retros", method = RequestMethod.GET)
    public @ResponseBody List<Retro> getRetros() {return  retroService.getRetros();}

    @RequestMapping(value = "/retros/{id}", method = RequestMethod.GET)
    public @ResponseBody Retro getRetro(@PathVariable(value="id") Integer id) {return retroService.getRetro(id);}

    @RequestMapping(value = "/retro", method = RequestMethod.GET)
    public @ResponseBody List<Retro> getRetroByOption(@RequestParam(value = "name") String value)
    { return retroService.getRetroByOption(value);}

    @RequestMapping(value = "/retros", method = RequestMethod.POST)
    public @ResponseBody Retro createRetro(@RequestBody Retro retro) { return retroService.createRetro(retro);}

    @RequestMapping(value = "/retros", method = RequestMethod.PUT)
    public @ResponseBody Retro updateRetro(@RequestBody Retro retro) { return retroService.updateRetro(retro); }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
        retroService.deleteRetro(id);
        return null;
    }
}
