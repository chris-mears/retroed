package com.retroed.retroed.repository;

import com.retroed.retroed.model.Retro;

import java.util.List;

public interface RetroRepository {

    List<Retro> getRetros();

    Retro getRetro(Integer id);

    Retro createRetro(Retro retro);
}
