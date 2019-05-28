package com.zjm.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zjm.dao.UsersDao;
import com.zjm.util.JDBCUtile;

public class UsersDaoImpl implements UsersDao {

	@Override
	public int selectUsers(String user_name,String user_pwd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("SELECT user_id FROM users WHERE user_name=? and user_pwd=?");
		pste.setString(1, user_name);
		pste.setString(2, user_pwd);
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
	public int insertUsers(String user_name, String user_pwd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtile.getConn();
		PreparedStatement pste = conn.prepareStatement("INSERT INTO users VALUES(null,?,?,NULL);");
		pste.setString(1, user_name);
		pste.setString(2, user_pwd);
		int eu = pste.executeUpdate();
		JDBCUtile.closeAll(null, pste, conn);
		return eu;
	}

	@Override
	public int selectUsers(String user_name) throws Exception {
		// TODO Auto-generated method stub
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

}
