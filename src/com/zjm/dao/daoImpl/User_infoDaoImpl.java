package com.zjm.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zjm.dao.User_infoDao;
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

}
