package com.zhiyou100.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 本质还是实现 HandlerInterceptor 接口中的方法
// 如果实现接口那么 三个 方法都要实现
// HandlerInterceptorAdapter 实现了 HandlerInterceptor 接口
// 我们创建类继承自 HandlerInterceptorAdapter，就可以选择性重写其中某一个
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 在调用 controller 方法之前调用
		// 返回 true 表示放行，返回 false 表示不放行
		
		boolean result = true;
		
		HttpSession session = request.getSession();
		
		Integer userId = (Integer) session.getAttribute("userId");
	
		if (userId == null) {
			
			// 跨页面传值的 4 种方式：request，session，application，cookie
			// request：必须是同一个请求
			// session：同一个用户
			// application：同一个服务器
			// cookie：需要保存在客户端的数据
			String goodsId = request.getParameter("goodsId");
			
			// 登录成功后还跳转到 goodsId 对应的商品详情页
			session.setAttribute("loginSource", goodsId);
			
			// 重定向到 login.jsp
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			
			// 请求不放行，到这里结束
			result = false;
		}
		
		return result;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// 在调用 controller 方法执行后调用
		// 可以使用 ModelAndView 处理跳转到的页面和携带的数据
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
		// 在响应发送前调用
	}
}
