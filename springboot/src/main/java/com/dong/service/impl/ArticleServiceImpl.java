package com.dong.service.impl;

import com.dong.entity.Article;
import com.dong.mapper.ArticleRepository;
import com.dong.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void save(String title,String content){
        Article article=new Article();
        article.setContent(content);
        article.setTitle(title);
        Date date=new Date();
        article.setCreateDate(new Timestamp(date.getTime()));
        articleRepository.save(article);
    }

    @Override
    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }
}
