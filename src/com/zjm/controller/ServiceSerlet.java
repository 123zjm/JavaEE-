package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjm.entity.User_info;
import com.zjm.service.User_infoService;
import com.zjm.service.serviceImpl.User_infoServiceImpl;

/**
 * ajax接受用户操作全
 * @author zjm
 *
 */
public class ServiceSerlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		//获取请求路径
		String uri = req.getRequestURI();
		//截取字符串     获取操作请求     （web中  <url-pattern>/ny</url-pattern>的值）
		String operation=uri.substring(uri.lastIndexOf("/")+1,uri.length());
		//条件判断返回不同的值
		if("table".equals(operation)) {
			User_infoService ui=new User_infoServiceImpl();
			List<User_info> selectUser_info = ui.selectUser_info();
			StringBuffer sb=new StringBuffer();
			//ObjectMapper (调用JSON的类的前置)
			ObjectMapper om=new ObjectMapper();
			//利用JSON  将java格式转为js格式
			String jsnList = om.writeValueAsString(selectUser_info);
			sb.append("{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":");
			sb.append(jsnList);
			sb.append("}");
			System.out.println(sb.toString());
			resp.setContentType("text/html;charset=utf-8");
			writer.print(sb);
		}
	}
}	
