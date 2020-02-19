package com.jinyuwu.practice.dao;

import com.jinyuwu.practice.entity.User;

public interface UserDao {
    public User findByUserName(String userName);
    public User findByUserId(long id);
    public void save(User user);
}
