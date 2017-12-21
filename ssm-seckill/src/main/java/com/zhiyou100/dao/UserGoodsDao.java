package com.zhiyou100.dao;

import com.zhiyou100.entity.UserGoodsDO;

public interface UserGoodsDao {

	/**
	 * 添加一条购买记录
	 * @param userGoods 记录信息
	 * @return 添加结果，1 表示添加成功，0 表示添加失败
	 */
	int addUserGoods(UserGoodsDO userGoods);
}
