package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	@SuppressWarnings("finally")
	public static int check(LoginData logindata) {
		
		int flag = 0;
		String userName = logindata.uname;
		String passWord = logindata.upwd;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库驱动器成功注册到驱动管理类当中");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载失败了");
			return -1;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/blog?serverTimezone=UTC","root","14999");
			System.out.println("连接成功");
			ps = conn.prepareStatement("select userName,passWord from tb_user");
			rs =ps.executeQuery();
			System.out.println("输出 rs.......................");
			
			System.out.println("接受前端数据...."+userName+"  "+passWord);
			
			
			while (rs.next()) {
				System.out.println("进来了查询结果就不是空");
				if (userName.equals(rs.getString(1)) && passWord.equals(rs.getString(2))){
					flag=1;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return -1;
		}finally {
			
			//closeSourse(conn, ps,rs);  // 关闭资源   jdbc 如何关闭资源？？？？？
			return flag;
		}
		
		
		
		
		//
		
	}
	
	public static void closeSourse(Connection conn,PreparedStatement st,ResultSet rs) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (st!=null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		
		
		
		
	}
	
	

}

