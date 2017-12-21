package com.zhiyou100.service;

import com.zhiyou100.entity.UserDO;

public interface UserService {

	/**
	 * 登录
	 * @param user
	 */
	UserDO login(UserDO user);
}
