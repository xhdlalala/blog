package com.dong.controller;

import com.dong.entity.Mapper;
import com.dong.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/mapper")
public class MapperHandler {

    @Autowired
    private MapperService mapperService;

    @GetMapping("/findAll")
    public List<Mapper> findAll(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return mapperService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Mapper mapper,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        mapperService.save(mapper);
    }
}
