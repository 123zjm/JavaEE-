package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjm.service.UserService;
import com.zjm.service.serviceImpl.UserServiceImpl;

/**
 * web前端登录操作
 * @author zjm
 *
 */
public class LoginServlet extends HttpServlet{
	private UserService us;
	private static Integer user_id;
	public  LoginServlet() {
		us=new UserServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServletConfig config = getServletConfig();
//		String add = config.getInitParameter("address");
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		PrintWriter out= resp.getWriter();
		int selectUsers = us.selectUsers(username, pwd);
		out.write(selectUsers);
	}
	
	public static Integer getUser_id() {
		return user_id;
	}
	
}
