package com.zjm.dao;

import java.util.List;

import com.zjm.entity.User_info;

/**
 * 用户提交信息数据库接口
 * @author zjm
 *
 */
public interface User_infoDao {
	/**
	 * 将用户提交信息储存进数据库
	 * @param info_nickname
	 * @param info_phone
	 * @param info_email
	 * @param info_gender
	 * @param info_address
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	int insertUsers(String info_nickname,String info_phone,String info_email,Integer info_gender,String info_address,Integer user_id) throws Exception;
	/**
	 * 获得用户id数据库接口
	 * @param user_name
	 * @return
	 */
	int selectUser_id(String user_name)throws Exception;
	/**
	 * 获取指定用户的信息的数据接口
	 * @param user_name
	 * @return
	 * @throws Exception
	 */
	User_info selectUser_info(String user_name)throws Exception;
	/**
	 * 获取全部用户的信息的数据接口
	 * @param user_name
	 * @return
	 * @throws Exception
	 */
	List<User_info> selectUser_info()throws Exception;
	/**
	 * 获取用户的状态
	 * @return
	 * @throws Exception
	 */
	List findUsers_type(int size) throws Exception;
	/**
	 * 更改用户状态
	 * @return
	 * @throws Exception
	 */
	int updateUser_type(String user_name,int user_type) throws Exception;
	/**
	 * 查询用户状态
	 * @return
	 * @throws Exception
	 */
	int selectUser_type(String user_name) throws Exception;
	/**
	 * 删除用户
	 * @param user_name
	 * @return
	 * @throws Exception
	 */
	int delectUser_info(String user_name)throws Exception;
	/**
	 * 更改用户
	 * @param info_nickname
	 * @param info_phone
	 * @param info_email
	 * @param info_gender
	 * @param info_address
	 * @return
	 * @throws Exception
	 */
	int updateUser_info(String info_nickname,String info_phone,String info_email,Integer info_gender,String info_address)throws Exception;
	/**
	 * 获取页码
	 * @return
	 * @throws Exception
	 */
	int selectPageSize()throws Exception;
}
