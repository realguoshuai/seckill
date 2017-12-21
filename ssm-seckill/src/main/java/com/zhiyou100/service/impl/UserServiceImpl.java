package com.zhiyou100.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.entity.UserDO;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.exception.LoginException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserDO login(UserDO user) {

		UserDO dbUser = userDao.getUserByEmail(user.getEmail());
		
		if (dbUser == null) {
			
			throw new LoginException("账号不存在");
		}
		
		if (!dbUser.getPassword().equals(user.getPassword())) {
			
			throw new LoginException("密码错误");
		}
		
		return dbUser;
	}
}
