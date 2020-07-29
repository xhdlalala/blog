package com.dong.mapper;

import com.dong.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository {
    public List<Tag> findAll();
    public Tag findById(int id);
    public void save(Tag tag);
}
