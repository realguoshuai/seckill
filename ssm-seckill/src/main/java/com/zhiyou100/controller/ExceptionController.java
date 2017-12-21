package com.zhiyou100.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zhiyou100.service.exception.LoginException;
import com.zhiyou100.service.exception.SeckillException;


// @ControllerAdvice 设置当前类为异常处理类
// 可以在这个类中统一处理 controller 层产生的所有异常
// 1. 统一处理异常
// 2. 避免大量的 try-catch
@ControllerAdvice
public class ExceptionController  {

	// @ExceptionHandler 绑定异常和处理方法
	// @ExceptionHandler({class1, class2,...})
	// 如果 () 不写内容，就是处理所有的异常 == ({Exception.class})
//	@ExceptionHandler
//	public String exception(Exception e, Model model) {
//		
//		model.addAttribute("errorMessage", e.getMessage());
//		
//		// 如果没有 forward 或者 redirect 关键字，那么会自动拼接前后缀
//		return "error";
//	}
	
	// 登录的异常需要在 login.jsp 展示，秒杀的异常需要在 error.jsp 展示
	// 所以两种异常需要分开处理
	
	@ExceptionHandler(SeckillException.class)
	public String seckillException(SeckillException e, Model model) {
	
		model.addAttribute("errorMessage", e.getMessage());
		
		return "error";
	}
	
	@ExceptionHandler(LoginException.class)
	public String loginException(LoginException e, Model model) {
		
		model.addAttribute("errorMessage", e.getMessage());
		
		return "forward:/login.jsp";
	}
	
}





