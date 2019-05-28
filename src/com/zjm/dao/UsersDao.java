package com.zjm.dao;
/**
 * 用户登录，注册数据库接口
 * @author zjm
 *
 */
public interface UsersDao {
	/**
	 * 查询是否存在用户并判断密码是否正确并获取id
	 * @return
	 */
	int selectUsers(String user_name,String user_pwd) throws Exception;
	/**
	 * 添加用户登录信息
	 * @param user_name
	 * @param user_pwd
	 * @param user_type
	 * @return
	 * @throws Exception
	 */
	int insertUsers(String user_name,String user_pwd) throws Exception;
	/**
	 * 查询是否存在用户
	 * @return
	 */
	int selectUsers(String user_name) throws Exception;
}
