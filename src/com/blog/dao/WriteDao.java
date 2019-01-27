package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriteDao {
	private static int id=0;

		
		@SuppressWarnings("finally")
		public static int in_tb_article_info(WriteData data) {
			
			
			int flag = 0;
			
			// 提取出 数据实体的数据
			String text = data.getText();
			String title = data.getTitle();
			System.out.println("检查pwd  text 是否传入"+text);
			
			
			
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
				
				System.out.println("声明插入   insert into tb_article_info (userName,passWord,sex,email) values(?,?,?,?)");	
				
				ps = conn.prepareStatement("insert into tb_article_info (id,title,text1) values(?,?,?)");
				
				System.out.println("执行插入...");
				id++;
				ps.setInt(1, id);
		        ps.setString(2, title);
		        ps.setString(3, text);
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


