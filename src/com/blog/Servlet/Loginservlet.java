package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.LoginDao;
import com.blog.dao.LoginData;

// 控制器层：负责接受请求，和 分派 给 Java bean

@WebServlet("/com/blog/servlet/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("控制器开始工作了");
		System.out.println("获取 请求中的登录数据");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		System.out.println("将登录数据装入login数据模型");
		
		LoginData loginData = new LoginData();
		loginData.setUname(uname);
		loginData.setUpwd(upwd);
		
		System.out.println("调用数据逻辑模型");
		
		int flag = LoginDao.check(loginData) ;
		
		// 获取到数据后，调用方法 关闭连接资源
		
		
		
		
		
		
		if (flag==1) {
			System.out.println("执行到跳转成功页面....");
			response.sendRedirect("/Blog_Project/sucess.jsp");
		}
		else {
			response.sendRedirect("/Blog_Project/error.jsp");
			System.out.println("密码错误重新登录页面....");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
