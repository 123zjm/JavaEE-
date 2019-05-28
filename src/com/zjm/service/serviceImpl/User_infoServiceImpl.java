package com.zjm.service.serviceImpl;

import com.zjm.dao.User_infoDao;
import com.zjm.dao.daoImpl.User_infoDaoImpl;
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
	
}
