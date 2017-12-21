package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.GoodsDO;
import com.zhiyou100.vo.GoodsListQueryVO;

public interface GoodsDao {

	/**
	 * 获取所有可用的商品信息
	 * @return
	 */
	List<GoodsDO> listGoods(GoodsListQueryVO vo);
	
	/**
	 * 获取所有可用的商品信息的总数
	 * @param vo
	 * @return
	 */
	int countGoods(GoodsListQueryVO vo);
	
	/**
	 * 获取指定商品的信息
	 * @param id 商品 id
	 * @return
	 */
	GoodsDO getGoods(int id);
	
	/**
	 * 减少指定商品的剩余数量
	 * @param id 商品 id
	 * @param count 需要削减的数量
	 * @return 削减是否成功，1 表示成功，0 表示失败
	 */
	int subGoodsCount(int id, int count);
}
