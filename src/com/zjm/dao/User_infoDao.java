package com.zjm.dao;
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
}
