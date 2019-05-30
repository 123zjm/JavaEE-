package com.zjm.service;

import java.util.List;

import com.zjm.entity.User_info;

public interface User_infoService {
	/**
	 * 用户提交信息操作
	 * @param info_nickname
	 * @param info_phone
	 * @param info_email
	 * @param info_gender
	 * @param info_address
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	int insertUsers(String info_nickname,String info_phone,String info_email,Integer info_gender,String info_address,Integer user_id);
	/**
	 * 获得用户id
	 * @param user_name
	 * @return
	 */
	int getUser_id(String user_name);
	/**
	 * 获取指定用户的信息
	 * @param user_name
	 * @return
	 * @throws Exception
	 */
	User_info getUser_info(String user_name);
	/**
	 * 获取全部用户的信息功能的接口
	 * @param user_name
	 * @return
	 * @throws Exception
	 */
	List<User_info> selectUser_info();
	/**
	 * 获取用户状态
	 * @return
	 */
	List  getUser_type();
	
	/**
	 * 更改用户状态
	 * @return
	 * @throws Exception
	 */
	int changeUser_type(String user_name,int user_type) ;
	/**
	 * 查询用户状态
	 * @return
	 * @throws Exception
	 */
	int getUser_type(String user_name) ;
}
