package com.dong.service;

import com.dong.entity.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> findAll();
    public Tag findById(int id);
    public void save(Tag tag);
}
