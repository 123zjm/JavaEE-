package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjm.service.UserService;
import com.zjm.service.serviceImpl.UserServiceImpl;

public class SelectServlet extends HttpServlet{
	private UserService us;
	public  SelectServlet() {
		us=new UserServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("name");
		int selectUsers = us.selectUsers(username);
		PrintWriter writer = resp.getWriter();
		writer.print(selectUsers);
	}
}
