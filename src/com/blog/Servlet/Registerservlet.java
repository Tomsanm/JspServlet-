package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.RegisterDao;
import com.blog.dao.RegisterData;


@WebServlet("/com/blog/servlet/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registerservlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 如何从请求中获取到前端数据
		System.out.println("请求已经进入 servlet...");
		// 将数据一一提取出来
		String name = request.getParameter("uname");  // 注意这里的单词一定要和前端jsp完全一致
		String pwd = request.getParameter("upwd");
		String pwdCheck = request.getParameter("upwdcheck");
		String sex = request.getParameter("usex");
		String email = request.getParameter("uemail");
		// 将数据装入 数据实体
		RegisterData data = new RegisterData();
		data.setUname(name);
		
		System.out.println("输出pwd   "+pwd+"   "+pwdCheck);
		
		if (pwd.equals(pwdCheck) && pwd != null && ("男".equals(sex) ||"女".equals(sex)) ){
			
			System.out.println("输入密码与确认密码相同的进来");
			
			data.setUpwd(pwd);
			data.setSex(sex);
			data.setuEmail(email);
		
		// 执行 数据访问层；写入数据并返回是否写入成功的页面（在dao层写一个写入数据库的静态方法）
		            int flag = RegisterDao.in_tb_user(data) ;
		
					if (flag == 1 ) {
						response.sendRedirect("/Blog_Project/registerSeccessful.jsp");
						System.out.println("数据写入成功...");
					}
					else {
						response.sendRedirect("/Blog_Project/register.jsp");
						System.out.println("数据写入不成功...");
						
					}
		}
		
		else { // 如果确认密码与输入不符跳转回注册页面
			System.out.println("密码不同  或  性别未填  ");
//			response.sendRedirect("/Blog_Project/register.jsp");
			response.sendRedirect("/Blog_Project/register.jsp");
			}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
