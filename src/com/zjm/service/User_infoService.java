package com.zjm.service;

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
}
