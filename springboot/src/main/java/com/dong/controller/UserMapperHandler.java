package com.dong.controller;

import com.dong.entity.User;
import com.dong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserMapperHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return userService.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        return userService.findById(id);
    }

    @PutMapping("/check/{name}/{password}")
    public String check(@PathVariable("name") String name,@PathVariable("password") String password,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,DELETE,GET,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers","X-Requested-With,Content-Type");
        response.setHeader("X-Powered-By","3.2.1");
        return String.valueOf(userService.check(name,password));
    }
}
