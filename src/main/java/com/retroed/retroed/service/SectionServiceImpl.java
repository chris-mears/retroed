package com.retroed.retroed.service;


import com.retroed.retroed.model.Retro;
import com.retroed.retroed.model.Section;
import com.retroed.retroed.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sectionService")
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<Section> getSections(Long retroId) {
        return sectionRepository.getSections(retroId);
    }

    @Override
    public Section getSection(Long retroId, Integer id) {
        return sectionRepository.getSection(retroId, id);
    }

    @Override
    public Section createSection(Section section) {
        return sectionRepository.createSection(section);
    }

    @Override
    public Section updateSection(Section section) {
        return sectionRepository.updateSection(section);
    }

    @Override
    public void deleteSection(Integer id) {
        sectionRepository.deleteSection(id);
    }
}
