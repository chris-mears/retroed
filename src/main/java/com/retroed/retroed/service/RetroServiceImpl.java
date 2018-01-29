package com.retroed.retroed.service;

import com.retroed.retroed.model.Retro;
import com.retroed.retroed.repository.RetroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("retroService")
public class RetroServiceImpl implements RetroService {

    @Autowired
    private RetroRepository retroRepository;

    @Override
    public List<Retro> getRetros() {return retroRepository.getRetros(); }


    @Override
    public Retro getRetro(Integer id) {
        return retroRepository.getRetro(id);
    }

    @Override
    public Retro createRetro(Retro retro) {
        return retroRepository.createRetro(retro);
    }

    @Override
    public Retro updateRetro(Retro retro) {
        return retroRepository.updateRetro(retro);
    }
}
