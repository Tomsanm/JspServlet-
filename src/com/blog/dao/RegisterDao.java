package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {

		
		@SuppressWarnings("finally")
		public static int in_tb_user(RegisterData data) {
			
			int flag = 0;
			
			// 提取出 数据实体的数据
			String uname = data.getUname();
			String pwd = data.getUpwd();
			String sex = data.getSex();
			System.out.println("检查pwd  sex 是否传入"+pwd+" "+sex);
			
			String email = data.getuEmail();
			
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
//				ps = conn.prepareStatement("select userName,passWord from tb_user");
				
				System.out.println("声明插入   insert into tb_user (userName,passWord,sex,email) values(?,?,?,?)");	
				
				ps = conn.prepareStatement("insert into tb_user (userName,passWord,sex,email) values(?,?,?,?)");
				
				System.out.println("执行插入...");
				
				ps.setString(1, uname);
		        ps.setString(2, pwd);
		        ps.setString(3, sex);
		        ps.setString(4, email);
		        flag = ps.executeUpdate();
		        ps.close();
				
				
				
				
				System.out.println("执行完毕...");
				
				
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
		
		
		
		
		
		
		
		
		
		
		
		
		

	}


