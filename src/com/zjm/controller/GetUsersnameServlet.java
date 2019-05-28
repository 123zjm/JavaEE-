package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjm.entity.Users;

/**
 * 获取用户名
 * @author zjm
 *
 */
public class GetUsersnameServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = resp.getWriter();
		HttpSession session = req.getSession();
		Users users = (Users) session.getAttribute("users");
		System.out.println(users);
		String user_name = users.getUser_name();
		writer.print(user_name);
	}
}
