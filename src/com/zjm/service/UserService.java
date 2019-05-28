package com.zjm.service;
/**
 * 用户登录功能接口
 * @author zjm
 *
 */
public interface UserService {
	/**
	 * 用户登录
	 * @return
	 */
	int selectUsers(String user_name,String user_pwd);
	/**
	 * 用户登录注册
	 * @param user_name
	 * @param user_pwd
	 * @param user_type
	 * @return
	 * @throws Exception
	 */
	int insertUsers(String user_name,String user_pwd);
	/**
	 * 用户登录
	 * @return
	 */
	int selectUsers(String user_name);
}
