package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjm.entity.User_info;
import com.zjm.entity.Users;
import com.zjm.service.User_infoService;
import com.zjm.service.serviceImpl.User_infoServiceImpl;

public class GetUser_InfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		//向页面输出信息处理中文乱码问题
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		//强转获取的对象
		Users users = (Users) session.getAttribute("users");
		String user_name = users.getUser_name();
		User_infoService ui=new User_infoServiceImpl();
		User_info user_info = ui.getUser_info(user_name);
		//利用JSON  将java格式转为js格式
		ObjectMapper omMapper=new ObjectMapper();
		String waString = omMapper.writeValueAsString(user_info);
		writer.print(waString);
//		writer.print(user_info.toString());
//		writer.print(user_info.getInfo_nickname());
//		writer.print(user_info.getInfo_phone());
//		writer.print(user_info.getInfo_address());
//		writer.print(user_info.getInfo_email());
//		writer.print(user_info.getInfo_gender());
	}
}
