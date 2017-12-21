package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhiyou100.dao.GoodsDao;
import com.zhiyou100.dao.UserGoodsDao;
import com.zhiyou100.dto.GoodsListDTO;
import com.zhiyou100.entity.GoodsDO;
import com.zhiyou100.entity.UserGoodsDO;
import com.zhiyou100.service.GoodsService;
import com.zhiyou100.service.exception.SeckillException;
import com.zhiyou100.vo.GoodsListQueryVO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private UserGoodsDao userGoodsDao;
	
	public GoodsListDTO listGoods(GoodsListQueryVO vo) {

		GoodsListDTO dto = new GoodsListDTO();
		
		// 获取查询数据总条数
		int count = goodsDao.countGoods(vo);
		
		// 只有结果总数为 0 的时候才需要进行查询
		if (count != 0) {
			
			// 总页数
			int pageCount = (count + 4) / 5;
			
			dto.setPageCount(pageCount);
			
			// 如果没有输入页码，页码设置为 1
			if (vo.getPageIndex() == null || vo.getPageIndex() <= 0) {
				
				vo.setPageIndex(1);
			}
			
			// 如果页码超过了最后一页，页码设置为最后一页
			if (vo.getPageIndex() > pageCount) {
				
				vo.setPageIndex(pageCount);
			}
			
			dto.setPageIndex(vo.getPageIndex());
			
			// 查询结果
			List<GoodsDO> list = goodsDao.listGoods(vo);
			
			dto.setList(list);
		}
		
		return dto;
	}

	public GoodsDO getGoods(int id) {

		return goodsDao.getGoods(id);
	}

	@Transactional
	public void seckillGoods(UserGoodsDO userGoods) {
		
		int resultCount = goodsDao.subGoodsCount(userGoods.getGoodsId(), userGoods.getCount());
		
		if (resultCount == 0) {
			
			throw new SeckillException("商品剩余数量不足");
		}
		
		resultCount = userGoodsDao.addUserGoods(userGoods);
		
		if (resultCount == 0) {
			
			throw new SeckillException("每种商品只能购买一次");
		}
	}
}
