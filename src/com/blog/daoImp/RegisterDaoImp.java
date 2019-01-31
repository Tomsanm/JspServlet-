package com.blog.daoImp;


import com.blog.adatabase.DataBase;
import com.blog.dao.IRegisterDao;
import com.blog.entity.RegisterEntity;

public class RegisterDaoImp implements IRegisterDao {

		
		public  boolean in_tb_user(RegisterEntity data) {
			boolean flag = false;
			// 提取出 数据实体的数据
			String uname = data.getUname();
			String pwd = data.getUpwd();
			String sex = data.getSex();
			String email = data.getuEmail();
			System.out.println("检查pwd  sex 是否传入"+pwd+" "+sex);
			
			DataBase db = new DataBase("blog");  // 传入数据库的名字
			String sql = "insert into tb_user (userName,passWord,sex,email) values(?,?,?,?)";
			Object[] objs = {uname,pwd,sex, email};
			flag = db.myUpdate(sql,objs); // 需要修改的字段
			System.out.println("执行插入数据完毕...");
			return flag;
			
		}

	}


