package com.jinyuwu.practice.service;

import com.jinyuwu.practice.entity.User;
import com.jinyuwu.practice.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public User findByUserId(long id);

	public void save(CrmUser crmUser);
}
