package com.retroed.retroed.service;


import com.retroed.retroed.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sectionService")
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;
}
