package com.dong.service;

import com.dong.entity.User;
import com.dong.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id){
        return userRepository.findById(id);
    }

    public boolean check(String name,String password){
        User user=userRepository.findByName(name);
        if(user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
