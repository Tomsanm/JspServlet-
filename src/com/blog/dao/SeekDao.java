package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeekDao {
	private static String text="无内容";
	private static String title="无内容";
	
	@SuppressWarnings("finally")
	public static ArrayList<String> seek(int id) {
		
		ArrayList<String> array= new ArrayList<>();// 这里不能直接写 array=null;
		
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
			return null;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/blog?serverTimezone=UTC","root","14999");
			System.out.println("连接成功");
			ps = conn.prepareStatement("select title,text1 from tb_article_info");
			rs =ps.executeQuery();
			System.out.println("输出 rs.......................");
			
//			if (id>rs.getFetchSize()) {return "";};
			rs.last();  //移到最后一行
			int count = rs.getRow();
            rs.beforeFirst();  //移到初始位置
            if (id>count) {System.out.println("数组列表大小："+array.size());return null;};
			
			int i = 0;
			while (rs.next()) {
				title = rs.getString("title");
				text = rs.getString("text1");
				
//				if(text != null) {
//					System.out.println("知道text不是null");
//					System.out.println("数据层内容为"+text);
//				return text;}
				System.out.println("执行到数据访问层了...");
				if (i==id) {
					System.out.println("id==row..");
					array.add(title);
					array.add(text);
					System.out.println("数组列表大小："+array.size());
					return array;}
				else if(id==-1){
					rs.last();  //移到最后一行
					title = rs.getString("title");
					text = rs.getString("text1");
					array.add(title);
					array.add(text);
					System.out.println("数组列表大小："+array.size());
					return array;
				}
				i++;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("出错："+array.size());
			return null;
		}finally {
			System.out.println("finally："+array.size());
			
			return array;
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

