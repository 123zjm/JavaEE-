package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjm.entity.Users;
import com.zjm.service.User_infoService;
import com.zjm.service.serviceImpl.User_infoServiceImpl;

public class AdduserServlet extends HttpServlet {
	private User_infoService us;

	public AdduserServlet() {
		us = new User_infoServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面信息
		String info_nickname = req.getParameter("info_nickname");
		String info_phone = req.getParameter("info_phone");
		String info_email = req.getParameter("info_email");
		Integer info_gender = Integer.parseInt(req.getParameter("info_gender"));
		String info_address = req.getParameter("info_address");
		//相应用
		PrintWriter writer = resp.getWriter();
		//向页面输出信息处理中文乱码问题
		resp.setContentType("text/html;charset=utf-8");
		//通过session来进行页面信息储存
		HttpSession session = req.getSession();
		Users users =(Users) session.getAttribute("users");
		if(users==null) {
			resp.sendRedirect("login.html");
		}else {
		String user_name =users.getUser_name();
		Integer user_id=us.getUser_id(user_name);
		//调点判断，并反馈值给ajax
		if (info_nickname.length() != 0 && info_phone.length() != 0 && info_email.length() != 0 && info_gender < 2
				&& info_address.length() != 0) {
			int insertUsers = us.insertUsers(info_nickname, info_phone, info_email, info_gender, info_address, user_id);
			if (insertUsers > 0) {
				writer.print("提交成功");
			} else {
				writer.print("提交失败");
			}
		}
	}
	}
}
