package com.zjm.service.serviceImpl;

import java.util.List;

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

	@Override
	public List<User_info> selectUser_info() {
		// TODO Auto-generated method stub
		List<User_info> selectUser_info=null;
		try {
			selectUser_info = uid.selectUser_info();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUser_info;
	}

	@Override
	public List getUser_type() {
		// TODO Auto-generated method stub
		List selectUser_type =null;
		try {
			selectUser_type = uid.findUsers_type();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUser_type;
	}

	@Override
	public int changeUser_type(String user_name, int user_type)  {
		// TODO Auto-generated method stub
		int updateUser_type=0;
		try {
			updateUser_type = uid.updateUser_type(user_name, user_type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateUser_type;
	}

	@Override
	public int getUser_type(String user_name)  {
		// TODO Auto-generated method stub
		int selectUser_type=0;
		try {
			 selectUser_type = uid.selectUser_type(user_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectUser_type;
	}

	@Override
	public int removeUser_info(String user_name) {
		// TODO Auto-generated method stub
		int delectUser_info=0;
		try {
			delectUser_info = uid.delectUser_info(user_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delectUser_info;
	}

	@Override
	public int changeUser_info(String info_nickname, String info_phone, String info_email, Integer info_gender,
			String info_address) {
		int updateUser_info=0;
		try {
			 updateUser_info = uid.updateUser_info(info_nickname, info_phone, info_email, info_gender, info_address);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateUser_info;
	}
	
}
