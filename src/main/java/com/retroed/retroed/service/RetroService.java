package com.retroed.retroed.service;

import com.retroed.retroed.model.Retro;

import java.util.List;

public interface RetroService {

    List<Retro> getRetros();

    Retro getRetro(Integer id);

    Retro createRetro(Retro retro);
}
