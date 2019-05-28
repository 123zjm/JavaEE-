package com.zjm.service.serviceImpl;

import com.zjm.dao.UsersDao;
import com.zjm.dao.daoImpl.UsersDaoImpl;
import com.zjm.service.UserService;

public class UserServiceImpl implements UserService{
	private UsersDao ud;
	public UserServiceImpl() {
		ud =new UsersDaoImpl();
	}
	@Override
	public int selectUsers(String user_name, String user_pwd) {
		// TODO Auto-generated method stub
		int selectUsers=0;
		try {
			selectUsers = ud.selectUsers(user_name, user_pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUsers;
	}
	@Override
	public int insertUsers(String user_name, String user_pwd) {
		// TODO Auto-generated method stub
		int insertUsers=0;
		
		try {
			if(ud.selectUsers(user_name) > 0) {
				insertUsers = ud.insertUsers(user_name, user_pwd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertUsers;
	}
	@Override
	public int selectUsers(String user_name) {
		// TODO Auto-generated method stub
		int selectUsers=0;
		try {
			selectUsers = ud.selectUsers(user_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUsers;

	}
	
}
