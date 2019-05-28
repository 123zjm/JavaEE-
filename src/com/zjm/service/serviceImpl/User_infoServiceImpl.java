package com.zjm.service.serviceImpl;

import com.zjm.dao.User_infoDao;
import com.zjm.dao.daoImpl.User_infoDaoImpl;
import com.zjm.entity.User_info;
import com.zjm.service.User_infoService;

public class User_infoServiceImpl implements User_infoService{
	private User_infoDao uid;
	public  User_infoServiceImpl() {
		uid =new User_infoDaoImpl();
	}

	@Override
	public int insertUsers(String info_nickname, String info_phone, String info_email, Integer info_gender,
			String info_address, Integer user_id) {
		// TODO Auto-generated method stub
		int insertUsers=0;
		try {
			insertUsers = uid.insertUsers(info_nickname, info_phone, info_email, info_gender, info_address, user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertUsers;
	}

	@Override
	public int getUser_id(String user_name) {
		// TODO Auto-generated method stub
		int selectUser_id=0;
		try {
			selectUser_id = uid.selectUser_id(user_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUser_id;
	}

	@Override
	public User_info getUser_info(String user_name) {
		// TODO Auto-generated method stub
		User_info selectUser_info=null;
		try {
			selectUser_info = uid.selectUser_info(user_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUser_info;
	}
	
}
