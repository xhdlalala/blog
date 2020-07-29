package com.dong.service.impl;

import com.dong.entity.Tag;
import com.dong.mapper.TagRepository;
import com.dong.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(int id) {
        return tagRepository.findById(id);
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }
}
