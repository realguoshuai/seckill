package com.zhiyou100.service;

import com.zhiyou100.dto.GoodsListDTO;
import com.zhiyou100.entity.GoodsDO;
import com.zhiyou100.entity.UserGoodsDO;
import com.zhiyou100.vo.GoodsListQueryVO;

public interface GoodsService {

	/**
	 * 获取所有可用的商品信息
	 * @return
	 */
	GoodsListDTO listGoods(GoodsListQueryVO vo);
	
	/**
	 * 获取指定商品的信息
	 * @param id 商品 id
	 * @return
	 */
	GoodsDO getGoods(int id);
	
	/**
	 * 秒杀商品
	 * @param goodsId 商品 id
	 * @param count 商品数量
	 * @param userId 用户 id
	 */
	void seckillGoods(UserGoodsDO userGoodsDO);
}
