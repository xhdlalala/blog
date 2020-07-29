package com.dong.mapper;

import com.dong.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void update(User user);
    public void deleteById(int id);
    public int count();
    public User findByName(String name);
}
