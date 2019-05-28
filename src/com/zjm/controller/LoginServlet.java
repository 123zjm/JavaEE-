package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjm.entity.Users;
import com.zjm.service.UserService;
import com.zjm.service.serviceImpl.UserServiceImpl;

/**
 * web前端登录操作
 * @author zjm
 *
 */
public class LoginServlet extends HttpServlet{
	private UserService us;
	public  LoginServlet() {
		us=new UserServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServletConfig config = getServletConfig();
//		String add = config.getInitParameter("address");
		//页面信息的获取
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		//实例化一个Users对象并赋值
		Users users=new Users();
		users.setUser_name(username);
		users.setUser_pwd(pwd);
		//响应输出
		PrintWriter out= resp.getWriter();
		//通过session进行页面信息的本地储存
		HttpSession session = req.getSession();
		//获取的值
		session.setAttribute("users",users);
		int selectUsers = us.selectUsers(username, pwd);
		//反馈给ajax
		out.write(selectUsers);
	}
	

}
