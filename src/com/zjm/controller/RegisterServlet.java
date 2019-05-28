package com.zjm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.And;
import com.zjm.service.UserService;
import com.zjm.service.serviceImpl.UserServiceImpl;

/**
 * 用户注册
 * @author zjm
 *
 */
public class RegisterServlet extends HttpServlet{
	private UserService us;
	public  RegisterServlet() {
		us=new UserServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		String pwd02 = req.getParameter("password02");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		if(username.length() !=0 && pwd.length() !=0 && pwd02.length() !=0) {
			if(pwd.equals(pwd02)) {
				int insertUsers = us.insertUsers(username, pwd);
				if(insertUsers>0) {
					writer.print("注册成功");
				}else {
					writer.print("用户名以存在");
				}
			}else {
				writer.print("密码不相同");
			}
		}
	}
}
