package com.blog.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.blog.adatabase.DataBase;
import com.blog.dao.IReviewDao;

public class ReviewDaoImp implements IReviewDao {
	private static String text="无内容";
	private static String title="无内容";
	
	public  ArrayList<String> seek(int id) {
		ResultSet rs = null;
		int count = 0;
		ArrayList<String> array= new ArrayList<>();// 这里不能直接写 array=null;
		
		String sql = "select title,text1 from tb_article_info";
		DataBase db = new DataBase("blog");
		rs = db.getResult(sql);
			
		try {
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			
		}  //移到初始位置
        if (id>count) {System.out.println("数组列表大小："+array.size());return null;};
		
		int i = 0;
		try {
			while (rs.next()) {
				try {
					title = rs.getString("title");
					text = rs.getString("text1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		}
		return array;
	
	
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

