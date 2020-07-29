package com.dong.service.impl;

import com.dong.entity.Mapper;
import com.dong.mapper.MapperRepository;
import com.dong.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperServiceImpl implements MapperService {

    @Autowired
    private MapperRepository mapperRepository;

    @Override
    public List<Mapper> findAll() {
        return mapperRepository.findAll();
    }

    @Override
    public void save(Mapper mapper) {
        mapperRepository.save(mapper);
    }
}
