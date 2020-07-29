package com.dong.service.impl;

import com.dong.mapper.ArticleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class ArticleServiceImplTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void test(){
        System.out.println(new Date());
    }

}
