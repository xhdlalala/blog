package com.dong.controller;

import com.dong.entity.Article;
import com.dong.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleMapperHandler {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/findAll")
    public List<Article> findAll(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return articleService.findAll();
    }

    @PostMapping("/save/{title}/{content}")
    public void save(@PathVariable("title") String title,@PathVariable("content") String content, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,DELETE,GET,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers","X-Requested-With,Content-Type");
        response.setHeader("X-Powered-By","3.2.1");
        articleService.save(title,content);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        articleService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Article findById(@PathVariable("id") int id,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return articleService.findById(id);
    }
}
