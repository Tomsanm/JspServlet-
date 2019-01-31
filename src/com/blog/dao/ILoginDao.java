package com.blog.dao;

import com.blog.entity.LoginEntity;

public interface ILoginDao {
	// 验证登录数据
	public  int check(LoginEntity logindata);

}
