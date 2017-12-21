package com.zhiyou100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zhiyou100.dto.GoodsListDTO;
import com.zhiyou100.entity.GoodsDO;
import com.zhiyou100.entity.UserGoodsDO;
import com.zhiyou100.service.GoodsService;
import com.zhiyou100.vo.GoodsListQueryVO;

@Controller
public class GoodsController {

	
	@Autowired
	private GoodsService goodService;
	
	@RequestMapping("/goods/list")
	public String listGoods(GoodsListQueryVO vo, Model model) {
		
		GoodsListDTO dto = goodService.listGoods(vo);
		
		model.addAttribute("dto", dto);
		
		return "forward:/WEB-INF/goods/list.jsp";
	}
	
	@RequestMapping("/goods/detail")
	public String getGoods(int id, Model model) {
		
		GoodsDO goods = goodService.getGoods(id);
		
		model.addAttribute("goods", goods);
		
		return "forward:/WEB-INF/goods/detail.jsp";
	}
	
	@RequestMapping("/goods/seckill")
	public String seckillGoods(Integer goodsId, Integer count, @SessionAttribute String userId) {
		
		UserGoodsDO userGoods = new UserGoodsDO();
		
		userGoods.setUserId(Integer.parseInt(userId));
		userGoods.setGoodsId(goodsId);
		userGoods.setCount(count);
		
		goodService.seckillGoods(userGoods);
		
		return "redirect:/goods/list";
	}
}
