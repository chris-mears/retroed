package com.retroed.retroed.repository;

import com.retroed.retroed.model.Retro;
import com.retroed.retroed.model.Section;

import java.util.List;

public interface SectionRepository {
    Section createSection(Section section);

    Section getSection(Long retroId, Integer id);

    List<Section> getSections(Long retroId);

    Section updateSection(Section section);

    void deleteSection(Integer id);
}
