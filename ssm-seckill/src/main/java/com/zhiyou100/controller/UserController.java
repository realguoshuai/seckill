package com.zhiyou100.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.entity.UserDO;
import com.zhiyou100.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/login")
	public String login(UserDO user, HttpSession session) {
		
		// 获取登录后的 user 信息
		UserDO dbUser = service.login(user);
		
		// 把 userId 存入 session 作为登录过的标志
		session.setAttribute("userId", dbUser.getId());
		
		// 从 session 中取出登录的来源
		String loginSource = (String) session.getAttribute("loginSource");
		
		if (loginSource == null) {
			
			// 跳转到 list 页面
			return "redirect:/goods/list";
		}else {
			
			// 跳转到来自于的商品页面
			return "redirect:/goods/detail?id=" + loginSource;
		}
	}
}
