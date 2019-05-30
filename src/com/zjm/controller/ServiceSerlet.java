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
		//中文乱码
		resp.setHeader("content-type","text/html;charset=UTF-8");
		User_infoService ui=new User_infoServiceImpl();
		//ObjectMapper (调用JSON的类的)
		ObjectMapper om=new ObjectMapper();
		//获取请求路径
		String uri = req.getRequestURI();
		//截取字符串     获取操作请求     （web中  <url-pattern>/ny</url-pattern>的值）
		String operation=uri.substring(uri.lastIndexOf("/")+1,uri.length());
		//条件判断返回不同的值
		if("find".equals(operation)) {
			List<User_info> selectUser_info = ui.selectUser_info();
			StringBuffer sb=new StringBuffer();
			//利用JSON(轻量级数据交换格式)  将java格式转为js格式 
			String jsnList = om.writeValueAsString(selectUser_info);
//			sb.append("{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":");使用layui框架是用
			sb.append(jsnList);
//			sb.append("}");使用layui框架时用
			
			writer.print(sb);
		}else if ("get".equals(operation)) {
			List user_type = ui.getUser_type();
			
			String jsnList = om.writeValueAsString(user_type);

			writer.print(jsnList);
		}else if ("change".equals(operation)) {
			String user_name = req.getParameter("username");
			int user_type = ui.getUser_type(user_name);
			int changeUser_type = ui.changeUser_type(user_name, user_type);
		}
	}
}	
