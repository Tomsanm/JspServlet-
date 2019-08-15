package com.blog.adatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 通用的数据访问底层类供 Dao 包逻辑类调用  
public class DataBase {
	
	// 驱动字符串
	 static final String driver = "com.mysql.cj.jdbc.Driver";
	// 用户名
	static final String uname = "root";
	// 密码
	static final String upwd = "你的数据库密码";
	
	Connection conn = null;
	Statement sm=null;
	ResultSet rs=null;
	PreparedStatement ps = null;
	
	
    
    
	// 在构造函数中实现连接
	public DataBase(String database_name) {   // 选择数据库
		try {
			Class.forName(driver);
			// 连接字符串
			String url ="jdbc:mysql://localhost/"+database_name+"?serverTimezone=UTC"; 
			System.out.println("查看数据库连接url"+url);
			conn=DriverManager.getConnection(url,uname,upwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 实现查询 并返回结果集
	public ResultSet getResult(String sql_) {
		try {
			sm=conn.createStatement();
			rs = sm.executeQuery(sql_);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	// 实现增删改
	public boolean myUpdate(String sql,Object[] parms) { // parms = {x,x,x}
		int count=0;
		try {
			ps = conn.prepareStatement(sql);
			System.out.println("执行根据参数插入数据");
			for (int i=0;i<parms.length;i++) {
				System.out.println("看看Object"+parms[i]);
				ps.setObject(i+1,parms[i]);
			}
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (count>0) {return true;}
		else {return false;}
	}
	
	// 关闭资源
	public void close() {
	try {
		if(rs!=null)
			rs.close();
		if(sm!=null)
			sm.close();
		if(conn!=null) 
			conn.close();
		
	    } catch (SQLException e) {
			e.printStackTrace();}
	}
	
	
	
	
	
	
	

}
