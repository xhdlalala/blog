package com.dong.service;

import com.dong.entity.Mapper;

import java.util.List;

public interface MapperService {
    public List<Mapper> findAll();
    public void save(Mapper mapper);
}
