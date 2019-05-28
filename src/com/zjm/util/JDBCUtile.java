package com.zjm.util;
/**
 * JDBC工具类
 * @author zjm
 *
 */

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtile {
//	public static final String DRIVERNAME="com.mysql.jdbc.Driver";
//	public static final String MYSQL_URL="jdbc:mysql://localhose:3306/stdb/?useUnicode=true&characterEncoding=UTF-8";
//	public static final String USER="root";
//	public static final String PASSWORD="123456";
	private static ComboPooledDataSource ds;
	
	static {
//		try {
//			Class.forName(DRIVERNAME);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ds=new ComboPooledDataSource();
	}
	/**
	 * 
	 * @return Connection 数据库连接
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException {
//		Connection con=null;
//		try {
//			 con = DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
        return ds.getConnection();
	}
	/**
	 *  释放资源
	 * @param rs   结果集
	 * @param psta  执行平台
	 * @param conn  数据库连接
	 */
	public static void closeAll(ResultSet rs,PreparedStatement psta,Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
