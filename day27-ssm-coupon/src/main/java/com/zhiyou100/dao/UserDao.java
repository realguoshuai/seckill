package com.zhiyou100.dao;

import com.zhiyou100.entity.UserDO;

public interface UserDao {

	/**
	 * 根据 email 找用户信息
	 * @param email
	 * @return
	 */
	UserDO getUserByEmail(String email);
}
