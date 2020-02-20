package com.jinyuwu.practice.dao;

import com.jinyuwu.practice.entity.User;
import com.jinyuwu.practice.user.CrmUser;

public interface UserDao {
    public User findByUserName(String userName);
    public User findByUserId(long id);
    public void update(User user);
    public void save(User user);
}
