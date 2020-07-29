package com.dong.mapper;

import com.dong.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {
    public List<Article>findAll();
    public void save(Article article);
    public void deleteById(int id);
    public Article findById(int id);
}
