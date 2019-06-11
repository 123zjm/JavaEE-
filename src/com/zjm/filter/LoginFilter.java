package com.zjm.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 登录过滤器
 * @author zjm
 *
 */
public class LoginFilter implements Filter{
	/**
	 * 过滤器销毁方法
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 过滤器过程方法
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//将ServletRequest和ServletResponse强转为http的类型，这样功能将更多，也方便后面接收
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		if(req.getCookies() !=null ) {
				//将拦截的请求发向后端，如果不发生，将会把请求拦截，
				chain.doFilter(req, resp);
		}else {
			PrintWriter writer = resp.getWriter();
			writer.print(0);
		}
	
		
	}
	/**
	 * 过滤器初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
