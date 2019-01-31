package com.blog.daoImp;

import com.blog.adatabase.DataBase;
import com.blog.dao.ILoginDao;
import com.blog.entity.LoginEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImp extends DataBase implements ILoginDao {
	
		public LoginDaoImp(String database_name) {
		super(database_name);
		// TODO Auto-generated constructor stub
	}
		
		
		@SuppressWarnings("finally")
		public  int check(LoginEntity logindata) {
			int flag = 0;
			String userName = logindata.uname;
			String passWord = logindata.upwd;
			String sql = "select userName,passWord from tb_user";
			ResultSet rs = getResult(sql);
		
			System.out.println("输出 rs.......................");
				
			System.out.println("接受前端数据...."+userName+"  "+passWord);
				
				
			try {
				while (rs.next()) {
						System.out.println("进来了查询结果就不是空");
						if (userName.equals(rs.getString(1)) && passWord.equals(rs.getString(2))){
							flag=1;
						}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return flag;
			}
				
				

			
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

