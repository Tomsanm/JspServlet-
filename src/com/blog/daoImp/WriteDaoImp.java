package com.blog.daoImp;

import com.blog.adatabase.DataBase;
import com.blog.dao.IWriteDao;
import com.blog.entity.WriteEntity;

public class WriteDaoImp implements IWriteDao{
	private static int id=0;

		
		
		public boolean in_tb_article_info(WriteEntity data) {
			
			id++;
			boolean flag = false;
			
			// 提取出 数据实体的数据
			String text = data.getText();
			String title = data.getTitle();
			System.out.println("检查pwd  text 是否传入"+text);
			
			DataBase db = new DataBase("blog");
				
			System.out.println("声明插入   insert into tb_article_info (userName,passWord,sex,email) values(?,?,?,?)");	
			
			String sql = "insert into tb_article_info (id,title,text1) values(?,?,?)";
			Object[] objs = {id,title,text};
			
			flag = db.myUpdate(sql,objs);
			
			
			return flag;
		

	}

}
