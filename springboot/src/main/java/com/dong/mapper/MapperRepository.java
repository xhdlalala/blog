package com.dong.mapper;

import com.dong.entity.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapperRepository {
    public List<Mapper> findAll();
    public void save(Mapper mapper);
}
