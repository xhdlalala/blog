package com.dong.controller;

import com.dong.entity.Tag;
import com.dong.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagHandler {

    @Autowired
    private TagService tagService;

    @GetMapping("/findAll")
    public List<Tag> findAll(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return tagService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Tag findById(@PathVariable("id") int id,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return tagService.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Tag tag,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        tagService.save(tag);
    }

}
