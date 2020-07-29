package com.dong.service;

import com.dong.entity.Article;

import java.text.ParseException;
import java.util.List;

public interface ArticleService {
    public List<Article> findAll();
    public void save(String title,String content);
    public void deleteById(int id);
    public Article findById(int id);
}
