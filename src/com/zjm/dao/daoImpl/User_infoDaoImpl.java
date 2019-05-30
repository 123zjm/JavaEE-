package com.zjm.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zjm.dao.User_infoDao;
import com.zjm.entity.User;
import com.zjm.entity.User_info;
import com.zjm.util.JDBCUtile;

public class User_infoDaoImpl implements User_infoDao{

	@Override
	public int insertUsers(String info_nickname, String info_phone, String info_email, Integer info_gender,
			String info_address, Integer user_id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("INSERT INTO user_info VALUES(null,?,?,?,?,?,?);");
		pste.setString(1, info_nickname);
		pste.setString(2, info_phone);
		pste.setString(3, info_email);
		pste.setInt(4, info_gender);
		pste.setString(5, info_address);
		pste.setInt(6, user_id);
		int eu = pste.executeUpdate();
		JDBCUtile.closeAll(null, pste, conn);
		return eu;
	}

	@Override
	public int selectUser_id(String user_name) throws Exception {
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("SELECT user_id FROM users WHERE user_name=? ");
		pste.setString(1, user_name);
		ResultSet rs = pste.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("user_id");
			JDBCUtile.closeAll(rs, pste, conn);
			return id;
		}
		JDBCUtile.closeAll(rs, pste, conn);
		return 0;
	}

	@Override
	public User_info selectUser_info(String user_name) throws Exception {
		Connection conn = JDBCUtile.getConn();
		int selectUser_id = this.selectUser_id(user_name);
		PreparedStatement pste = conn.prepareStatement("SELECT * FROM user_info WHERE user_id=? ");
		pste.setInt(1, selectUser_id);
		ResultSet rs = pste.executeQuery();
		User_info uiInfo=new User_info();
		if(rs.next()) {
			uiInfo.setInfo_address(rs.getString("info_address"));
			uiInfo.setInfo_email(rs.getString("info_email"));
			uiInfo.setInfo_gender(rs.getInt("info_gender"));
			uiInfo.setInfo_nickname(rs.getString("info_nickname"));
			uiInfo.setInfo_phone(rs.getString("info_phone"));
			JDBCUtile.closeAll(rs, pste, conn);
			return uiInfo;
		}
		JDBCUtile.closeAll(rs, pste, conn);
		return uiInfo;
	}

	@Override
	public List<User_info> selectUser_info() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("SELECT * FROM user_info");
		ResultSet rs = pste.executeQuery();
		User_info uiInfo=null;
		List<User_info> li =new ArrayList<User_info>();
		while(rs.next()) {
			uiInfo=new User_info();
			uiInfo.setInfo_address(rs.getString("info_address"));
			uiInfo.setInfo_email(rs.getString("info_email"));
			uiInfo.setInfo_gender(rs.getInt("info_gender"));
			uiInfo.setInfo_nickname(rs.getString("info_nickname"));
			uiInfo.setInfo_phone(rs.getString("info_phone"));
			li.add(uiInfo);
		}
		JDBCUtile.closeAll(rs, pste, conn);
		return li;
	}

	@Override
	public List findUsers_type() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("SELECT  ui.info_address,ui.info_email,ui.info_gender,ui.info_nickname,ui.info_phone,us.user_type FROM users us RIGHT JOIN user_info ui on us.user_id=ui.user_id");
		ResultSet rs = pste.executeQuery();
		List li =new ArrayList();
		User us=null;
		while (rs.next()) {
			us=new User();
			us.setInfo_address(rs.getString("info_address"));
			us.setInfo_email(rs.getString("info_email"));
			us.setInfo_gender(rs.getInt("info_gender"));
			us.setInfo_nickname(rs.getString("info_nickname"));
			us.setInfo_phone(rs.getString("info_phone"));
			us.setUser_type(rs.getInt("user_type"));
			li.add(us);
		
		}
		JDBCUtile.closeAll(rs, pste, conn);
		return li;
	}

	@Override
	public int updateUser_type(String user_name,int user_type) throws Exception {
		Connection conn = JDBCUtile.getConn();
		if(user_type == 0) {
			user_type =1;
		}else {
			user_type =0;
		}
		PreparedStatement pste = conn.prepareStatement("UPDATE users  SET  user_type=? WHERE user_id=(select user_id from user_info where info_nickname = ?)");
		pste.setInt(1, user_type);
		pste.setString(2, user_name);
		int eu = pste.executeUpdate();
		JDBCUtile.closeAll(null, pste, conn);
		return eu;
	}

	@Override
	public int selectUser_type(String user_name) throws Exception {
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("SELECT user_type FROM users where user_id=(select user_id from user_info where info_nickname = ?)");
		pste.setString(1, user_name);
		ResultSet rs = pste.executeQuery();
		int a=0;
		if (rs.next()) {
			a=rs.getInt("user_type");
		}
		JDBCUtile.closeAll(rs, pste, conn);
		return a;
	}

}
